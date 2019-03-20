package fr.orleans.miage.iisi.evenementservice.repository;

import fr.orleans.miage.iisi.evenementservice.domain.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
