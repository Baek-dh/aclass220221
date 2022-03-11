package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.vo.Car;
import edu.kh.poly.ex1.model.vo.Spark;
import edu.kh.poly.ex1.model.vo.Tesla;

public class PolyService {

	public void ex1() {
		// 다형성 확인 예제
		
		// Car 객체 생성
		Car car = new Car();
		// 부모타입 참조변수 = 부모 객체
		
		// Tesla 객체 생성
		Tesla tesla = new Tesla();
		// 자식타입 참조변수 = 자식 객체
		
		// ***** 다형성(업캐스팅) *****
		Car car2 = new Tesla(); // -> 오류 발생 안함
		// Tesla 객체를 참조하는 변수의 타입이 Car 이기 때문에
		// Tesla 객체가 Car 객체로 변화함.
		
		Car car3 = new Spark();
		// 부모타입 참조변수 = 자식 객체
		
		
	}
	
}




