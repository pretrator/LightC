// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import javafx.collections.ObservableList;
import java.util.Collection;
import javafx.collections.FXCollections;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;

public class OpenwrkspaceController implements Initializable
{
    @FXML
    JFXButton addnew;
    @FXML
    JFXListView list;
    static Stage stag;
    boolean listshow;
    static String worknam;
    
    public OpenwrkspaceController() {
        this.listshow = false;
    }
    
    public void clo(final ActionEvent k) {
        MainscrController.list.close();
    }
    
    public void onlisclik() throws IOException {
        OpenwrkspaceController.worknam = this.list.getSelectionModel().getSelectedItem().toString();
        final Stage j = new Stage();
        j.initStyle(StageStyle.UNDECORATED);
        final FXMLLoader lod = new FXMLLoader(this.getClass().getResource("filnam.fxml"));
        final Parent root = (Parent)lod.load();
        final Scene sc = new Scene(root);
        j.setScene(sc);
        (OpenwrkspaceController.stag = j).show();
        MainscrController.list.close();
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        final ObservableList<String> s = (ObservableList<String>)FXCollections.observableArrayList((Collection)config.wrkspace);
        this.list.setItems((ObservableList)s);
    }
}
