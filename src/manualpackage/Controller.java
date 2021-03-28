package manualpackage;

import botpanehboxtools.*;
import controllsense.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javafx.animation.SequentialTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import stackandqueuetheory.ButtonQueue;
import stackandqueuetheory.ButtonStack;
import stackandqueuetheory.*;
public class Controller{
	String n;
	
	private Line rootLine1;
	private Line sideLine1;
	private Line rootLine2;
    private Line sideLine2;
    private AnchorPane rootPane;
    private Button pushButton;
    private Button popButton;
    private Button backButton;
    private Button formElementButton;
    private Button changeAuto;
    private ToggleGroup speedChoose;
	int sizeOfStack = 5; int defaultText=0;
	TextField idText;

	ArrayStringStack s1;
	ArrayStringStack s2;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @FXML
    private ScrollPane scrollRootPane;
//    private int sizeStack;
//    private ButtonStack<Button> stack1=new ButtonStack<Button>();
//    private ButtonStack<Button> stack2=new ButtonStack<Button>();
    private ArrayButton stack1;
    private ArrayButton stack2;
    private ButtonQueue<Button> queue1 = new ButtonQueue<Button>();
    private ObsMove move= new ObsMove();
    private XY topStack1= new XY();
    private XY topStack2= new XY();
    private XY buttonSize= new XY(); 
    private XY trunggianM= new XY();
    private XY posTmpPop= new XY();
    private Button tmpPop= new Button();
    private Text tmpPushPopShow= new Text();
    private Button [] allButton = new Button[99999];
    private int countAllButton =0;
    private Text [] allText = new Text[99999];
    private int countAllText=0;
    private Slider speedSlide = new Slider(0.5,6,1);
	public SequentialTransition sequence = new SequentialTransition();
    
    public void setSizeStack(int n){
    	int sizeStack=n;
    	buttonSize.setX((sideLine1.getEndX()-sideLine1.getStartX())/sizeStack);
    	buttonSize.setY(rootLine1.getEndY()-rootLine1.getStartY());
    	topStack1.setX(rootLine1.getLayoutX()-(sideLine1.getEndX()-sideLine1.getStartX())/sizeStack);
    	topStack1.setY(sideLine1.getLayoutY());
    	topStack2.setX(sideLine2.getLayoutX());
    	topStack2.setY(rootLine2.getLayoutY()-buttonSize.getX());
    	trunggianM.setY(sideLine1.getLayoutY()+(rootLine1.getEndY()-rootLine1.getStartY())/2);
		trunggianM.setX(rootLine2.getLayoutX()-rootLine1.getEndX()-buttonSize.getX()/2);
    }
    
