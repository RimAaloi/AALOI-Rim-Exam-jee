package aaloirim.aaloirim.mappers;

import aaloirim.aaloirim.dto.*;
import aaloirim.aaloirim.entities.*;
import org.springframework.stereotype.Component;

@Component
public class CreditMapper {

    // Client
    public ClientDTO toClientDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setEmail(client.getEmail());
        return dto;
    }

    public Client toClient(ClientDTO dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
        return client;
    }

    // Credit
    public CreditDTO toCreditDTO(Credit credit) {
        CreditDTO dto;
        if (credit instanceof CreditPersonnel) {
            CreditPersonnelDTO personnelDTO = new CreditPersonnelDTO();
            personnelDTO.setMotif(((CreditPersonnel) credit).getMotif());
            dto = personnelDTO;
        } else if (credit instanceof CreditImmobilier) {
            CreditImmobilierDTO immobilierDTO = new CreditImmobilierDTO();
            immobilierDTO.setTypeBien(((CreditImmobilier) credit).getTypeBien());
            dto = immobilierDTO;
        } else if (credit instanceof CreditProfessionnel) {
            CreditProfessionnelDTO professionnelDTO = new CreditProfessionnelDTO();
            professionnelDTO.setMotif(((CreditProfessionnel) credit).getMotif());
            professionnelDTO.setRaisonSociale(((CreditProfessionnel) credit).getRaisonSociale());
            dto = professionnelDTO;
        } else {
            dto = new CreditDTO();
        }

        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient().getId());
        dto.setTypeCredit(credit.getClass().getSimpleName().replace("Credit", "").toUpperCase());
        return dto;
    }

    public Credit toCredit(CreditDTO dto) {
        Credit credit;
        if (dto instanceof CreditPersonnelDTO) {
            credit = new CreditPersonnel();
            ((CreditPersonnel) credit).setMotif(((CreditPersonnelDTO) dto).getMotif());
        } else if (dto instanceof CreditImmobilierDTO) {
            credit = new CreditImmobilier();
            ((CreditImmobilier) credit).setTypeBien(((CreditImmobilierDTO) dto).getTypeBien());
        } else if (dto instanceof CreditProfessionnelDTO) {
            credit = new CreditProfessionnel();
            ((CreditProfessionnel) credit).setMotif(((CreditProfessionnelDTO) dto).getMotif());
            ((CreditProfessionnel) credit).setRaisonSociale(((CreditProfessionnelDTO) dto).getRaisonSociale());
        } else {
            throw new IllegalArgumentException("Unknown credit type");
        }

        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcception(dto.getDateAcception());
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        return credit;
    }

    // Remboursement
    public RemboursementDTO toRemboursementDTO(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());
        dto.setCreditId(remboursement.getCredit().getId());
        return dto;
    }

    public Remboursement toRemboursement(RemboursementDTO dto) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(dto.getType());
        return remboursement;
    }
}
