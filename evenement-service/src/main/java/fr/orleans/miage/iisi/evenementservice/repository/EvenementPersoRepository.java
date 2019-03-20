package fr.orleans.miage.iisi.evenementservice.repository;

import fr.orleans.miage.iisi.evenementservice.domain.EvenementPerso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvenementPersoRepository extends JpaRepository<EvenementPerso, Long> {
    List<EvenementPerso> findByIdUser(Long idUser);
}
