package ma.emsi.roombookingsystem.dao;

import ma.emsi.roombookingsystem.entities.Salle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle,Long> {
    Salle findById(int id);
    @RestResource(path = "/byDesignation")
    public List<Salle> findByDesignationContains(@Param("mc") String des);
    @RestResource(path = "/byDesignationPage")
    public Page<Salle> findByDesignationContains(@Param("mc") String des, Pageable pageable);
}
