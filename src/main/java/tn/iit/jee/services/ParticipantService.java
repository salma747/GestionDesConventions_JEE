package tn.iit.jee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.jee.models.Participant;
import tn.iit.jee.repository.ParticipantRepository;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> listAll() {
        return participantRepository.findAll();
    }

    public void save(Participant participant) {
        participantRepository.save(participant);
    }

    public Participant get(Long id) {
        return participantRepository.getOne(id);
    }

    public void delete(Long id) {
        participantRepository.deleteById(id);
    }
}