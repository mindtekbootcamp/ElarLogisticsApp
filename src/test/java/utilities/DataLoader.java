package utilities;

import io.restassured.response.Response;
import pojos.CreateAddressRequest;
import pojos.CreateCarrierRequest;
import pojos.CreateDriverRequest;
import pojos.EditDriverRequest;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {

    public static Map<String, Object> dataLoader;
    public static Map<String, Response> responseData;
    public static CreateAddressRequest createAddressRequest;
    public static CreateCarrierRequest createCarrierRequest;
    public static CreateDriverRequest createDriverRequest;
    public static EditDriverRequest editDriverRequest;
    public static String token;


    static {
        dataLoader = new HashMap<>();
        responseData = new HashMap<>();
        createAddressRequest = new CreateAddressRequest();
        createCarrierRequest = new CreateCarrierRequest();
        createDriverRequest = new CreateDriverRequest();
        editDriverRequest = new EditDriverRequest();
    }

}
