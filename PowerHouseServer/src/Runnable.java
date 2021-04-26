import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Runnable {
    String run(String cmd) throws IOException, ParseException;
}
