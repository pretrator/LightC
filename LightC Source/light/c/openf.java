
package light.c;

import java.io.IOException;

public class openf
{
    public static void openfile(final String filnam, final String wrkspac) throws IOException {
        final editor f = new editor(config.pathtowrkspace + "\\" + wrkspac, filnam);
    }
}
