
package light.c;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.File;
import javafx.stage.Stage;

public class editor
{
    static Stage stage;
    String wrkspace;
    String filname;
    String absolutefilename;
    static editor getobj;
    
    editor(final String st, final String filnam) throws IOException {
        this.wrkspace = st;
        this.filname = filnam;
        this.absolutefilename = this.wrkspace + "\\" + this.filname;
        final File f = new File(this.wrkspace + "\\" + this.filname);
        if (!f.exists()) {
            f.createNewFile();
        }
        editor.getobj = this;
        final FXMLLoader lod = new FXMLLoader(this.getClass().getResource("editor.fxml"));
        final Parent root = (Parent)lod.load();
        final Scene k = new Scene(root);
        final Stage stag = new Stage();
        (editor.stage = stag).setScene(k);
        stag.setTitle(st.substring(st.lastIndexOf("\\") + 1) + "-" + filnam);
        stag.show();
    }
}
