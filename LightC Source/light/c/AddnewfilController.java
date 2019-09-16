// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.util.ResourceBundle;
import java.net.URL;
import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;

public class AddnewfilController implements Initializable
{
    @FXML
    JFXTextField tf;
    
    public void submit(final ActionEvent k) throws IOException {
        final wrkconfig f = new wrkconfig(config.pathtowrkspace + "\\" + OpenwrkspaceController.worknam);
        f.addnewfile(this.tf.getText());
        openf.openfile(this.tf.getText(), OpenwrkspaceController.worknam);
        ((Node)k.getSource()).getScene().getWindow().hide();
    }
    
    public void cancel(final ActionEvent k) {
        ((Node)k.getSource()).getScene().getWindow().hide();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
    }
}
