import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        
            String json = Files.readString(Path.of("input.json"));
            String first = json.split("first_name")[1].split("\"")[2];
            String roll = json.split("roll_number")[1].split("\"")[2];
            String input = (first + roll).toLowerCase().replaceAll("\\s+", "");

            byte[] hash = MessageDigest.getInstance("MD5").digest(input.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));

            Files.writeString(Path.of("output.txt"), hex);
            System.out.println(hex);      
    }
}
