package ma.emsi.roombookingsystem.dao;

import jakarta.transaction.Transactional;
import ma.emsi.roombookingsystem.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

@RestResource(path = "/byId")
    public List<Reservation> findById(@Param("mc") String id);
    @RestResource(path = "/byIdPage")
    public Page<Reservation> findById(@Param("mc") Long id, Pageable pageable);
    @RestResource(path="/all")
    public Page<Reservation> findAll(Pageable pageable);
    @Modifying
    @Query(value = "insert into reservation (begin_res, end_res, salle_id) values (beginRes,endRes,salle_id);",nativeQuery = true)
    void saves(@Param("beginRes") Date beginRes, @Param("endRes") Date endRes, @Param("salle_id") Long salle_id);
}

