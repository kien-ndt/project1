package controllsense;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class ObjectInScene {
	private int stackSize;
	public int getStackSize() {
		return stackSize;
	}
	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}
	//stack1
	private Line s1Side1;	
    private Line s1Side2;
    private Line rootLine1;
    private Label s1Label;
    //stack2
    private Line s2Side1;	
    private Line s2Side2;
    private Line rootLine2;
    private Label s2Label;
    //Anchor Pane
    private AnchorPane centerPane;
    //Button
    private Button elementButton;
    private Button startButton;
    private Button pauseButton;
    private Button resumeButton;
    private Button changeDemo;
    private Button changeAuto;
    private Button resetButton;
    public Button getResetButton() {
		return resetButton;
	}
	public void setResetButton(Button resetButton) {
		this.resetButton = resetButton;
	}
	public Button getChangeAuto() {
		return changeAuto;
	}
	public void setChangeAuto(Button changeAuto) {
		this.changeAuto = changeAuto;
	}
	public Button getChangeDemo() {
		return changeDemo;
	}
	public void setChangeDemo(Button changeDemo) {
		this.changeDemo = changeDemo;
	}
	public Button getResumeButton() {
		return resumeButton;
	}
	public void setResumeButton(Button resumeButton) {
		this.resumeButton = resumeButton;
	}
	public Button getPauseButton() {
		return pauseButton;
	}
	public void setPauseButton(Button pauseButton) {
		this.pauseButton = pauseButton;
	}
	private Button backButton;
    private Button pushButton;
    private Button popButton;
    private ToggleGroup speedChoose;
    private TextField idText;
    public TextField getIdText() {
		return idText;
	}
	public void setIdText(TextField idText) {
		this.idText = idText;
	}
	public ToggleGroup getSpeedChoose() {
		return speedChoose;
	}
	public void setSpeedChoose(ToggleGroup speedChoose) {
		this.speedChoose = speedChoose;
	}
	public Button getPushButton() {
		return pushButton;
	}
	public void setPushButton(Button pushButton) {
		this.pushButton = pushButton;
	}
	public Button getPopButton() {
		return popButton;
	}
	public void setPopButton(Button popButton) {
		this.popButton = popButton;
	}
	public Button getBackButton() {
		return backButton;
	}
	public void setBackButton(Button backButton) {
		this.backButton = backButton;
	}
	public Button getElementButton() {
		return elementButton;
	}
	public void setElementButton(Button elementButton) {
		this.elementButton = elementButton;
	}
	
    
	public Button getStartButton() {
		return startButton;
	}
	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}
	public AnchorPane getCenterPane() {
		return centerPane;
	}
	public void setCenterPane(AnchorPane centerPane) {
		this.centerPane = centerPane;
	}
	public void setRootLine1(Line rootLine1) {
		this.rootLine1 = rootLine1;
	}
	public void setRootLine1Color(Line rootLine1) {
		this.rootLine1.setStroke(rootLine1.getStroke());
	}
	public Line getRootLine1() {
		return rootLine1;
	}
	public Line getS1Side1() {
		return s1Side1;
	}
	public void setS1Side1(Line s1Side1) {
		this.s1Side1 = s1Side1;
	}
	public Line getS1Side2() {
		return s1Side2;
	}
	public Line getRootLine2() {
		return rootLine2;
	}
	public void setRootLine2(Line rootLine2) {
		this.rootLine2 = rootLine2;
	}
	public void setS1Side2(Line s1Side2) {
		this.s1Side2 = s1Side2;
	}
	public Line getS2Side1() {
		return s2Side1;
	}
	public void setS2Side1(Line s2Side1) {
		this.s2Side1 = s2Side1;
	}
	
    
}
