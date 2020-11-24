package day1124.layout;

//GridPane은 AWT의 GridLayout과 기능이 같다

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneApp extends Application{
	
	public void start(Stage stage) throws Exception {
		GridPane parent = new GridPane();
		//AWT와는 다르게, 컨테이너에 부착시 행, 열 형태가 결정됨
		Button[] btn = new Button[6];
		
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button("버튼"+i);
			btn[i].setPrefWidth(100);
			btn[i].setPrefHeight(100);
			parent.add(btn[i], i % 3, i / 3);
		}
		
		showWindow(stage, parent);
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);
		stage.setScene(s);//생성된 씬을 윈도우에 적용
		stage.setWidth(500);//너비
		stage.setHeight(500);//높이
		stage.show();//윈도우 보여주기		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
