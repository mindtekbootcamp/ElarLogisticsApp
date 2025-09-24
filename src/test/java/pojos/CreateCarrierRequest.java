package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utilities.CarrierAPIUtils;

@Getter
@Setter
@ToString
public class CreateCarrierRequest {
    private String carrier_name;
    private String carrier_type;
    private String abbreviation;
    private String status;
    private String mc_number;
    private String dot_number;
    private String ifta;
    private Integer address_id;
    private String insurance;
    private String policy_expiration;
    private String policy_number;

    public void setDefaultValues() {
        carrier_name = CarrierAPIUtils.uuidCarrierGenerator();
        carrier_type = "Broker company";
        abbreviation = CarrierAPIUtils.randomAbbreviationGenerator();
        status = "Active";
        mc_number = CarrierAPIUtils.randomNumberGenerator();
        dot_number = CarrierAPIUtils.randomNumberGenerator();
        ifta = "false";
        address_id = 4187;
        insurance = "Cucumber Insurance";
        policy_expiration = "2026-09-30";
        policy_number = "1234567890";
    }
}
