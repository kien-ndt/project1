package botpanehboxtools;

import javafx.scene.layout.HBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

public class SliderTools{
	private HBox botPane;
	public double min=-20, max=20, value=0, blockIncrement=1, tickUnit=5; public int tickCount=4;
	public Slider slider1= new Slider();
	public Slider slider2= new Slider();
	public Slider slider= new Slider();
	public SliderTools(HBox tmp) {
		botPane = tmp;
	}
	public Slider sliderAddInfo() {
		slider.setMin(min);
		slider.setMax(max);
		slider.setValue(value);
		slider.setBlockIncrement(blockIncrement);
		slider.setMajorTickUnit(tickUnit);
		slider.setMinorTickCount(tickCount);
		slider.setPrefSize(600, 30);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setSnapToTicks(true);
		botPane.getChildren().add(slider);
		return slider;
	}
	public void sliderAction(Number new_val) {
		
	}
}
