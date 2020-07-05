package tn.iit.jee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.iit.jee.models.Convention;

import java.util.List;

public interface ConventionRepository extends JpaRepository<Convention,Long> {
    @Query(value = "select * from conventions where type=:type ",nativeQuery = true)
    List<Convention> findByType(@Param("type") long type);
    @Query(value = "select * from conventions  where objet like %:objet% ",nativeQuery = true)
    List<Convention> findByObjet( @Param("objet") String objet);
    @Query(value = "select * from conventions  where type=:type and objet like %:objet% ",nativeQuery = true)
    List<Convention> findByTypeAndObjet(@Param("type") long type,
                                                 @Param("objet") String objet);
}
