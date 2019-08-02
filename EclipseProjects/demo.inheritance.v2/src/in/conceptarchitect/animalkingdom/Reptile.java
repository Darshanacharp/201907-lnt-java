package in.conceptarchitect.animalkingdom;

public abstract class Reptile extends Animal implements Hunter{
	@Override 
	public String move() {
		return this+" crawls";
	}
	
	@Override
	public String eat() {
		return this+" all flesheater";
	}
	
	public abstract String hunt();
}
