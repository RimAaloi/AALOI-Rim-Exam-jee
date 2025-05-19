package aaloirim.aaloirim.dto;

import aaloirim.aaloirim.enums.Statut;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private Statut statut;
    private LocalDate dateAcception;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
    private Long clientId;
    private String typeCredit; // "PERSONNEL", "IMMOBILIER", "PROFESSIONNEL"
}
