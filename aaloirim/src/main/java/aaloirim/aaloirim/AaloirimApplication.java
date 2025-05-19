package aaloirim.aaloirim;

import aaloirim.aaloirim.entities.*;
import aaloirim.aaloirim.enums.MotifPersonnel;
import aaloirim.aaloirim.enums.Statut;
import aaloirim.aaloirim.enums.TypeBien;
import aaloirim.aaloirim.enums.TypeRemboursement;
import aaloirim.aaloirim.repository.ClientRepository;
import aaloirim.aaloirim.repository.CreditRepository;
import aaloirim.aaloirim.repository.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class AaloirimApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaloirimApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository,
							CreditRepository creditRepository,
							RemboursementRepository remboursementRepository) {
		return args -> {
			// Ajouter des clients
			Stream.of("Ali", "Fatima", "Omar").forEach(name -> {
				Client client = new Client();
				client.setNom(name);
				client.setEmail(name + "@gmail.com");
				clientRepository.save(client);
			});

			// Ajouter des crédits pour chaque client
			clientRepository.findAll().forEach(client -> {
				// Crédit Personnel
				CreditPersonnel creditPersonnel = new CreditPersonnel();
				creditPersonnel.setClient(client);
				creditPersonnel.setDateDemande(LocalDate.now());
				creditPersonnel.setStatut(Statut.EN_COURS);
				creditPersonnel.setMontant(50000.0);
				creditPersonnel.setDureeRemboursement(24);
				creditPersonnel.setTauxInteret(3.5);
				creditPersonnel.setMotif(MotifPersonnel.ACHAT_VOITURE);
				creditRepository.save(creditPersonnel);

				// Crédit Immobilier
				CreditImmobilier creditImmobilier = new CreditImmobilier();
				creditImmobilier.setClient(client);
				creditImmobilier.setDateDemande(LocalDate.now());
				creditImmobilier.setStatut(Statut.ACCEPTE);
				creditImmobilier.setDateAcception(LocalDate.now());
				creditImmobilier.setMontant(200000.0);
				creditImmobilier.setDureeRemboursement(120);
				creditImmobilier.setTauxInteret(2.8);
				creditImmobilier.setTypeBien(TypeBien.APPARTEMENT);
				creditRepository.save(creditImmobilier);

				// Crédit Professionnel
				CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
				creditProfessionnel.setClient(client);
				creditProfessionnel.setDateDemande(LocalDate.now());
				creditProfessionnel.setStatut(Statut.REJETE);
				creditProfessionnel.setMontant(100000.0);
				creditProfessionnel.setDureeRemboursement(60);
				creditProfessionnel.setTauxInteret(4.0);
				creditProfessionnel.setMotif(MotifPersonnel.TRAVAUX);
				creditProfessionnel.setRaisonSociale("Entreprise " + client.getNom());
				creditRepository.save(creditProfessionnel);
			});

			// Ajouter des remboursements pour chaque crédit
			creditRepository.findAll().forEach(credit -> {
				for (int i = 0; i < 3; i++) {
					Remboursement remboursement = new Remboursement();
					remboursement.setCredit(credit);
					remboursement.setDate(LocalDate.now().minusDays(i * 30));
					remboursement.setMontant(credit.getMontant() / credit.getDureeRemboursement());
					remboursement.setType(i % 2 == 0 ? TypeRemboursement.MENSUALITE : TypeRemboursement.REMBOURSEMENT_ANTICIPE);
					remboursementRepository.save(remboursement);
				}
			});
		};
	}
}
