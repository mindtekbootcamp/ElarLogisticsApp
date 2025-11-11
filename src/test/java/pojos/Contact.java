package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Contact {

    //private String name;
    private String value;
    //private String type;

    public void setDefaultValues() {
        //name="";
        value = "+1 (234) 567 8900";
        //type="";
    }

}
