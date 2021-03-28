package controllsense;

import java.awt.Dimension;

import java.awt.Toolkit;
import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import botpanehboxtools.*;
import manualpackage.*;
public class FirstSenseControll {
	double xCount=0;
	int sizeOfStack=5;

	int flagCombox=0;
	ObjectInScene truyen = new ObjectInScene();	
	Slider tmpSlider = new Slider();
	Slider botSlider1 = new Slider();
	Button setStack1 = new Button("Stack 1");
	public static ObjectInScene clonetruyen = new ObjectInScene();
	private ToggleGroup speedChoose = new ToggleGroup();
	
		@FXML
		private Slider stackSizeSlider;
		
		@FXML
	    private ScrollPane scrollPane;
		
	    @FXML
	    private BorderPane parentPane;

	    @FXML
	    private VBox rightPane;

	    @FXML
	    private Button stack2Click;

	    @FXML
	    private Button s1LabelButton;
	    
	    @FXML
	    private Button s2LabelButton;
	    
	    @FXML
	    private Button changeDemo;
	    
	    @FXML
	    private Button changeAuto;
	    
	    @FXML
	    private Button resetButton;

	    @FXML
	    private Label s2Label;

	    @FXML
	    private Line s1Side1;

	    @FXML
	    private Label s1Label;

	    @FXML
	    private Line s1Side2;

	    @FXML
	    private Slider sizeStack;

	    @FXML
	    private Line rootLine1;

	    @FXML
	    private HBox botPane;
	    
	    @FXML
	    private HBox botPane1;

	    @FXML
	    private Line s2Side1;

	    @FXML
	    private Button manualButton;

	    @FXML
	    private Button autoButton;

	    @FXML
	    private AnchorPane centerPane;

	    @FXML
	    private Line s2Side2;

	    @FXML
	    private Button stack1Click;

	    @FXML
	    private Line rootLine2;
	    
	    @FXML
	    private Button paneButton;
	    
	    @FXML
	    private Button 	elementButton;
	    
	    @FXML
	    private Button startButton;
	    
	    @FXML
	    private Button backButton;
	    
	    @FXML
	    private Button pauseButton;
	    
	    @FXML
	    private Button resumeButton;
	    
	    @FXML
	    private Button pushButton;

	    @FXML
	    private Button popButton;

	    @FXML
	    private TextField idText;
	    
	    @FXML
	    private RadioButton radioButton3;

	    @FXML
	    private RadioButton radioButton4;

	    @FXML
	    private RadioButton radioButton1;

	    @FXML
	    private RadioButton radioButton2;


//Event Button Click
	@FXML
	void paneButtonClick(ActionEvent event) {
		botPane.getChildren().clear();
		botPane1.getChildren().clear();
		setPaneSize();
		setColor(centerPane);
	}
    @FXML
    void stack1Click(ActionEvent event) {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	createSliderSizeStack();
    	setColor(rootLine1, s1Side1, s1Side2);
    	setStackBorderThick(rootLine1, s1Side1, s1Side2);
    }

    @FXML
    void stack2Click(ActionEvent event) {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	createSliderSizeStack();
    	setColor(rootLine2, s2Side1,s2Side2);
    	setStackBorderThick(rootLine2, s2Side1, s2Side2);
    }
    
    @FXML
    void s1LabelButtonClick(ActionEvent event) {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	setColor(s1Label);
    }
    
    @FXML
    void s2LabelButtonClick(ActionEvent event) {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	setColor(s2Label);
    }
    
    @FXML
    void elementButtonClick(ActionEvent event) {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	setColor(elementButton);
    }

    @FXML
    void manualButtonClick(ActionEvent event) throws IOException {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	sendData(truyen);
    	Stage stage= (Stage) manualButton.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/manualpackage/ManualScene.fxml"));
    	Parent autoView = loader.load();
    	Scene scene = new Scene(autoView);
    	Controller controller = loader.getController();
    	controller.createAll(truyen);
    	stage.setScene(scene);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	stage.setMaxHeight(screenSize.getHeight());
    	stage.setMaxWidth(screenSize.getWidth());
    	stage.setMinHeight(screenSize.getHeight());
    	stage.setMinWidth(screenSize.getWidth());
    	stage.setMaximized(true);
    }
    
