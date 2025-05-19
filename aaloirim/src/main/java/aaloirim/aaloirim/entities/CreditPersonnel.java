package aaloirim.aaloirim.entities;

import aaloirim.aaloirim.enums.MotifPersonnel;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PERSONNEL")
public class CreditPersonnel extends Credit {
    @Enumerated(EnumType.STRING)
    private MotifPersonnel motif;
}