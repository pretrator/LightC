// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import javafx.collections.ObservableList;
import java.util.List;
import javafx.collections.FXCollections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.Node;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.Initializable;

public class FilnamController implements Initializable
{
    @FXML
    JFXListView lv;
    
    public void addnewfil(final ActionEvent g) throws IOException {
        final Stage k = new Stage();
        k.initStyle(StageStyle.UNDECORATED);
        final FXMLLoader lod = new FXMLLoader(this.getClass().getResource("addnewfil.fxml"));
        final Parent root = (Parent)lod.load();
        final Scene sc = new Scene(root);
        k.setScene(sc);
        k.show();
    }
    
    public void cancel(final ActionEvent k) {
        ((Node)k.getSource()).getScene().getWindow().hide();
    }
    
    public void lisclick() throws IOException {
        openf.openfile(this.lv.getSelectionModel().getSelectedItem().toString(), OpenwrkspaceController.worknam);
        OpenwrkspaceController.stag.close();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        wrkconfig g = null;
        try {
            g = new wrkconfig(config.pathtowrkspace + "\\" + OpenwrkspaceController.worknam);
        }
        catch (IOException ex) {
            Logger.getLogger(FilnamController.class.getName()).log(Level.SEVERE, null, ex);
        }
        final List<String> ld = g.filname;
        final ObservableList st = FXCollections.observableList((List)ld);
        this.lv.setItems(st);
    }
}
