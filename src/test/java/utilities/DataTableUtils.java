package utilities;

import java.util.Map;

public class DataTableUtils {

    public static String getTableValue(Map<String, Object> data, String key) {
        String name;
        if (data.get(key) == null) name = "";
        else if (data.get(key).equals("null")) name = null;
        else name = data.get(key).toString();
        return name;
    }

    public static String compareIfUnique(Map<String, Object> dataTable, String keyInput, String valueInput) {
        if (getTableValue(dataTable, keyInput).equals(valueInput)) {
            return CarrierUtils.uuidCarrierGenerator();
        } else {
            return getTableValue(dataTable, keyInput);
        }
    }
}
