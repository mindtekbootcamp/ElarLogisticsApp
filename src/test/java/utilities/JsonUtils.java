package utilities;

import com.github.wnameless.json.flattener.JsonFlattener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    public static String getJson(String jsonName) {
        String path = "src/test/resources/data/" + jsonName + ".json";
        JSONParser jsonParser = new JSONParser();
        String data;

        try {
            FileReader reader = new FileReader(path);
            data = jsonParser.parse(reader).toString();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static Map<String, Object> getUpdatedCarrierPutRequestBody() {
        String jsonData = getJson("EditCarriersRequest");
        Map<String, Object> jsonMap = JsonFlattener.flattenAsMap(jsonData);
        int carrierID = DataLoader.responseData.get("postResponse").body().jsonPath().getInt("id");
        String mc_number = DataLoader.responseData.get("postResponse").body().jsonPath().get("mc_number");
        String dot_number = DataLoader.responseData.get("postResponse").body().jsonPath().get("dot_number");
        String abbreviation = DataLoader.responseData.get("postResponse").body().jsonPath().get("abbreviation");
        String carrier_name = DataLoader.responseData.get("postResponse").body().jsonPath().get("carrier_name");
        jsonMap.put("id", carrierID);
        jsonMap.put("mc_number", mc_number);
        jsonMap.put("dot_number", dot_number);
        jsonMap.put("abbreviation", abbreviation);
        jsonMap.put("carrier_name", carrier_name);
        return jsonMap;
    }
}