    @FXML
    void autoButton(ActionEvent event) throws IOException {
    	botPane.getChildren().clear();
		botPane1.getChildren().clear();
    	sendData(truyen);
    	Stage stage= (Stage) autoButton.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/controllsense/AutoSense.fxml"));
    	Parent autoView = loader.load();
    	Scene scene = new Scene(autoView);
    	ObsControll controller = loader.getController();
    	controller.createAll(truyen);
    	stage.setScene(scene);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	stage.setMaxHeight(screenSize.getHeight());
    	stage.setMaxWidth(screenSize.getWidth());
    	stage.setMinHeight(screenSize.getHeight());
    	stage.setMinWidth(screenSize.getWidth());
    	stage.setMaximized(true);    	
    }    
//-------------------------------------------------------------------------------------------
    //Stack change color, size (length, width)

    void setColor(Line line1, Line line2, Line line3) {
    	Label newLabel=new Label("Color: ");
    	botPane1.getChildren().add(newLabel);
    	ColorPicker colorPicker = new ColorPicker();
    	colorPicker.setValue((Color) line1.getStroke());
    	colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	line1.setStroke(colorPicker.getValue());
            	line2.setStroke(colorPicker.getValue());
            	line3.setStroke(colorPicker.getValue());
            }
        });
    	botPane1.getChildren().add(colorPicker);
    }
    
    void setColor(Label a) {
    	Label newLabel=new Label("Color: ");
    	botPane1.getChildren().add(newLabel);
    	ColorPicker colorPicker = new ColorPicker();
    	colorPicker.setValue((Color) a.getTextFill());
    	colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	a.setTextFill(colorPicker.getValue());
            }
        });
    	botPane1.getChildren().add(colorPicker);
    }
    void setColor(AnchorPane a) {
    	Label newLabel=new Label("Color: ");
    	botPane1.getChildren().add(newLabel);
    	ColorPicker colorPicker = new ColorPicker();
    	colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	a.setStyle("-fx-background-color: #" + needColor(colorPicker.getValue()));
            }
        });
    	botPane1.getChildren().add(colorPicker);
    }
    
    void setColor(Button a) {
    	Label newLabel=new Label("Color: ");
    	botPane1.getChildren().add(newLabel);
    	ColorPicker colorPicker = new ColorPicker();
    	colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	a.setStyle("-fx-background-color: #" + needColor(colorPicker.getValue()));
            }
        });
    	botPane1.getChildren().add(colorPicker);
    }
