package in.conceptarchitect.animalkingdom;

public class Horse extends Mammal implements Rideable,Domestic {

	@Override
	public String eat() {
		
		return this+" is grass eater";
	}
	
	
	
	public String ride() {
		return this+" is a great ancient ride";
	}
	
}
