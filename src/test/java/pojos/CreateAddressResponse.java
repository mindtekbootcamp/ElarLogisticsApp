package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateAddressResponse {
    private String address;
    private String city;
    private String state;
    private String zip_code;
    private String name;
    private Integer id;
    private String uuid;
    private String created_at;
    private String update_at;
}

