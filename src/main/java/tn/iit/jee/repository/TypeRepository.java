package tn.iit.jee.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.jee.models.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
}
