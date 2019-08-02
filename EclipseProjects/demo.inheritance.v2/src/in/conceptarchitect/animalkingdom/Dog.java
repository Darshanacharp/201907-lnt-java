package in.conceptarchitect.animalkingdom;

public class Dog extends Mammal implements Hunter,Domestic {

	@Override
	public String eat() {
		
		return this+" is flesheater";
	}
	
	
	
	public String hunt() {
		return this+" is a great hunter";
	}
	
}
