package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CreateDriverResponse {

    private String uuid;
    private Integer id;
    private List<Object> schedule;
    private String full_name;
    private Boolean is_staff;
    private String status;
    private List<Object> alerts;
    private String created_at;
    private String updated_at;
    private String driver_local_identifier;
    private List<Contact> contacts_phone;
    private List<Contact> contacts_email;
    private List<Contact> contacts_viber;
    private List<Contact> contacts_other;

}
