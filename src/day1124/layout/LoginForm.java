package day1124.layout;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginForm extends Application{

	public void start(Stage stage) throws Exception {
		GridPane parent = new GridPane();
		FlowPane child1 = new FlowPane();
		FlowPane child2 = new FlowPane();
		parent.add(child1, 0, 0);
		parent.add(child2, 0, 1);
		
		TextField field = new TextField();
		Button bt = new Button("로그인"); 
		TextArea area = new TextArea();
		area.setPrefSize(240, 230);
		
		child1.getChildren().add(field);
		child1.getChildren().add(bt);
		child2.getChildren().add(area);
		
		showWindow(stage, parent);
		
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);
		stage.setScene(s);//생성된 씬을 윈도우에 적용
		stage.setWidth(260);//너비
		stage.setHeight(300);//높이
		stage.show();//윈도우 보여주기		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
