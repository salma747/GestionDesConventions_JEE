package tn.iit.jee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iit.jee.models.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
