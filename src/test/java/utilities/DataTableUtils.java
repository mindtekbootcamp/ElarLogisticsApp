package utilities;

import pojos.Contact;

import java.util.List;
import java.util.Map;

public class DataTableUtils {

    public static String getTableValue(Map<String, Object> data, String key) {
        String name;
        if (data.get(key) == null) name = "";
        else if (data.get(key).equals("null")) name = null;
        else name = data.get(key).toString();
        return name;
    }

    public static List<Contact> getTableValueAsContactsList(Map<String, Object> data, String key) {
        List<Contact> contacts;
        if (data.get(key) == null) contacts = List.of();
        else if (data.get(key).equals("null")) contacts = null;
        else {
            Contact contact=new Contact();
            contact.setValue(data.get(key).toString());
            contacts = List.of(contact);
        }
        return contacts;
    }

    public static String compareIfNameIsUnique(Map<String, Object> dataTable, String keyInput, String valueInput) {
        if (getTableValue(dataTable, keyInput).equals(valueInput)) {
            return CarrierUtils.uuidCarrierGenerator();
        } else {
            return getTableValue(dataTable, keyInput);
        }
    }

    public static String compareIfAbbreviationIsUnique(Map<String, Object> dataTable, String keyInput, String valueInput) {
        if (getTableValue(dataTable, keyInput).equals(valueInput)) {
            return CarrierUtils.randomThreeDigitGenerator();
        } else {
            return getTableValue(dataTable, keyInput);
        }
    }

    public static String compareIfNumberIsUnique(Map<String, Object> dataTable, String keyInput, String valueInput) {
        if (getTableValue(dataTable, keyInput).equals(valueInput)) {
            return CarrierUtils.randomNumberGenerator();
        } else {
            return getTableValue(dataTable, keyInput);
        }
    }
}
