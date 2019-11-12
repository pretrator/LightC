
package light.c;

import java.nio.file.Paths;
import java.nio.file.OpenOption;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Iterator;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;

public class config
{
    static Path pat;
    static List<String> srlis;
    static List<String> wrkspace;
    static String pathtowrkspace;
    
    public static void configlod() throws IOException {
        config.srlis = Files.readAllLines(config.pat);
        config.pathtowrkspace = config.srlis.get(0);
        final Iterator it = config.srlis.iterator();
        (config.wrkspace = Files.readAllLines(config.pat)).remove(0);
    }
    
    public static void addwrkspace(final String st) throws IOException {
        config.srlis.add(st);
        config.wrkspace.add(st);
        Files.write(config.pat, config.srlis, StandardCharsets.UTF_8, new OpenOption[0]);
    }
    
    static {
        config.pat = Paths.get("config", new String[0]);
    }
}
