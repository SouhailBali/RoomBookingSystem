package ma.emsi.roombookingsystem.dao;

import ma.emsi.roombookingsystem.entities.Materiel;
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
public interface MaterielRepository extends JpaRepository<Materiel,Long> {
Materiel findById(int id);
    @RestResource(path = "/byNom")
    public List<Materiel> findByNomContains(@Param("mc") String no);
    @RestResource(path = "/byNomPage")
    public Page<Materiel> findByNomContains(@Param("mc") String no, Pageable pageable);
}
