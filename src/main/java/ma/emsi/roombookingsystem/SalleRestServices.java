package ma.emsi.roombookingsystem;


import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;
import ma.emsi.roombookingsystem.dao.SalleRepository;
import ma.emsi.roombookingsystem.entities.Salle;
import ma.emsi.roombookingsystem.imagesService.storageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RestController
public class SalleRestServices {
    @Autowired
    private storageService storageservice;
    List<String> files = new ArrayList<String>();
    @Autowired
    private SalleRepository salleRepository;
    @GetMapping(path = "/photoSalle/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Salle salle=salleRepository.findById(id).get();
       return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/roomBooking/rooms/"+salle.getPhotoName()));
}
    @PostMapping(path = "/uploadPhoto")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageservice.store(file);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
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
