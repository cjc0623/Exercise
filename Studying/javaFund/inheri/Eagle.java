package javaFund.inheri;

public class Eagle extends Animal implements Fly, BirdInter{
	
	
	int speed = EAGLE_VELOCITY;
	public Eagle(String type) {
		super("독수리");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		
	}
	
	public int currentSpeed() {
		return BirdInter.getSpeed();
		
	}

	
}
