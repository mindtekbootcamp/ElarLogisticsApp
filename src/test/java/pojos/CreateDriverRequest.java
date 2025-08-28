package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CreateDriverRequest {

    private String full_name;
    private String logbook_email;
    private String logbook_password;
    private Boolean is_staff;
    private Boolean is_local;
    private Boolean twic;
    private String driving_license_exp;
    private String medical_certification_exp;
    private List<Contact> contacts_phone;
    private List<Contact> contacts_email;
    private List<Contact> contacts_viber;
    private List<Contact> contacts_other;

    public void setDefaultValues(){
        full_name="John Doe";
        logbook_email="";
        logbook_password="";
        is_staff=false;
        is_local=false;
        twic=false;
        driving_license_exp="2025-12-12";
        medical_certification_exp="2025-12-12";
        contacts_phone=new ArrayList<>();
        contacts_email=new ArrayList<>();
        contacts_viber=new ArrayList<>();
        contacts_other=new ArrayList<>();
    }


}
