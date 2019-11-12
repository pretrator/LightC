import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;



public class NewClass
{
    public static void main(final String[] args) throws IOException {
        final File f = new File("F:\\CS\\server");
        final File g = new File("F:\\CS\\kk");
        copy(f, g);
    }
    
    public static void copy(final File sourceLocation, final File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            copyDirectory(sourceLocation, targetLocation);
        }
        else {
            copyFile(sourceLocation, targetLocation);
        }
    }
    
    private static void copyDirectory(final File source, final File target) throws IOException {
        if (!target.exists()) {
            target.mkdir();
        }
        for (final String f : source.list()) {
            copy(new File(source, f), new File(target, f));
        }
    }
    
    private static void copyFile(final File source, final File target) throws IOException {
        try (final InputStream in = new FileInputStream(source);
             final OutputStream out = new FileOutputStream(target)) {
            final byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }
}
