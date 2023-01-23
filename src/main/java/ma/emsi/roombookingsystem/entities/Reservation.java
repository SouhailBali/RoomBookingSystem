package ma.emsi.roombookingsystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;
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

    public Salle getSalle() {
        return salle;
    }
}
