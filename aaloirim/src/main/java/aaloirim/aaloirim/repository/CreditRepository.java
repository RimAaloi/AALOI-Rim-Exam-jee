package aaloirim.aaloirim.repository;

import aaloirim.aaloirim.entities.Credit;
import aaloirim.aaloirim.enums.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    List<Credit> findByClientId(Long clientId);


    List<Credit> findByStatut(Statut statut);

    List<Credit> findByClientIdAndStatut(Long clientId, Statut statut);
}
