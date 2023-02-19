package ma.emsi.roombookingsystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Date beginRes;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private Date endRes;
    @ManyToOne
    @JoinColumn(name="salle_id",nullable = true)
    private Salle salle;
    public Materiel getMateriel(){
        return materiel;
    }
    @ManyToOne
    @JoinColumn(name = "materiel_id",nullable = true)
    private Materiel materiel;


    public Salle getSalle() {
        return salle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBeginRes() {
        return beginRes;
    }

    public void setBeginRes(Date beginRes) {
        this.beginRes = beginRes;
    }

    public Date getEndRes() {
        return endRes;
    }

    public void setEndRes(Date endRes) {
        this.endRes = endRes;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }
}
