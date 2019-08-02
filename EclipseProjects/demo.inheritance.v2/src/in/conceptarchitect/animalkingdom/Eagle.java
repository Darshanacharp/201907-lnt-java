package in.conceptarchitect.animalkingdom;

public class Eagle extends Bird implements Hunter{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is flesheater";
	}
	
	public String hunt() {
		return this+" is a flying hunter";
	}
	
}
