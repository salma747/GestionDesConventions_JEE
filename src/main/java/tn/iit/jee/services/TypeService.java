package tn.iit.jee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.iit.jee.models.Type;
import tn.iit.jee.repository.TypeRepository;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    public List<Type> listAll(){
        return typeRepository.findAll();
    }
    public void save(Type product){
        typeRepository.save(product);
    }
    public Type get(Long id){
        return typeRepository.getOne(id);
    }
    public void delete(Long id){
        typeRepository.deleteById(id);
    }
}
