package ma.emsi.roombookingsystem;

import ma.emsi.roombookingsystem.dao.SalleRepository;
import ma.emsi.roombookingsystem.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SalleRestServices {
    @Autowired
    private SalleRepository salleRepository;
    @GetMapping(value="/sallelist")
    List<Salle> salleList(){
return salleRepository.findAll();
    }
    @GetMapping(value="/sallelist/{id}")
    Salle salleList(@PathVariable(name = "id") Long id){
        return salleRepository.findById(id).get();
    }
    @PutMapping(value="/sallelist/{id}")
    Salle update(@PathVariable(name="id") Long id,@RequestBody Salle salle){
    salle.setId(id);
    return salleRepository.save(salle);
    }
    @PostMapping(value="/sallelist")
    Salle save(@RequestBody Salle salle){
        return salleRepository.save(salle);
    }
    @DeleteMapping(value="/sallelist/{id}")
    void delete(@PathVariable(name="id") Long id){
        salleRepository.deleteById(id);
    }
}
