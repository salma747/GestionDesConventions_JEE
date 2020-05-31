package tn.iit.jee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iit.jee.models.Convention;

public interface ConventionRepository extends JpaRepository<Convention,Long> {

}