//---------------------------------------------------------------------------------------
    void createSliderSizeStack() {
    	//change length
    	Label newLabel=new Label("Stack length: ");
    	botPane.getChildren().add(newLabel);
    	SliderTools a = new SliderTools(botPane); 
    	a.max=250;
    	a.min=-150;
    	a.blockIncrement=50;
    	a.tickUnit=50;
    	a.tickCount=1;
    	a.value=-100-s1Side1.getStartX();
    	tmpSlider= a.sliderAddInfo();
    	tmpSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            	setStackSizeSide(rootLine1, s1Side1, s1Side2, new_val.doubleValue());
            	setStackSizeSide(rootLine2, s2Side1, s2Side2, new_val.doubleValue());
            }
        });
    	//change width
    	Label newLabel1=new Label("Stack width: ");
    	botPane.getChildren().add(newLabel1);
    	SliderTools b = new SliderTools(botPane);
    	b.max=100;
    	b.min=-50;
    	b.blockIncrement=20;
    	b.tickUnit=20;
    	b.tickCount=1;
    	b.value=rootLine1.getEndY()-36;
    	tmpSlider= b.sliderAddInfo();
    	tmpSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            	setStackSizeRoot(rootLine1, s1Side1, s1Side2, new_val.doubleValue());
            	setStackSizeRoot(rootLine2, s2Side1, s2Side2, new_val.doubleValue());
            }
        });
    }
    
    void setStackSizeSide(Line line1, Line line2, Line line3, double new_val) {
    	if (line1==rootLine1) {
    		line2.setStartX(-100-new_val);
    		line2.setEndX(100);
    		line3.setStartX(-100-new_val);
    		line3.setEndX(100);
    	}
    	else {
    		line2.setStartY(-100-new_val);
    		line2.setEndY(100);
    		line3.setStartY(-100-new_val);
    		line3.setEndY(100);
    	}
    	elementButton.setPrefSize(line2.getEndX()-line2.getStartX(), rootLine1.getEndY()-rootLine1.getStartY());
        stack1Click.setPrefWidth(200+new_val);
        stack2Click.setPrefHeight(200+new_val);
    	
    }
    
    void setStackSizeRoot(Line line1, Line line2, Line line3, double new_val) {
    	ObsMove move = new ObsMove();
    	if (line1==rootLine1) {
    		line1.setEndY(36+new_val);
    		XY posLine3Start = new XY();
    		XY posLine3End = new XY();
    		posLine3Start.setX(line3.getLayoutX());
    		posLine3Start.setY(line3.getLayoutY());
    		posLine3End.setX(line3.getLayoutX());
    		posLine3End.setY(line3.getLayoutY()+new_val);
    		move.moveLine(line3, posLine3Start, posLine3End);
    	}
    	else {
    		line1.setEndX(36+new_val);
    		XY posLine3Start = new XY();
    		XY posLine3End = new XY();
    		posLine3Start.setX(line3.getLayoutX());
    		posLine3Start.setY(line3.getLayoutY());
    		posLine3End.setX(line3.getLayoutX()+new_val);
    		posLine3End.setY(line3.getLayoutY());
    		move.moveLine(line3, posLine3Start, posLine3End);
    	}
    	stack1Click.setPrefHeight(77+new_val);
    	stack2Click.setPrefWidth(74+new_val);
    	elementButton.setPrefHeight(rootLine1.getEndY()-rootLine1.getStartY());
    	XY posLabelStart = new XY();
    	XY posLabelEnd= new XY();
    	posLabelStart.setXY(s1Label);
    	posLabelEnd.setX(s1Label.getLayoutX());
    	posLabelEnd.setY(s1Label.getLayoutY()+new_val);
    	move.moveLabel(s1Label, posLabelStart, posLabelEnd);
    	move.moveButton(s1LabelButton, posLabelStart, posLabelEnd);
    	posLabelStart.setXY(s2Label);
    	posLabelEnd.setX(s2Label.getLayoutX()+new_val);
    	posLabelEnd.setY(s2Label.getLayoutY());
    	move.moveLabel(s2Label, posLabelStart, posLabelEnd);
    	move.moveButton(s2LabelButton, posLabelStart, posLabelEnd);
    }
    void setStackBorderThick(Line line1, Line line2, Line line3) {
    	Label comboBoxLabel = new Label("Thickness");
    	ComboBox<String> comboBox = new ComboBox<String>();
    	comboBox.getItems().addAll("x1.0","x2.0","x4.0","x6.0");
    	comboBox.setValue("x"+line1.getStrokeWidth());
    	comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue<? extends String> observable, String old_val, String new_val) {  
            	String tmpString = new_val.substring(1);
            	line1.setStrokeWidth(Double.parseDouble(tmpString));
            	line2.setStrokeWidth(Double.parseDouble(tmpString));
            	line3.setStrokeWidth(Double.parseDouble(tmpString));
            }    
        });
    	botPane1.getChildren().addAll(comboBoxLabel,comboBox);
    }

