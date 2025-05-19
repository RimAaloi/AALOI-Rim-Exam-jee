package aaloirim.aaloirim.repository;

import aaloirim.aaloirim.entities.Remboursement;
import aaloirim.aaloirim.enums.TypeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    // Rechercher les remboursements d'un crédit spécifique
    List<Remboursement> findByCreditId(Long creditId);

    // Rechercher les remboursements d'un crédit par type
    List<Remboursement> findByCreditIdAndType(Long creditId, TypeRemboursement type);
}
