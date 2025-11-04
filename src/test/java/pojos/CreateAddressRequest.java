package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAddressRequest {
    private String address;
    private String city;
    private String state;
    private String zip_code;
    private String name;
    private Integer id;
    private String uuid;
    private String full_address;
    private String created_at;
    private String updated_at;

    public void setDefaultValues(){
        address = "123 Test Ave";
        city = "Chicago";
        state = "IL";
        zip_code = "60000";
        name = "Test Address";
        id = 3000;
        uuid = "c67cfb2a-cef0-40d7-a43f-4c58c64f36d3";
        full_address = "123 Test Ave Chiciago IL 60000";
        created_at = "2025-03-03T19:53:23.202288Z";
        updated_at = "2025-03-03T19:53:23.202288Z";
    }
}
