package aaloirim.aaloirim.dto;

import aaloirim.aaloirim.enums.MotifPersonnel;
import lombok.Data;

@Data
public class CreditPersonnelDTO extends CreditDTO {
    private MotifPersonnel motif;
}
