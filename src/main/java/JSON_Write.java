import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON_Write {
    public static void main(String[] args) {
        JSONObject catalog = new JSONObject();

        // Добавление элементов в объект JSON
        catalog.put("laptops", new JSONArray());
        catalog.put("brands", new JSONArray());
        catalog.put("processors", new JSONArray());

        JSONObject laptop1 = new JSONObject();
        laptop1.put("id", "1");
        laptop1.put("brand", "Apple");
        laptop1.put("model", "MacBook Pro");
        laptop1.put("screen_size", 13.3);
        laptop1.put("resolution", "2560x1600");

        JSONObject processor1 = new JSONObject();
        processor1.put("name", "Intel Core i5");
        processor1.put("clock_speed", "2.4 GHz");
        processor1.put("cores", 4);
        laptop1.put("processor", processor1);

        JSONObject memory1 = new JSONObject();
        memory1.put("size", "8 GB");
        memory1.put("type", "DDR4");
        laptop1.put("memory", memory1);

        JSONObject storage1 = new JSONObject();
        storage1.put("type", "SSD");
        storage1.put("size", "256 GB");
        laptop1.put("storage", storage1);

        laptop1.put("price", 1499.00);
        ((JSONArray) catalog.get("laptops")).add(laptop1);

        // Добавление оставшихся двух ноутбуков, элементов brands и processors в объект JSON

        // Создание файла и запись в него JSON-объекта
        try (FileWriter file = new FileWriter("Laptops.json")) {
            file.write(catalog.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
