package aaloirim.aaloirim.repository;

import aaloirim.aaloirim.entities.Credit;
import aaloirim.aaloirim.enums.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    // Rechercher les crédits d'un client spécifique
    List<Credit> findByClientId(Long clientId);

    // Rechercher les crédits par statut
    List<Credit> findByStatut(Statut statut);

    // Rechercher les crédits d'un client avec un statut spécifique
    List<Credit> findByClientIdAndStatut(Long clientId, Statut statut);
}
