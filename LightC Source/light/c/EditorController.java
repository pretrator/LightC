// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.IOException;
import java.nio.file.Path;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.Initializable;

public class EditorController implements Initializable
{
    @FXML
    JFXTextArea txtfld;
    @FXML
    TextArea lbl;
    
    public void minimize(final ActionEvent e) {
        editor.stage.setIconified(true);
    }
    
    public void compile(final ActionEvent k) throws IOException {
        final File fdel = new File(editor.getobj.absolutefilename + ".exe");
        if (fdel.exists()) {
            System.out.println("exe to pehle se hi bana hai");
            if (fdel.delete()) {
                System.out.println("xhalo delete t hua");
            }
            else {
                System.out.println("nahi krr paye delete");
            }
        }
        final Path path = Paths.get(editor.getobj.absolutefilename, new String[0]);
        final FileWriter f = new FileWriter(editor.getobj.absolutefilename);
        f.write(this.txtfld.getText());
        f.flush();
        f.close();
        final File fil = new File(editor.getobj.absolutefilename + ".exe");
        fil.createNewFile();
        final Batchinterface cmpiler = new Batchinterface(editor.getobj.wrkspace + "\\..\\tcc\\tcc " + editor.getobj.absolutefilename + " -o " + editor.getobj.absolutefilename + ".exe");
        System.out.println(editor.getobj.wrkspace + "\\..\\tcc\\tcc " + editor.getobj.absolutefilename + " -o " + editor.getobj.absolutefilename + ".exe");
        if (cmpiler.errr.length() != 0) {
            this.lbl.setText("Compilation Error \n" + cmpiler.errr);
        }
        else {
            this.lbl.setText("Successfully Compiled");
            final Runtime r = Runtime.getRuntime();
            r.exec("cmd /c start cmd /c " + editor.getobj.absolutefilename + ".exe");
        }
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        final Path path = Paths.get(editor.getobj.absolutefilename, new String[0]);
        List<String> lst = null;
        try {
            lst = Files.readAllLines(path);
        }
        catch (IOException ex) {
            Logger.getLogger(EditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Iterator it = lst.iterator();
        String st = "";
        while (it.hasNext()) {
            st = st + it.next().toString() + "\n";
        }
        if (st.length() == 0) {
            st = "#include<stdio.h>\nvoid main()\n{\n\tprintf(\" Hello World\");\n\tgetch();\n}\n";
        }
        this.txtfld.setText(st);
        this.lbl.setText("File Loaded Successfully");
    }
}
