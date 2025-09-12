package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class EditDriverRequest {
    private String uuid;
    private Integer id;
    private Address address;
    private List<String> schedule;
    private String full_name;
    private String notes;
    private Boolean is_staff;
    private String status;
    private String warning;
    private String created_at;
    private String updated_at;
    private String driver_local_identifier;
    private List<RequestContact> contacts_phone;
    private List<RequestContact> contacts_email;
    private List<RequestContact> contacts_viber;
    private List<RequestContact> contacts_other;
    private Integer home_address_id;
    private String logbook_email;
    private String logbook_password;
    private Boolean is_local;
    private String local_state;
    private Boolean twic;
    private String ipass;
    private String driving_license_exp;
    private String medical_certification_exp;
    private String driver_number;
    private String logbook_num;

    public void setDefaultValues() {
        uuid = "9e7f17e3-0b06-4041-bf30-55bfe69f130f";
        id = 1196;
        address = new Address();
        address.setDefaultValues();
        schedule = new ArrayList<>();
        full_name = "Jonathan Da";
        notes = "";
        is_staff = true;
        status = "Off duty";
        warning = "";
        created_at = "2025-04-18T00:43:38.172250Z";
        updated_at = "2025-08-28T22:15:09.553784Z";
        driver_local_identifier = "IL";
        contacts_phone = new ArrayList<>();
        RequestContact requestContact = new RequestContact();
        requestContact.setDefaultValues();
        contacts_phone.add(requestContact);
        requestContact.setDefaultValues();
        contacts_email = new ArrayList<>();
        contacts_email.add(requestContact);
        contacts_viber = new ArrayList<>();
        contacts_viber.add(requestContact);
        contacts_other = new ArrayList<>();
        contacts_other.add(requestContact);
        home_address_id = 4119;
        logbook_email = "sdfhdsfk@gmail.com";
        logbook_password = "12546";
        is_local = true;
        local_state = "IL";
        twic = true;
        ipass = "1234543";
        driving_license_exp = "2025-04-27";
        medical_certification_exp = "2025-04-27";
        driver_number = "a";
        logbook_num = "49846";
    }
}
