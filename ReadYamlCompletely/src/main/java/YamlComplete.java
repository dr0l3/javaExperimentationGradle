import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class YamlComplete {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL resource = YamlComplete.class.getResource("random.yaml");

        Yaml yaml = new Yaml();
        try(InputStream in = Files.newInputStream(Paths.get(resource.toURI()))){
            Pojo configAsYaml = yaml.loadAs(in, Pojo.class);
            System.out.println(configAsYaml.toString());
        }
    }
}
