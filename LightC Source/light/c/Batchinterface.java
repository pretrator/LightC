
package light.c;

import java.io.InputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Batchinterface
{
    Process p;
    String outp;
    String errr;
    
    Batchinterface(final String cmmnd) throws IOException {
        this.p = Runtime.getRuntime().exec("cmd /c " + cmmnd);
        this.outp = this.getoutput();
        this.errr = this.geterr();
    }
    
    public String getoutput() throws IOException {
        final InputStream stdout = this.p.getInputStream();
        final BufferedReader brCleanUp = new BufferedReader(new InputStreamReader(stdout));
        String input = "";
        String line;
        while ((line = brCleanUp.readLine()) != null) {
            input = input + line + "\n";
        }
        brCleanUp.close();
        return input;
    }
    
    public String geterr() throws IOException {
        final InputStream stderr = this.p.getErrorStream();
        final BufferedReader brCleanUp = new BufferedReader(new InputStreamReader(stderr));
        String input = "";
        String line;
        while ((line = brCleanUp.readLine()) != null) {
            input = input + line + "\n";
        }
        brCleanUp.close();
        return input;
    }
}
