// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.util.ResourceBundle;
import java.net.URL;
import java.io.IOException;
import javafx.scene.Node;
import java.io.File;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;

public class AddnewwrkspaceController implements Initializable
{
    @FXML
    AnchorPane ap;
    @FXML
    JFXTextField tf;
    
    public void submit(final ActionEvent k) throws IOException {
        final String p = this.tf.getText();
        if (p.length() != 0) {
            config.addwrkspace(p);
            toolkit.makefolder(config.pathtowrkspace + "\\" + p);
            MainscrController.addnewwrkspace.close();
            final File fil = new File(config.pathtowrkspace + "\\" + p + "\\config");
            fil.createNewFile();
            ((Node)k.getSource()).getScene().getWindow().hide();
        }
    }
    
    public void cancel(final ActionEvent a) {
        MainscrController.addnewwrkspace.close();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        addmov.makemova((Node)this.ap, MainscrController.addnewwrkspace);
    }
}
