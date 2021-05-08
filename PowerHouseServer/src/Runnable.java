import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface Runnable {
    String run(String cmdInput) throws IOException, ParseException;
}