    public void createAll(ObjectInScene a) {
    	StringToDouble convert = new StringToDouble();
    	sizeOfStack=(int) a.getStackSize();
    	s1= new ArrayStringStack(sizeOfStack);
    	s2= new ArrayStringStack(sizeOfStack);
    	stack1= new ArrayButton(sizeOfStack);
        stack2= new ArrayButton(sizeOfStack);
    	rootLine1=a.getRootLine1();
    	sideLine1=a.getS1Side1();
    	rootLine2=a.getRootLine2();
    	sideLine2=a.getS2Side1();
    	scrollRootPane.setContent(a.getCenterPane());
    	rootPane=a.getCenterPane();
    	pushButton= a.getPushButton();
    	pushButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	pushButtonClick();
            }
    	});
    	formElementButton= a.getElementButton();
    	formElementButton.setDisable(true);
    	formElementButton.setVisible(false);
    	idText=a.getIdText();
    	idText.setDisable(false);
    	backButton=a.getBackButton();
    	backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
					backButtonClick();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
    	});
    	popButton=a.getPopButton();
    	popButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	popButtonClick();
            }
    	});
    	sizeOfStack=a.getStackSize();
    	setSizeStack(sizeOfStack);
    	idText.setText("N"+defaultText);
    	speedChoose=a.getSpeedChoose();
    	speedSlide.setValue(convert.oneLetterNumber(((RadioButton)speedChoose.getSelectedToggle()).getText()));
    	sequence.rateProperty().bind(speedSlide.valueProperty());
    	speedChoose.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	           @Override
	           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
	        	   if (speedChoose.getSelectedToggle() != null) {
	        		   RadioButton radioButton = (RadioButton) speedChoose.getSelectedToggle();
	        		   speedSlide.setValue(convert.oneLetterNumber(radioButton.getText()));
	           }
	           }
	       });
    	changeAuto=a.getChangeAuto();
    	changeAuto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
					changeAutoButtonClick();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
    	});
    	a.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	resetPane();
            }
    	});
    	a.getStartButton().setDisable(true);
    	a.getResumeButton().setDisable(true);
    	a.getPauseButton().setDisable(true);
    	a.getPopButton().setDisable(false);
    	a.getPushButton().setDisable(false);
    	a.getChangeDemo().setDisable(true);
    	changeAuto.setDisable(false);
    	
    }
	public void obsCreateElement(String n) {
		Button newButton= new Button(""+n);
		newButton.setStyle(formElementButton.getStyle());
		newButton.setMaxSize(buttonSize.getX(), buttonSize.getY());
		newButton.setMinSize(buttonSize.getX(), buttonSize.getY());
		queue1.enqueue(newButton);
		rootPane.getChildren().addAll(newButton);
		move.fadeButton(newButton, sequence);
	}
	
	public void obsRequest(String string) {
		Text text1= new Text(string);
		allText[countAllText]=text1;
		countAllText++;
		text1.setLayoutX(14);
		text1.setLayoutY(259);
		text1.setStyle("-fx-font-size: 30; -fx-alignment: center; ");
		rootPane.getChildren().addAll(text1);
		move.message(text1, sequence,1.5);
		move.closeMessage(text1, sequence);
	}
	
	public void obsRespond(String string) {
		Text text2= new Text(string);
		allText[countAllText]=text2;
		countAllText++;
		text2.setLayoutX(14);
		text2.setLayoutY(336);
		text2.setStyle("-fx-font-size: 25; -fx-alignment: center; ");
		rootPane.getChildren().addAll(text2);
		move.message(text2,sequence,1.5);
		move.closeMessage(text2, sequence);
	}
	
	public void showPushPop(String string) {
		Text text3= new Text(string);
		allText[countAllText]=text3;
		countAllText++;
		text3.setLayoutX(521);
		text3.setLayoutY(336);
		text3.setStyle("-fx-font-size: 25; -fx-alignment: center; ");
		rootPane.getChildren().addAll(text3);
		tmpPushPopShow=text3;
		move.message(text3,sequence,0.001);
	}
	public void disShowPushPop() {
		move.closeMessage(tmpPushPopShow, sequence);
	}
	
	public void obsFull() {
		Text text2= new Text("Full");
		allText[countAllText]=text2;
		countAllText++;
		text2.setLayoutX(14);
		text2.setLayoutY(336);
		text2.setStyle("-fx-font-size: 20;");
		rootPane.getChildren().addAll(text2);
		move.message(text2,sequence,1.5);
		move.closeMessage(text2, sequence);
	}
	
	public void obsPushNew() {
		Button tmpButton = queue1.dequeue();
		allButton[countAllButton]=tmpButton;
		countAllButton++;
		stack1.push(tmpButton);
		XY tmpPos= new XY();
		XY tmpPos1= new XY();
		tmpPos1.setX(tmpButton.getLayoutX()+30);
		tmpPos1.setY(tmpButton.getLayoutY());		//rootLine1.getLayoutY()-rootLine1.getEndY()
		tmpPos.setX(tmpButton.getLayoutX());
		tmpPos.setY(tmpButton.getLayoutY());
		move.moveButton(tmpButton,tmpPos,tmpPos1,sequence);
		tmpPos.setX(tmpButton.getLayoutX());
		tmpPos.setY(tmpButton.getLayoutY());
		showPushPop("PUSH 1");
		move.moveButton(tmpButton,tmpPos,topStack1,sequence);
		disShowPushPop();
		topStack1.setX(topStack1.getX()-buttonSize.getX());
		tmpButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
    	    public void handle(ActionEvent event) {
				disableAllButton(true);
				sequence.getChildren().clear();
				popAction(tmpButton.getText());
				sequence.play();
				sequence.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						disableAllButton(false);
					}
				});
			}
		});
	}
	
	public void obsPush(int n) {
		if (n==1) {
			stack1.push(tmpPop);
			posTmpPop.setX(tmpPop.getLayoutX());
			posTmpPop.setY(tmpPop.getLayoutY());
			showPushPop("PUSH 1");
			move.moveButton(tmpPop, posTmpPop, topStack1,sequence);
			disShowPushPop();
			topStack1.setX(topStack1.getX()-buttonSize.getX());
		}
		if (n==2) {
			stack2.push(tmpPop);
			showPushPop("PUSH 2");
			move.rotateButton(tmpPop, 90, sequence);
			posTmpPop.setX(tmpPop.getLayoutX()-(buttonSize.getY()-buttonSize.getX())/2);
			posTmpPop.setY(tmpPop.getLayoutY()+(buttonSize.getY()-buttonSize.getX())/2);
			move.moveButton(tmpPop, posTmpPop, topStack2, sequence);
			disShowPushPop();
			topStack2.setY(topStack2.getY()-buttonSize.getX());
		}
	}
	
	public void obsPop(int n) {
		if(n==1) {
			tmpPop = stack1.pop();
			XY tmp= new XY();
			tmp.setX(tmpPop.getLayoutX());
			tmp.setY(tmpPop.getLayoutY());
			showPushPop("POP 1");
			move.moveButton(tmpPop, tmp, trunggianM ,sequence);
			disShowPushPop();
			topStack1.setX(topStack1.getX()+buttonSize.getX());
		}
		if(n==2) {
			tmpPop = stack2.pop();
			XY tmp= new XY();
			tmp.setX(tmpPop.getLayoutX());
			tmp.setY(tmpPop.getLayoutY());
			showPushPop("POP 2");
			move.moveButton(tmpPop, tmp, trunggianM,sequence);
			disShowPushPop();
			move.rotateButton(tmpPop, -90, sequence);
			topStack2.setY(topStack2.getY()+buttonSize.getX());
		}
	}
	
	public void obsGet() {
		tmpPop = stack1.pop();
		XY tmp= new XY();
		XY dis =new XY();
		tmp.setX(tmpPop.getLayoutX());
		tmp.setY(tmpPop.getLayoutY());
		showPushPop("PUSH 1");
		move.moveButton(tmpPop, tmp, trunggianM,sequence);
		disShowPushPop();
		tmp.setX(tmpPop.getLayoutX());
		tmp.setY(tmpPop.getLayoutY());
		dis.setX(tmp.getX()-1000);
		dis.setY(tmp.getY());
		move.moveButton(tmpPop, tmp, dis,sequence);
		move.fadeButtonDisappear(tmpPop, sequence);
		topStack1.setX(topStack1.getX()+buttonSize.getX());
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	void pushButtonClick() {
		disableAllButton(true);
    	boolean flag=false;
    	sequence.getChildren().clear();
    	n=idText.getText().replace("\\s+", "");
    	if (n.equals("") || n.equals(null)) {defaultText++; idText.setText("N"+ defaultText); }
    	n=idText.getText().replace("\\s+", "");
    	for (int i=0;i<=s1.getTop();i++) {
    		if (s1.getValue(i).equals(n)) {flag=true; break;}}
    	if (flag==false) {
    		obsRequest("Send "+idText.getText());
    		if(!s1.isFull()) {
    			obsCreateElement(n);
    			s1.push(n);
    			obsPushNew();
			}
		else obsRespond("Full");
    	}
    	else obsRequest("ID is not suitable");
		sequence.play();
    	idText.clear();
		sequence.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				disableAllButton(false);
			}
		});
    }

	void popButtonClick() {
		sequence.getChildren().clear();
		
		if (!s1.isEmpty()) {
			disableAllButton(true);
			n=idText.getText().replaceAll("\\s+", "");
			if (n.equals(null) || n.equals("")) {
				obsRespond("ID empty");
				System.out.println("a");
		}
		else {
			popAction(n);
		}
	}
		sequence.play();
		sequence.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				disableAllButton(false);
			}
		});
    }
    
    void stopProgram(ActionEvent event) {
    	System.exit(0);
    }
    
    void backButtonClick() throws IOException {
    	Stage stage= (Stage) backButton.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/controllsense/SetupSense.fxml"));
    	Parent autoView = loader.load();
    	Scene scene = new Scene(autoView);
    	stage.setScene(scene);
    }
    
    void disableAllButton(boolean a) {
    	pushButton.setDisable(a);
    	popButton.setDisable(a);
    	stack1.disableButtonInStack(a);
    }
    
    void popAction(String a) {
    	obsRequest("Get "+a);
		int pos = s1.findStack(a);
		if (pos>=0) {
			//chuyen sang stack phu
			int top1=s1.getTop();
			for (int j = top1; j>pos;j--) {
				String temp=s1.pop();
				obsPop(1);
				s2.push(temp);
				obsPush(2);
			}
			//lay phan tu
			String temp=s1.pop();
			obsGet();
			obsRespond("Finish ");
			//chuyen lai tu stack phu ve stack chinh
			while (!s2.isEmpty()) {
				String tmp = s2.pop();
				obsPop(2);
				s1.push(tmp);
				obsPush(1);
			};
		}
		else obsRespond("Wrong ID");
    }
    void changeAutoButtonClick() throws IOException {
    	resetPane();
    	Stage stage= (Stage) backButton.getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/controllsense/AutoSense.fxml"));
    	Parent autoView = loader.load();
    	Scene scene = new Scene(autoView);
    	ObsControll controller = loader.getController();
    	FirstSenseControll tmp = new FirstSenseControll();
    	controller.createAll(tmp.clonetruyen);
    	stage.setScene(scene);
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	stage.setMaxHeight(screenSize.getHeight());
    	stage.setMaxWidth(screenSize.getWidth());
    	stage.setMinHeight(screenSize.getHeight());
    	stage.setMinWidth(screenSize.getWidth());
    	stage.setMaximized(true);
    }
    
    void resetPane() {
    	sequence.pause();
    	sequence.getChildren().clear();
    	sequence=new SequentialTransition();
    	idText.clear();
    	sequence.rateProperty().bind(speedSlide.valueProperty());
    	for (int i=0;i<=countAllButton;i++) {
    		rootPane.getChildren().remove(allButton[i]);
    	}
    	for (int i=0;i<=countAllText;i++) {
    		rootPane.getChildren().remove(allText[i]);
    	}
    	countAllButton=0;
    	countAllText=0;
    	defaultText=0;
    	pushButton.setDisable(false);
    	popButton.setDisable(false);
    	topStack1.setX(rootLine1.getLayoutX()-(sideLine1.getEndX()-sideLine1.getStartX())/sizeOfStack);
    	topStack1.setY(sideLine1.getLayoutY());
    	topStack2.setX(sideLine2.getLayoutX());
    	topStack2.setY(rootLine2.getLayoutY()-buttonSize.getX());
    	trunggianM.setY(sideLine1.getLayoutY()+(rootLine1.getEndY()-rootLine1.getStartY())/2);
		trunggianM.setX(rootLine2.getLayoutX()-rootLine1.getEndX()-buttonSize.getX()/2);
		s1= new ArrayStringStack(sizeOfStack);
    	s2= new ArrayStringStack(sizeOfStack);
    	stack1= new ArrayButton(sizeOfStack);
        stack2= new ArrayButton(sizeOfStack);
    }
}
