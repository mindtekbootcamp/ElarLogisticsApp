package utilities;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class CsvUtils {
    public static List<Map<String, Object>> readCsvAsListOfMaps(String filePath) throws IOException {
        List<Map<String, Object>> records = new ArrayList<>();
        String path = System.getProperty("user.dir") + "/src/test/resources/data/"+filePath+".csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                return records; // empty file
            }

            String[] headers = headerLine.split(",");

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1); // -1 keeps empty values
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    String key = headers[i].trim();
                    String value = i < values.length ? values[i].trim() : "";
                    row.put(key, value);
                }
                records.add(row);
            }
        }
        return records;
    }
}
