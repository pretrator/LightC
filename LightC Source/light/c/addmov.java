

package light.c;

import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

class addmov extends Stage
{
    private static double xOffset;
    private static double yOffset;
    
    public static void makemova(final Node k, final Stage stage) {
        k.setOnMousePressed(event -> {
            addmov.xOffset = event.getSceneX();
            addmov.yOffset = event.getSceneY();
        });
        k.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - addmov.xOffset);
            stage.setY(event.getScreenY() - addmov.yOffset);
        });
    }
}
