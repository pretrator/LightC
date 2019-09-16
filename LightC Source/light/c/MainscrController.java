// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

public class MainscrController implements Initializable
{
    @FXML
    Pane titleba;
    FlowPane pk;
    private double xOffset;
    private double yOffset;
    @FXML
    JFXButton closebutt;
    @FXML
    JFXButton minimize;
    static Stage list;
    static Stage addnewwrkspace;
    
    public MainscrController() {
        this.xOffset = 0.0;
        this.yOffset = 0.0;
    }
    
    public void opnworkspaceclik(final ActionEvent f) throws IOException {
        final Stage stag = new Stage();
        (MainscrController.addnewwrkspace = stag).initStyle(StageStyle.UNDECORATED);
        final FXMLLoader lod = new FXMLLoader(this.getClass().getResource("openwrkspace.fxml"));
        final Parent root = (Parent)lod.load();
        final Scene k = new Scene(root);
        stag.setScene(k);
        stag.show();
        MainscrController.list = stag;
    }
    
    public void addworkspaceclicked() throws IOException {
        final Stage stag = new Stage();
        (MainscrController.addnewwrkspace = stag).initStyle(StageStyle.UNDECORATED);
        final FXMLLoader lod = new FXMLLoader(this.getClass().getResource("addnewwrkspace.fxml"));
        final Parent root = (Parent)lod.load();
        final Scene k = new Scene(root, (Paint)Color.TRANSPARENT);
        stag.setScene(k);
        stag.initStyle(StageStyle.UNDECORATED);
        stag.show();
        MainscrController.list = stag;
    }
    
    public void quickrun(final ActionEvent l) throws IOException {
        openf.openfile("quickrun", "quickrun");
    }
    
    public void minimize(final ActionEvent e) {
        LightC.k.setIconified(true);
    }
    
    public void initialize(final URL url, final ResourceBundle rb) {
        System.out.println("init");
        final Stage primaryStage = LightC.k;
        addmov.makemova((Node)this.titleba, primaryStage);
        this.closebutt.setOnAction(event -> System.exit(0));
        try {
            toolkit.initload();
        }
        catch (IOException ex) {
            Logger.getLogger(MainscrController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            config.configlod();
        }
        catch (IOException ex) {
            Logger.getLogger(MainscrController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
