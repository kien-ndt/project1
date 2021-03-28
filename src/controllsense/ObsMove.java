package controllsense;

import botpanehboxtools.XY;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ObsMove {

    public void fadeButton(Button rect1, SequentialTransition b) {
    	FadeTransition ft = new FadeTransition(Duration.seconds(0.01), rect1);
    	ft.setFromValue(0.0);
    	ft.setToValue(1.0);
    	b.getChildren().add(ft);
	}
    public void fadeButtonDisappear(Button rect1, SequentialTransition b) {
    	FadeTransition ft = new FadeTransition(Duration.seconds(0.001), rect1);
    	ft.setFromValue(1.0);
    	ft.setToValue(0.0);
    	b.getChildren().add(ft);
	}

	public void moveButton(Button a, XY pos1, XY pos2, SequentialTransition b) {
		TranslateTransition transition = new TranslateTransition();
    	transition.setDuration(Duration.seconds(0.5));
    	transition.setNode(a);
    	transition.setToX(pos2.getX()-pos1.getX());
    	transition.setToY(pos2.getY()-pos1.getY());
    	transition.setAutoReverse(false);
    	b.getChildren().addAll( new PauseTransition(Duration.seconds(0.25)),transition);
	}

    //xoay number1 do
    public void rotateButton(Button rectParallel, double number1, SequentialTransition b) {
    	RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.2), rectParallel);
        rotateTransition.setByAngle(number1);
        b.getChildren().add(rotateTransition);
        
    }

    public void message(Text text, SequentialTransition b, Double time) {
    	FadeTransition ft = new FadeTransition(Duration.seconds(0.01), text);
    	ft.setFromValue(0.0);
    	ft.setToValue(1.0);
    	b.getChildren().addAll(ft,new PauseTransition(Duration.seconds(time)));
    }
    public void closeMessage(Text text, SequentialTransition b) {
    	FadeTransition ft = new FadeTransition(Duration.seconds(0.001), text);
    	ft.setFromValue(1.0);
    	ft.setToValue(0.0);
    	b.getChildren().add(ft);
    }
    
    public void moveLine(Line a, XY pos1, XY pos2) {
		TranslateTransition transition = new TranslateTransition();
    	transition.setDuration(Duration.seconds(0.001));
    	transition.setNode(a);
    	transition.setToX(pos2.getX()-pos1.getX());
    	transition.setToY(pos2.getY()-pos1.getY());
    	transition.setAutoReverse(false);
    	transition.play();
	}
    
    public void moveLabel(Label a, XY pos1, XY pos2) {
		TranslateTransition transition = new TranslateTransition();
    	transition.setDuration(Duration.seconds(0.001));
    	transition.setNode(a);
    	transition.setToX(pos2.getX()-pos1.getX());
    	transition.setToY(pos2.getY()-pos1.getY());
    	transition.setAutoReverse(false);
    	transition.play();
	}
    public void moveButton(Button a, XY pos1, XY pos2) {
		TranslateTransition transition = new TranslateTransition();
    	transition.setDuration(Duration.seconds(0.5));
    	transition.setNode(a);
    	transition.setToX(pos2.getX()-pos1.getX());
    	transition.setToY(pos2.getY()-pos1.getY());
    	transition.setAutoReverse(false);
    	transition.play();
	}
    public void moveGroup(Group a, XY pos1, XY pos2) {
		TranslateTransition transition = new TranslateTransition();
    	transition.setDuration(Duration.seconds(0.5));
    	transition.setNode(a);
    	transition.setToX(pos2.getX()-pos1.getX());
    	transition.setToY(pos2.getY()-pos1.getY());
    	transition.setAutoReverse(false);
    	transition.play();
	}
    public void moveUpWithRange(Group a, double range) {
    	XY tmpXY= new XY();
    	XY tmpXY1= new XY();
    	tmpXY.setX(a.getLayoutX());
    	tmpXY.setY(a.getLayoutY());
    	tmpXY1.setX(a.getLayoutX());
    	tmpXY1.setY(a.getLayoutY()+range);
    	moveGroup(a,tmpXY,tmpXY1);
    }
}
