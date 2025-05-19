package aaloirim.aaloirim.controller;

import aaloirim.aaloirim.dto.ClientDTO;
import aaloirim.aaloirim.dto.CreditDTO;
import aaloirim.aaloirim.dto.RemboursementDTO;
import aaloirim.aaloirim.services.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CreditRestController {

    @Autowired
    private CreditService creditService;

    // Gestion des clients
    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        ClientDTO savedClient = creditService.saveClient(clientDTO);
        return ResponseEntity.ok(savedClient);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = creditService.listClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO client = creditService.getClient(id);
        return ResponseEntity.ok(client);
    }

    // Gestion des crédits
    @PostMapping("/credits")
    public ResponseEntity<CreditDTO> createCredit(@RequestBody CreditDTO creditDTO) {
        CreditDTO savedCredit = creditService.saveCredit(creditDTO);
        return ResponseEntity.ok(savedCredit);
    }

    @GetMapping("/credits")
    public ResponseEntity<List<CreditDTO>> getAllCredits() {
        List<CreditDTO> credits = creditService.listCredits();
        return ResponseEntity.ok(credits);
    }

    @GetMapping("/credits/{id}")
    public ResponseEntity<CreditDTO> getCreditById(@PathVariable Long id) {
        CreditDTO credit = creditService.getCredit(id);
        return ResponseEntity.ok(credit);
    }

    @GetMapping("/clients/{clientId}/credits")
    public ResponseEntity<List<CreditDTO>> getCreditsByClient(@PathVariable Long clientId) {
        List<CreditDTO> credits = creditService.listCredits().stream()
                .filter(credit -> credit.getClientId().equals(clientId))
                .toList();
        return ResponseEntity.ok(credits);
    }

    // Gestion des remboursements
    @PostMapping("/remboursements")
    public ResponseEntity<RemboursementDTO> createRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        RemboursementDTO savedRemboursement = creditService.saveRemboursement(remboursementDTO);
        return ResponseEntity.ok(savedRemboursement);
    }

    @GetMapping("/remboursements")
    public ResponseEntity<List<RemboursementDTO>> getAllRemboursements() {
        List<RemboursementDTO> remboursements = creditService.listRemboursements();
        return ResponseEntity.ok(remboursements);
    }

    @GetMapping("/credits/{creditId}/remboursements")
    public ResponseEntity<List<RemboursementDTO>> getRemboursementsByCredit(@PathVariable Long creditId) {
        List<RemboursementDTO> remboursements = creditService.getRemboursementsByCredit(creditId);
        return ResponseEntity.ok(remboursements);
    }
}