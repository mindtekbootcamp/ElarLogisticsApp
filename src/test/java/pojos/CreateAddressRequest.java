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

    public void setDefaultValues(){
        address = "123 abc";
        city = "Chicago";
        state = "IL";
        zip_code = "60656";
        name = "abc";
    }
}
