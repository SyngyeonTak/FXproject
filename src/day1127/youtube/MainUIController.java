/*
 * javaFX는 이벤트 처리를 전담할 수 있는 객체를 지원한다.(이를 컨트롤러라 한다.)
 * Initializable
 * */
package day1127.youtube;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.web.WebView;

public class MainUIController implements Initializable{
	//개발자가 직접 lookup하는 것이 아니라, 시스템에 의해 자동으로 객체를 주입(injection)받자!!
	//@는 어노테이션(annotation) 이라 부르는 일종의 주석인데, 이 주석은 우리가 알고 있던 일반 주석과는 달리 프로그램에서 사용된다.
	//jdk 5버전부터 지원하기 시작
	@FXML
	Button bt;
	
	@FXML
	TextField t_url;
	
	@FXML
	TextField t_title;
	
	@FXML
	TilePane tilePane;
	
	//이 메서드는 현재 클래스가 생성될때, 자동으로 호출되는 초기화 메서드이다!!
	//URL은 이 응용 프로그램이 사용중인 layout.xml의 경로가 넘어온다.
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("location 값: "+location);
		System.out.println("resources 값: "+resources);
		
		bt.setOnAction((e)->{
			createThumb();
		});
		
	}
	
	//유튜브 썸네일 생성하기
	public void createThumb() {
		try {
			BorderPane borderPane = (BorderPane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1127/youtube/thumb.fxml"));
			//부착전에, 썸네일과 제목을 가져오자
			WebView webView= (WebView)borderPane.lookup("#webView");
			Label la_title = (Label)borderPane.lookup("#la_title");
			
//			webView.getEngine().load(t_url.getText());
//			StringBuffer sb = new StringBuffer();
//			sb.append("<iframe");
//			sb.append(" width=\"200\" height=\"155\"");
//			sb.append(" src=\""+t_url.getText()+"\"");
//			sb.append(" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write;");
//			sb.append("encrypted-media; gyroscope; picture-in-picture\" allowfullscreen>");
//			sb.append("</iframe>");

			
			webView.getEngine().loadContent(t_url.getText(), "text/html");
			la_title.setText(t_title.getText());
			
			//로드된 유튜브 썸네일을 타일패인에 부착!!
			tilePane.getChildren().add(borderPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






