import java.nio.file.*;
import java.nio.charset.*;
public class Fix {
  public static void main(String[] args) throws Exception {
    Path p = Paths.get("application.properties");
    String c = new String(Files.readAllBytes(p), StandardCharsets.ISO_8859_1);
    c = c.replace("ddl-auto=update", "ddl-auto=create");
    Files.write(p, c.getBytes(StandardCharsets.UTF_8));
  }
}
