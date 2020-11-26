/*
 * 달력에 사용되는 셀을 정의한다!!
 * */

package day1126.calendar;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Box extends Canvas{
	String title;
	int width;
	int height;
	GraphicsContext context;
	
	public Box(String title, int width, int height) {
		this.title = title;
		this.width =width;
		this.height = height;
		this.setWidth(width);//너비
		this.setHeight(height);//높이
		//모든 컴포넌트는 그래픽 처리에 사용되는 객체를 가지고 있다..
		context= this.getGraphicsContext2D();

		erase();

		//글씨 그리기
		context.setFill(Color.BLACK);//페인트통 교체
		context.setFont(new Font(17));//포트 크기 설정
		context.fillText(title, 2, 20);
	
	}
	
	public void erase() {
		context.setFill(Color.YELLOW);
		context.fillRect(0, 0, 100, 100);//노란색 채워진 사각형
		
		//구분라인
		context.setStroke(Color.ORANGE);//선의 색상
		context.strokeRect(0, 0, width, height);
	}
	
}











