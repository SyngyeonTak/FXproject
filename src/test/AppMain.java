package test;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * javaFX
 * Swing
 * 중립적 클래스
 * FX Application 생명주기 메서드가 지원됨
 * */

public class AppMain extends Application {
	/*
	 * javaFX 어플리케이션을 정의하기 위해서는 반드시 Application 추상 클래스를 상속받아야 한다.
	 * launch 호출시 쓰레드 2개(init vs start/stop)가 호출
	 * ui, event는 start/stop 쓰레드가 관리한다.
	 */
	//생성자 호출
	public AppMain() {
		System.out.println("생성자 호출 by "+Thread.currentThread().getName());
	}
	
	/*
	 	어플리케이션 시작전 초기화를 담당하는 메서드이다. 따라서 초기화 할 게 없다면
		재정의는 필수가 아니다.
		생성자: 인스턴스가 태어날 때 호출되는 매서드
		vs
		init(): 태어난 이후에 초기화 작업에서 호출되는 매서드
	*/
	public void init() throws Exception {
		//자바의 쓰레드의 메서드 중 현재 실행중인 쓰레드 정보를 얻기 위한 메서드
		System.out.println("init() 메서드 호출 by "+Thread.currentThread().getName());
	}
	
	//어플리케이션이 실행할 준비가 되면 호출되는 메서드
	public void start(Stage stage) throws Exception {
		System.out.println("start() 메서드 호출 by "+Thread.currentThread().getName());
		
		//무대를 정의한다!!(FX에서는 윈도우에 반드시 하나의 한 scene이 존재해야 한다.)
		VBox parent = new VBox();//수직으로 컴포넌트를 배치하는 레이아웃 객체
													//FlowLayout과 비슷하다.
		
		
		Scene s = new Scene(parent);//parent란 부모클래스를 의미하는 것이 아니라, 객체간 포함관계에서
													//바깥쪽 컨테이너를 의미
													//Swing과 비유하자면 레이아웃 객체가 parent이다.
		Button bt = new Button("나 버튼");
		bt.setPrefWidth(200);
		bt.setPrefHeight(40);
		
		//버튼을 parent에 부착하기
		parent.getChildren().add(bt);
		TextField t = new TextField("test");
		parent.getChildren().add(t);
		//Scene을 윈도우에 부착
		stage.setScene(s);
		
		bt.setOnAction((e)->{
			System.out.println("클릭했어?");
		});
		
		//매개변수로 받은 stage 변수에가 어플리케이션의 윈도우이다!!
		stage.setMaxWidth(500);
		stage.setMaxHeight(500);
		stage.show();//setVisible과 비슷-> 윈도우 보이게
	}
	
	public void stop() throws Exception {
		System.out.println("stop() 메서드 호출");
	}


	public static void main(String[] args){
		System.out.println("launch() 메서드 호출 by "+Thread.currentThread().getName());
		launch(args);//실행명령어 -> start메서드가 호출됨
	}
}











