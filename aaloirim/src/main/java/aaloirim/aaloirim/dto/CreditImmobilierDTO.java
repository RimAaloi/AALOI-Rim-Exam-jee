package aaloirim.aaloirim.dto;

import aaloirim.aaloirim.enums.TypeBien;
import lombok.Data;

@Data
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}
