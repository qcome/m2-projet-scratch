package fr.orleans.miage.iisi.evenementservice.service;

import fr.orleans.miage.iisi.evenementservice.domain.Evenement;
import fr.orleans.miage.iisi.evenementservice.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {

    @Autowired
    EvenementRepository evenementRepository;

    public Page<Evenement> getEvenementsPage(int page, int limit) {
        return evenementRepository.findAll(PageRequest.of(page, limit));
    }
}
