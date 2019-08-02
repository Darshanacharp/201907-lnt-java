package in.conceptarchitect.animalkingdom;

public class Cow extends Mammal implements Domestic {

	@Override
	public String eat() {
		
		return this+" is grass eater";
	}
	
}
