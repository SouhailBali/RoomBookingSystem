package ma.emsi.roombookingsystem;

import ma.emsi.roombookingsystem.dao.ReservationRepository;
import ma.emsi.roombookingsystem.dao.SalleRepository;
import ma.emsi.roombookingsystem.entities.Reservation;
import ma.emsi.roombookingsystem.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RoomBookingSystemApplication implements CommandLineRunner {
    @Autowired
private SalleRepository salleRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RepositoryRestConfiguration restConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(RoomBookingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Salle.class);
        restConfiguration.exposeIdsFor(Reservation.class);
      Reservation reservation1=new Reservation();
      reservation1.setSalle(null);
        reservation1.setBeginRes(new Date(2012,12,6,17,54,0));
        reservation1.setEndRes(new Date(2020,12,6,17,54,0));
        Reservation reservation2=new Reservation();
        reservation2.setBeginRes(new Date(3012,12,6,17,54,0));
        reservation2.setEndRes(new Date(3020,12,6,17,54,0));
        Salle salle1=new Salle(null, "Souhail", 100, "3C",null,null);
        salleRepository.save(salle1);
        reservation1.setSalle(salle1);
        reservation2.setSalle(salle1);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);

      /*  Salle sa = salleRepository.save(new Salle(null, "Najm", 35, "8E",null,null));
       reservationRepository.save(new Reservation(null,new Date(2012,12,6,17,54,0),new Date(2012,12,6,17,54,0),sa));
Reservation ra=new Reservation(null,new Date(2012,12,6,17,54,0),new Date(2012,12,6,17,54,0),null);
ra.setSalle(sa);
System.out.println(ra);*/
       /* salleRepository.save(new Salle(null,"grande taille",50,"5A"));
 salleRepository.save(new Salle(null,"petite taille",20,"1A"));
salleRepository.save(new Salle(null,"moyenne taille",35,"8E"));
salleRepository.save(new Salle(null,"amphi",100,"2C"));
salleRepository.save(new Salle(null,"moyenne",35,"4B"));
salleRepository.findAll().forEach(s->{System.out.println((s.toString()));});*/
    }
}
