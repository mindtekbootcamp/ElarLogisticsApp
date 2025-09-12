package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestContact {
    private Integer id;
    private String uuid;
    private String name;
    private String value;
    private String type;

    public void setDefaultValues(){
        id = 7520;
        uuid = "491f60d3-c07d-45d8-8967-e331870f0899";
        name = "";
        value = "+1 (313) 456-4455";
        type = "Phone";
    }
}
