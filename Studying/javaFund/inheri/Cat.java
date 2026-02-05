package javaFund.inheri;

public class Cat extends Animal {

	public String name;
	public String breed;

	public Cat(String name, String breed) {
		super("고양이");
		
		this.name = name;
		this.breed = breed;
	}
	
	public String toString() {
		return super.toString() + " 이름은 " + name + " 품종은 " + breed; 
	}
	
	@Override
	public void sound() {
		System.out.println("야옹야옹");
	}
}
