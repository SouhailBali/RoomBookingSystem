package ma.emsi.roombookingsystem.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="S1",types = Salle.class)
public interface SalleProjection {
   int getCapacite();
   String getDesignation();
}
