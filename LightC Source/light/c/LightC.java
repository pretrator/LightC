// 
// Decompiled by Procyon v0.5.36
// 

package light.c;

import java.io.IOException;
import javafx.stage.StageStyle;
import javafx.scene.paint.Paint;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.application.Application;

public class LightC extends Application
{
    private double initX;
    private double initY;
    static Stage k;
    
    public void start(final Stage stage) throws IOException {
        LightC.k = stage;
        final FXMLLoader lod = new FXMLLoader(this.getClass().getResource("mainscr.fxml"));
        final Parent root = (Parent)lod.load();
        final Scene k = new Scene(root, (Paint)Color.TRANSPARENT);
        k.getStylesheets().addAll((Object[])new String[] { this.getClass().getResource("j.css").toExternalForm() });
        stage.setScene(k);
        stage.setTitle("Light C");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
    public static void main(final String[] args) {
        launch(args);
    }
}
