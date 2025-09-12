package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class EditDriverResponse {
    private String uuid;
    private Integer id;
    private Address address;
    private String driver_number;
    private List<String> schedule;
    private String full_name;
    private String logbook_num;
    private String notes;
    private Boolean is_staff;
    private String status;
    private List<Alerts> alerts;
    private String warning;
    private String created_at;
    private String updated_at;
    private String driver_local_identifier;
    private List<RequestContact> contacts_phone;
    private List<RequestContact> contacts_email;
    private List<RequestContact> contacts_viber;
    private List<RequestContact> contacts_other;
}
