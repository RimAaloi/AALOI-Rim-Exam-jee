package aaloirim.aaloirim.dto;

import aaloirim.aaloirim.enums.MotifPersonnel;
import lombok.Data;

@Data
public class CreditProfessionnelDTO extends CreditDTO {
    private MotifPersonnel motif;
    private String raisonSociale;
}
