package ma.emsi.roombookingsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Salle implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String designation;
    private int capacite;
    private String nom;
    private String photoName;
    @JsonIgnore
    @OneToMany(mappedBy = "salle",fetch = FetchType.EAGER)
    private Set<Reservation> reservations=new HashSet<Reservation>();
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private List<Materiel> materiels=new ArrayList<Materiel>();
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setSalle(this);
    }
}
