package botpanehboxtools;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;

public class XY {
	private double x;
	private double y;
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setXY(Button a) {
		setX(a.getLayoutX());
		setY(a.getLayoutY());
	}
	public void setXY(Line a) {			//
		setX(a.getLayoutX());
		setY(a.getLayoutY());
	}
	public void setXY(Label a) {
		setX(a.getLayoutX());
		setY(a.getLayoutY());
	}
}
