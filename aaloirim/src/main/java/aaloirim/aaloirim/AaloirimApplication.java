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


}
