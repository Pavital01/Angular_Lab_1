import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JSON_Parser {
    public static void main(String[] args) {
        // Create a new JSON parser object
        JSONParser parser = new JSONParser();

        try {
            // Parse the JSON file
            Object obj = parser.parse(new FileReader("Laptops.json"));

            // Get the JSON object from the file
            JSONObject jsonObject = (JSONObject) obj;

            // Get the laptops array from the JSON object
            JSONArray laptops = (JSONArray) jsonObject.get("catalog");

            // Loop over the laptops array
            for (Object laptop : laptops) {
                JSONObject laptopObject = (JSONObject) laptop;

                // Get the laptop details
                String id = (String) laptopObject.get("id");
                String brand = (String) laptopObject.get("brand");
                String model = (String) laptopObject.get("model");
                double screenSize = (double) laptopObject.get("screen_size");
                String resolution = (String) laptopObject.get("resolution");

                // Get the processor details
                JSONObject processorObject = (JSONObject) laptopObject.get("processor");
                String processorName = (String) processorObject.get("name");
                String processorClockSpeed = (String) processorObject.get("clock_speed");
                long processorCores = (long) processorObject.get("cores");

                // Get the memory details
                JSONObject memoryObject = (JSONObject) laptopObject.get("memory");
                String memorySize = (String) memoryObject.get("size");
                String memoryType = (String) memoryObject.get("type");

                // Get the storage details
                JSONObject storageObject = (JSONObject) laptopObject.get("storage");
                String storageType = (String) storageObject.get("type");
                String storageSize = (String) storageObject.get("size");

                // Get the price
                double price = (double) laptopObject.get("price");

                // Print the laptop details
                System.out.println("ID: " + id);
                System.out.println("Brand: " + brand);
                System.out.println("Model: " + model);
                System.out.println("Screen size: " + screenSize + " inches");
                System.out.println("Resolution: " + resolution);
                System.out.println("Processor: " + processorName + " " + processorCores + " cores, " + processorClockSpeed);
                System.out.println("Memory: " + memorySize + " " + memoryType);
                System.out.println("Storage: " + storageSize + " " + storageType);
                System.out.println("Price: $" + price);
                System.out.println();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
