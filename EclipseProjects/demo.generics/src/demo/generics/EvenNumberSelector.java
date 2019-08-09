package demo.generics;

public class EvenNumberSelector 
	implements Selector<Integer> {

	@Override
	public boolean selects(Integer value) {
		// TODO Auto-generated method stub
		return value%2==0;
	}

}