//Change Pane Size
	void setPaneSize() {
		flagCombox=0;
    	Label newLabel=new Label("Pane Size: ");
    	botPane.getChildren().add(newLabel);
		TextField text1 = new TextField();
		text1.setText(String.valueOf(centerPane.getPrefWidth()));
		botPane.getChildren().add(text1);
    	Label newLabel1=new Label(" X ");
    	botPane.getChildren().add(newLabel1);
		TextField text2 = new TextField();
		text2.setText(String.valueOf(centerPane.getPrefHeight()));
		Label text3= new Label();
		Button okButton = new Button("Press to OK");
		Button maxSizeButton= new Button("Use Computer Size");
		botPane.getChildren().addAll(text2,maxSizeButton,okButton,text3);
		maxSizeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				text1.setText(String.valueOf(screenSize.getWidth()));
				text2.setText(String.valueOf(screenSize.getHeight()));
			}
		});
		okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String text1Value = text1.getText();
            	String text2Value = text2.getText();
            	double text1Number;
            	double text2Number;
            	boolean flag=true;
            	try {
            		text1Number = Double.parseDouble(text1Value);
            		text2Number = Double.parseDouble(text2Value);
				} catch (Exception e) {
					text3.setText("Must be a number");
					text3.setTextFill(Color.RED);
					flag=false;
				}
            	if (flag) {
            	text1Number = Double.parseDouble(text1Value);
            	text2Number = Double.parseDouble(text2Value);
            		if (text1Number<1100 || text2Number<700) text3.setText("Width >1100, Height >900");
            		else {
            		centerPane.setPrefSize(text1Number, text2Number-100);
            		centerPane.setMaxSize(text1Number, text2Number-100);
            		centerPane.setMinSize(text1Number, text2Number-100);
            		paneButton.setPrefSize(text1Number, text2Number-100);
            		flagCombox=1;
            		text3.setText("OK");
            		text3.setTextFill(Color.GREEN);
            		}
            	}            	
            }
        });
		
	}
	//CSS convert
	String needColor(Color a) {
		String tmpString = a.toString();
    	String newString = tmpString.substring(2);
    	return newString;
	}
	//khoi tao dau tien
	void firstCreate() {
		stackSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            	sizeOfStack= new_val.intValue();
            	elementButton.setPrefHeight(Math.abs(s1Side1.getEndX()-s1Side1.getStartX())/sizeOfStack);
            	System.out.println(new_val.doubleValue());
            }
        });
		stackSizeSlider.setValue(sizeOfStack);
	}
	//truyen du lieu
	void sendData(ObjectInScene a) {
//		if (flagCombox==0) {
//			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//			centerPane.setPrefSize(screenSize.getWidth(), screenSize.getHeight()-100);
//    		centerPane.setMaxSize(screenSize.getWidth(), screenSize.getHeight()-100);
//    		centerPane.setMinSize(screenSize.getWidth(), screenSize.getHeight()-100);
//    		paneButton.setPrefSize(screenSize.getWidth(), screenSize.getHeight()-100);
//		}
//		
		a.setCenterPane(centerPane);
		a.setRootLine1(rootLine1);
		a.setRootLine2(rootLine2);
		a.setS1Side1(s1Side1);
		a.setS2Side1(s2Side1);
		a.setElementButton(elementButton);
		a.setStartButton(startButton);
		a.setBackButton(backButton);
		a.setResumeButton(resumeButton);
		a.setStackSize(sizeOfStack);
		a.setPushButton(pushButton);
		a.setPopButton(popButton);
		a.setSpeedChoose(speedChoose);
		a.setIdText(idText);
		a.setPauseButton(pauseButton);
		a.setChangeDemo(changeDemo);
		a.setChangeAuto(changeAuto);
		a.setResetButton(resetButton);
		
		clonetruyen.setCenterPane(centerPane);
		clonetruyen.setRootLine1(rootLine1);
		clonetruyen.setRootLine2(rootLine2);
		clonetruyen.setS1Side1(s1Side1);
		clonetruyen.setS2Side1(s2Side1);
		clonetruyen.setElementButton(elementButton);
		clonetruyen.setStartButton(startButton);
		clonetruyen.setBackButton(backButton);
		clonetruyen.setResumeButton(resumeButton);
		clonetruyen.setStackSize(sizeOfStack);
		clonetruyen.setPushButton(pushButton);
		clonetruyen.setPopButton(popButton);
		clonetruyen.setSpeedChoose(speedChoose);
		clonetruyen.setIdText(idText);
		clonetruyen.setPauseButton(pauseButton);
		clonetruyen.setChangeAuto(changeAuto);
		clonetruyen.setChangeDemo(changeDemo);
		clonetruyen.setResetButton(resetButton);
		
	}
	@FXML //when mouse move throw pane
	void activeSizeStackSlider() {
		stackSizeSlider.setValue(sizeOfStack);
		stackSizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) {
                	sizeOfStack=new_val.intValue();
                	elementButton.setPrefWidth((s1Side1.getEndX()-s1Side1.getStartX())/sizeOfStack);
            		rightPane.getChildren().remove(setStack1);
                	if (new_val.intValue()==1 || new_val.intValue()==2) {
                		setStack1.setOnAction(stack1Click.getOnAction());
                		rightPane.getChildren().add(setStack1);
                	}
                }
            });
		activeToggleSpeed();
	}
	void activeToggleSpeed() {
		createToggleGroup(speedChoose, radioButton1, radioButton2, radioButton3,radioButton4);
		speedChoose.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	           @Override
	           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
	        	   if (speedChoose.getSelectedToggle() != null) {
	           }
	           }
	       });
	}
	void createToggleGroup(ToggleGroup group, RadioButton a1, RadioButton a2, RadioButton a3, RadioButton a4) {
		a1.setToggleGroup(group);
		a2.setToggleGroup(group);
		a2.setSelected(true);
		a3.setToggleGroup(group);
		a4.setToggleGroup(group);
	}
}
	
//-------------------------------------------------------------------------------------------------
//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//System.out.println(screenSize.getWidth());