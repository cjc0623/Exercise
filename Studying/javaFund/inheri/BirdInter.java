package javaFund.inheri;

public interface BirdInter extends Fly,BirdVelocity {

	default void birdFly() {
		System.out.println("독수리가 "+ EAGLE_VELOCITY + " 속도로 날고 있음");
	}
	static int getSpeed() {
		return EAGLE_VELOCITY;
	}
}
