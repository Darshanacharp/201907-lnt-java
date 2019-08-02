package in.conceptarchitect.animalkingdom;

public abstract class Animal {

	public abstract String eat() ;
	
	public abstract String move();
	
	public final String die() {
		return this+" is dead";
	}
	@Override
	public String toString() {
		//return "Animal";
		return this
				.getClass() //get class of this object
				.getSimpleName(); //find simple name for that class
	}
	
	public final boolean isDomestic() {
		return this instanceof Domestic;
	}
	
	
}
