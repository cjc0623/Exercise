package javaFund.utilex;
/*
 * Generic : 필드의 타입을 생성시에 지정하여 대입하도록 하는 것
 */

class Box<T>{ 
//	이 객체의 필드의 타입을 결정하도록 하는 키워드 T 를 선언한다
//	T 는 type 의 키워드로 그냥 문자에 지나지 않음.. A~Z 까지 쓰고 싶은거 써도됨
//	단 T 가 type 으로 이해되기 가장 쉽기 떄문에 T 를 사용함..
//	또 하나, 이렇게 타입을 지정하면 내부의 컨텐츠는 반드시 클래스나 인터페이스 타입이어야 함
//	즉 객체 타입이라는 뜻.. P type 은 wrapping 되서 써야함.
	
	public T content;
}
class GiftBox<T>{
	private T t;
	
	public T get() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
}



class Product<K,M>{
	private K kind;
	private M model;
	
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
}
class Tv{
	
}
class Car{
	 public void run() {
		 System.out.println("자동차가 달립니다.");
	 }
	
}
//		이번에는 상품을 렌트하도록 하는 인터페이스를 정의 할게요
//		어떤 상품을 렌트할지는 타입 결정에 따릅니다.

interface Rentable<P>{
	P rent();
}

class Home{
	public void turnOnLight() {
		System.out.println("전등을 켬");
	}
}

//		위 인터페이스를 구현한 클래스를 정의하고, 이 클래스의 메서드를 이용해서 rent() 를 수행하자 
class HomeAgency implements Rentable<Home>{
	@Override
	public Home rent() {
		return new Home();
	}
}

//		자동차를 렌트합니다.
class CarAgency implements Rentable<Car>{
	@Override
	public Car rent() {
		return new Car();
	}
}

/*
 * 제한된 타입의 파라미터 처리하는법..
 * 이 내용은 특정 파라미터가 특정 타입의 하위 타입으로만 제한을 시킬 떄 많이 사용함
 * 즉, 파라미터가 특정 타입의 하위 타입이거나, 구현된 타입으로만 제한 시켜
 * 대입되도록 하는데 목적이 있다.
 * ex) public <T extends SuperType> 리턴타입 메서드명(파라미터....)
 */
public class GenericEx {
	
//	제한된 메서드 타입 파라미터를 갖는 제네릭 메서드 정의
	public static <T extends Number> boolean compare(T t1, T t2) {
//		T의 타입을 출력합니다
		System.out.println("compare (" + t1.getClass().getSimpleName() + " , " + t2.getClass().getSimpleName()+ ")");
		
		double v1 = t1.doubleValue();
		double v2 = t2.doubleValue();
		
		return (v1==v2);
		
	}
	
//	제네릭 메서드를 구현시엔 <T>타입<T> 형태로 선언 해야 합니다.
	public static <T>GiftBox<T> boxing(T t){
		GiftBox<T> box = new GiftBox<T>();
		box.setT(t);
		return box;
	}

	public static void main(String[] args) {
		
		boolean result1 = compare(10, 20);
		System.out.println(result1);
		System.out.println();
		
		boolean result2 = compare(4.5,4.5);
		System.out.println(result2);
		
		
		GiftBox<Integer> gbox1 = boxing(100);
		int value = gbox1.get();
		System.out.println(value);
		
		GiftBox<String> gbox2 = boxing("홍길동");
		String strValue = gbox2.get();
		System.out.println(strValue);
		
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
//		TV 를 Product 의 필드값으로 세팅시에 제네릭을 이용한다
		Product<Tv,String> product1 = new Product();
		product1.setKind(new Tv());
		product1.setModel("스마트디브이");
		
//		세팅된 제네릭 필드를 get
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		Product<Car,String> product2 = new Product();
		product2.setKind(new Car());
		product2.setModel("SUV 자동차");
		
//		Car car = product2.getKind();
//		String carModel = product2.getModel();
		
		Box<String> box1 = new Box();
		box1.content = "안녕하세요.";
		String str = box1.content; //형변환 없이 get
		System.out.println(str);
		
		Box<Integer> box2 = new Box();
		box2.content = 100;
//		int value = box2.content; //형변환 없이 get
//		System.out.println(value);
	}

}
