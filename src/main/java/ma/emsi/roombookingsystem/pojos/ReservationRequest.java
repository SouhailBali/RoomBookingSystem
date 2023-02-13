package ma.emsi.roombookingsystem.pojos;

import ma.emsi.roombookingsystem.entities.Salle;

import java.util.Date;

public class ReservationRequest {
    public Long id;
    public Date beginRes;
    public Date endRes;
    public int salle_id;
    public String photoName;
}
