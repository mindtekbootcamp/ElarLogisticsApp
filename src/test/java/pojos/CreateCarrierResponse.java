package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreateCarrierResponse {
    private Integer id;
    private String uuid;
    private List<Object> alerts;
    private Address address;
    private String carrier_name;
    private String carrier_type;
    private String status;
    private String mc_number;
    private String dot_number;
    private String ifta;
    private String insurance;
    private String policy_expiration;
    private String policy_number;
    private Boolean other_licenses;
    private String created_at;
    private String updated_at;
    private String abbreviation;
    private List<Contact> contacts_phone;
    private List<Contact> contacts_fax;
    private List<Contact> contacts_email;
}
