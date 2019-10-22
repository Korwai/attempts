import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static void main(String[] args) throws IOException {
        Pokedex lol;
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        lol = mapper.readValue(new File("src/pokemon.json"), Pokedex.class);

        for (Pokemon p : lol.getPokemon()) {
            System.out.println(p.getName() + ": " + p.getId());
        }
    }
}
