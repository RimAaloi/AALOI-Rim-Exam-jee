package aaloirim.aaloirim.repository;

import aaloirim.aaloirim.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Rechercher un client par email (utile pour vérifier si un client existe déjà)
    Optional<Client> findByEmail(String email);
}
