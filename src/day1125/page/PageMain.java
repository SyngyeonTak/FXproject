/*
 * FX에서의 페이지 전환, 화면 전환
 * */
package day1125.page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PageMain extends Application{
	String[] naviTitle = {"MAIN", "SHOPPING", "MEMBER", "LOGIN"};
	Pane[] page = new Pane[naviTitle.length];//배열화 시켜야 반복문 등에서 처리 가능
	Button[] btn = new Button[naviTitle.length];
	ToolBar bar;//네비게이션을 포함하는 메뉴바
	BorderPane border;
	public void start(Stage stage) throws Exception {
		border = new BorderPane();
	
		//xml로 디자인된 파일을 자바객체로 변환하기!!(안드로이드에서는 이 과정을 inflation이라고 한다.)
		
		//반환되는 컨테이너가 무엇인지 예측할 수 없으므로 보다 상위 자료형으로 받자!!
		//컨테이너를 너무 높이 올라가면 메서드가 없는 경우가 있으므로 Pane자료형이 적당하다.
		for (int i = 0; i < page.length; i++) {
			page[i] =  (Pane)FXMLLoader.load(this.getClass().getClassLoader().getResource("day1125/page/"+naviTitle[i].toLowerCase()+".fxml"));//main
			
		}
		
		//네비게이션 만들기
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(naviTitle[i]);

			//i가 내부 익명함수에서 인식되지 않으므로(왜? i는 지역변수니까)
			//setId, getId를 이용한다.
			btn[i].setId(Integer.toString(i));
			
			//버튼에 액션 이벤트 연결
			btn[i].setOnAction((e)->{
				Button bt = (Button)e.getSource();
				System.out.println(bt.getId());
				showPage(page[Integer.parseInt(bt.getId())]);
			});
		}
		
		bar = new ToolBar(btn[Pages.MAIN.ordinal()],
				btn[Pages.SHOPPING.ordinal()],
				btn[Pages.MEMBER.ordinal()],
				btn[Pages.LOGIN.ordinal()]);//툴바 생성
		
		bar.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		border.setTop(bar);//생성된 바를 top 영역에 부착!!
		
		showPage(page[Pages.MEMBER.ordinal()]);//ordinal은 순서를 의미
		showWindow(stage, border);
	}
	//페이지 전환 메서드 정의: swing에서 우리가 정의한 showPage() 역할 메서드 정의
	public void showPage(Pane p) {
		//swing에서는 미리 부착한 컴포넌트 (주로 패널)를 보이거나 않보이게 하면 되지만,
		//fx에서는 물리적으로 부착하고, 제거하는 처리로 가야한다.
		//기존에 border에 붙여진 컴포넌트가 존재한다면 모두 제거!!!
		border.getChildren().removeAll(border.getChildren());//싹~~~지워짐
		
		border.setTop(bar);//bar 다시 부착
		border.setCenter(p);//xml에서 로드한 컨테이너 / swing에서 setVisible과 다르다
		
	}
	
	public void showWindow(Stage stage, Parent parent) {
		Scene s = new Scene(parent);
		stage.setScene(s);//생성된 씬을 윈도우에 적용
		stage.setWidth(800);//너비
		stage.setHeight(700);//높이
		stage.show();//윈도우 보여주기		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}











