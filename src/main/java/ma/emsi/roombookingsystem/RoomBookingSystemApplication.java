package ma.emsi.roombookingsystem;

import ma.emsi.roombookingsystem.dao.SalleRepository;
import ma.emsi.roombookingsystem.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomBookingSystemApplication implements CommandLineRunner {
    @Autowired
private SalleRepository salleRepository;
    public static void main(String[] args) {
        SpringApplication.run(RoomBookingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/* salleRepository.save(new Salle(null,"grande taille",50,"5A"));
salleRepository.save(new Salle(null,"petite taille",20,"1A"));
salleRepository.save(new Salle(null,"moyenne taille",35,"8E"));
salleRepository.save(new Salle(null,"amphi",100,"2C"));
salleRepository.save(new Salle(null,"moyenne",35,"4B")); */
salleRepository.findAll().forEach(s->{System.out.println((s.toString()));});
    }
}
