package day1124.components;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageViewApp extends Application{	
	ImageView imageView;
	String url;
	Image img;
	
	public void start(Stage stage) throws Exception {
		//Image객체를 이용하는 방법
		url = "https://img.lovepik.com/original_origin_pic/18/11/15/a567020c42a9aed9e02e2e0d7a70aa11.png_wh860.png";
		img = new Image(url);
		imageView = new ImageView(img);
//		
		
		//이미지의 비율을 자체적으로 계산하여 유지하는 방법?
		imageView.setPreserveRatio(true);//비율 유지
		imageView.setFitWidth(300);
		imageView.setFitHeight(300);
		
		FlowPane parent = new FlowPane(imageView); //add메서드 댓ㄴ에 이런 방식도 가능
		
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
