package botpanehboxtools;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;
public class MoveButton{
	public void moveButton(Line buttonx, double d, double e) {
		Translate translate = new Translate();
		translate.setX(d);
		translate.setY(e);
		buttonx.getTransforms().addAll(translate);
		buttonx.setLayoutX(buttonx.getLayoutX());
	}
}
