// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class toolkit
{
    public static void main(final String[] args) throws IOException {
        System.out.println(System.getenv());
    }
    
    public static void initload() throws IOException {
        if (isfirstrun()) {
            setenv();
        }
    }
    
    public static void setenv() throws IOException {
        String k;
        if (System.getenv().containsKey("APPDATA")) {
            k = System.getenv().get("APPDATA");
        }
        else {
            k = System.getenv().get("ALLUSERSPROFILE");
        }
        makefolder(k + "\\Light.C.Project.Files");
        final File fil = new File("config");
        fil.createNewFile();
        final ArrayList<String> lin = new ArrayList<String>();
        lin.add(k + "\\Light.C.Project.Files");
        Files.write(fil.toPath(), lin, StandardCharsets.UTF_8, new OpenOption[0]);
        makefolder(k + "\\Light.C.Project.Files\\quickrun");
        makefolder(k + "\\Light.C.Project.Files\\tcc");
        final File f = new File("tcc");
        final File g = new File(k + "\\Light.C.Project.Files\\tcc");
        copy(f, g);
    }
    
    public static boolean isfirstrun() {
        String st = System.getenv().get("APPDATA");
        st += "\\Light.C.Project.Files";
        final File f = new File(st);
        return !f.exists();
    }
    
    public static boolean makefolder(final String k) {
        final File fil = new File(k);
        return fil.mkdir();
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
