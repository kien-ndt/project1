package controllsense;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAppClass extends Application{
	@Override
	   public void start(Stage primaryStage) {
	       try {
	           Parent root = FXMLLoader.load(getClass()
	                   .getResource("/controllsense/SetupSense.fxml"));
	           primaryStage.setMaximized(true);
	           primaryStage.setTitle("Stack");
	           primaryStage.setScene(new Scene(root));
	           primaryStage.show();
	       } catch(Exception e) {
	           e.printStackTrace();
	       }
	   }
	  
	   public static void main(String[] args) {
	       launch(args);
	   }
	  
	}
