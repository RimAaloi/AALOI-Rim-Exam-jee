package aaloirim.aaloirim.services;

import aaloirim.aaloirim.dto.ClientDTO;
import aaloirim.aaloirim.dto.CreditDTO;
import aaloirim.aaloirim.dto.RemboursementDTO;
import aaloirim.aaloirim.entities.Client;
import aaloirim.aaloirim.entities.Credit;
import aaloirim.aaloirim.entities.Remboursement;
import aaloirim.aaloirim.mappers.CreditMapper;
import aaloirim.aaloirim.repository.ClientRepository;
import aaloirim.aaloirim.repository.CreditRepository;
import aaloirim.aaloirim.repository.RemboursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private RemboursementRepository remboursementRepository;

    @Autowired
    private CreditMapper creditMapper;

    // Gestion des clients
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = creditMapper.toClient(clientDTO);
        client = clientRepository.save(client);
        return creditMapper.toClientDTO(client);
    }

    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(creditMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return creditMapper.toClientDTO(client);
    }

    // Gestion des crédits
    public CreditDTO saveCredit(CreditDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Credit credit = creditMapper.toCredit(creditDTO);
        credit.setClient(client);
        credit = creditRepository.save(credit);
        return creditMapper.toCreditDTO(credit);
    }

    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream()
                .map(creditMapper::toCreditDTO)
                .collect(Collectors.toList());
    }

    public CreditDTO getCredit(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        return creditMapper.toCreditDTO(credit);
    }

    // Gestion des remboursements
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        Remboursement remboursement = creditMapper.toRemboursement(remboursementDTO);
        remboursement.setCredit(credit);
        remboursement = remboursementRepository.save(remboursement);
        return creditMapper.toRemboursementDTO(remboursement);
    }

    public List<RemboursementDTO> listRemboursements() {
        return remboursementRepository.findAll().stream()
                .map(creditMapper::toRemboursementDTO)
                .collect(Collectors.toList());
    }

    public List<RemboursementDTO> getRemboursementsByCredit(Long creditId) {
        return remboursementRepository.findByCreditId(creditId).stream()
                .map(creditMapper::toRemboursementDTO)
                .collect(Collectors.toList());
    }
}