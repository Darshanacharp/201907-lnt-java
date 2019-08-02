package in.conceptarchitect.animalkingdom;

public class Parrot extends Bird implements Domestic{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is fruitarian";
	}
	
	public String humanSpeak() {
		return this+" can speak in human tounge";
	}
}
