package fr.orleans.miage.iisi.evenementservice.service;

import fr.orleans.miage.iisi.evenementservice.domain.EvenementPerso;
import fr.orleans.miage.iisi.evenementservice.repository.EvenementPersoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementPersoService {
    @Autowired
    EvenementPersoRepository evenementPersoRepository;

    public void delete(Long id){
        this.evenementPersoRepository.deleteById(id);
    }


    public EvenementPerso saveEvenementPerso(EvenementPerso evenementPerso){
        return this.evenementPersoRepository.save(evenementPerso);
    }
    public void insertEvenementsPerso(List<EvenementPerso> evenementsPerso){
        this.evenementPersoRepository.saveAll(evenementsPerso);
    }

    public List<EvenementPerso> getEvenementPersoByUser(Long idUser){
        return this.evenementPersoRepository.findByIdUser(idUser);
    }

    public Optional<EvenementPerso> getEvenementPersoById(Long id){
         return evenementPersoRepository.findById(id);
    }

    public List<EvenementPerso> getEvenementsPerso(){
        return evenementPersoRepository.findAll();
    }
}
