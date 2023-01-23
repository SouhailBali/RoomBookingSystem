package ma.emsi.roombookingsystem;

import com.fasterxml.jackson.annotation.JsonFormat;
import ma.emsi.roombookingsystem.dao.ReservationRepository;
import ma.emsi.roombookingsystem.dao.SalleRepository;
import ma.emsi.roombookingsystem.entities.Reservation;
import ma.emsi.roombookingsystem.entities.Salle;
import ma.emsi.roombookingsystem.pojos.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin("*")
@RestController
public class ReservationRestServices {
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @GetMapping(value="/reservationlist")
    Page<Reservation> reservationList(@RequestParam(name = "page", defaultValue = "0") int page){
        return reservationRepository.findAll(PageRequest.of(page, 5));
    }
    @GetMapping(value="/reservationlist/{id}")
    Page<Reservation> reservationList(@RequestParam(name = "page", defaultValue = "0") int page,@PathVariable(name = "id") Long id){
        return reservationRepository.findById(id,PageRequest.of(page,5));
    }
    @PutMapping(value="/reservationlist/{id}")
    Reservation update(@PathVariable(name="id") Long id,@RequestBody Reservation reservation){
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }
   /* @PostMapping(value="/reservationlist")
    void saves(@RequestBody @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm",shape = JsonFormat.Shape.STRING) Date beginRes, @RequestBody @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm",shape = JsonFormat.Shape.STRING) Date endRes, @RequestBody Long salle_id){
        reservationRepository.saves(beginRes,endRes,salle_id);
    }*/
   @PostMapping(value="/reservationlist")
   Reservation save(@RequestBody ReservationRequest reservationRequest){
       Salle salle=salleRepository.findById(reservationRequest.salle_id);
       Reservation reservation=new Reservation();
       reservation.setBeginRes(reservationRequest.beginRes);
       reservation.setEndRes(reservationRequest.endRes);
       reservation.setSalle(salle);
       return reservationRepository.save(reservation);
   }
    @DeleteMapping(value="/reservationlist/{id}")
    void delete(@PathVariable(name="id") Long id){
        reservationRepository.deleteById(id);
    }
}
