package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
    private Integer id;
    private String uuid;
    private String full_address;
    private String address;
    private String city;
    private String state;
    private String zip_code;
    private String name;
    private String created_at;
    private String updated_at;
    private String apt_suite_company_co;

    public void setDefaultValues() {
        address = "Tester St";
        city = "Testerville";
        state = "IL";
        zip_code = "60000";
        name = "Test Address";
        id = 4200;
        uuid = "1a5558f6-6d64-46f4-96df-5d6ce33b2f35";
        full_address = "Tester St Testerville IL 60000";
        created_at = "2025-08-28T22:14:52.953863Z";
        updated_at = "2025-08-28T22:14:53.057896Z";
    }
}
