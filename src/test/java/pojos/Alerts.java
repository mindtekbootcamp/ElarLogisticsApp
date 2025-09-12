package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Alerts {
    private Integer id;
    private String uuid;
    private String reason;
    private Integer object_id;
    private String expiration_date;
    private Boolean is_deleted;
    private String created_at;
}
