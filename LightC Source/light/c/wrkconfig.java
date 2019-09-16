// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.nio.file.OpenOption;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

public class wrkconfig
{
    List<String> filname;
    String pat;
    
    wrkconfig(final String pa) throws IOException {
        this.pat = pa + "\\config";
        this.filname = Files.readAllLines(Paths.get(this.pat, new String[0]), StandardCharsets.UTF_8);
    }
    
    public void addnewfile(final String filename) throws IOException {
        this.filname.add(filename);
        Files.write(Paths.get(this.pat, new String[0]), this.filname, StandardCharsets.UTF_8, new OpenOption[0]);
    }
}
