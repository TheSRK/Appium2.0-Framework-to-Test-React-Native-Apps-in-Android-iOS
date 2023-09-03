package Utils;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class JSONReader {
   //@Getter @Setter
    private static String email;
  // @Getter @Setter
    private static String password;

    static String filePath = System.getProperty("user.dir") + "/src/test/resources/credentials.json";

    public static void readJSONFile(){
        try(FileReader fileReader = new FileReader(filePath)) {

            Gson gson = new Gson();
            Map<String, Map<String,String>> jsonData = gson.fromJson(fileReader, Map.class);

            if (jsonData == null) throw new AssertionError("JSON file is empty");

            if (jsonData.containsKey("live")){

                Map<String,String> credentials = jsonData.get("live");
                setEmail(credentials.get("email"));
                setPassword(credentials.get("password"));
            }
            else if (jsonData.containsKey("staging")){

                Map<String,String> credentials = jsonData.get("staging");
                setEmail(credentials.get("email"));
                setPassword(credentials.get("password"));
            }
            else throw new AssertionError("JSON file does not contain live or staging credentials");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        JSONReader.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        JSONReader.password = password;
    }
}
