package tn.iit.jee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.jee.models.Convention;
import tn.iit.jee.repository.ConventionRepository;

import java.util.List;

@Service
public class ConventionService {
    @Autowired
    private ConventionRepository conventionRepository;

    public List<Convention> listAll(){
        return conventionRepository.findAll();
    }
    public void save(Convention convention){
        conventionRepository.save(convention);
    }
    public Convention get(Long id){
        return conventionRepository.findById(id).get();
    }
    public void delete(Long id){
        conventionRepository.deleteById(id);
    }
}
