package demo.generics;

@FunctionalInterface
public interface Selector<T> {

	boolean selects(T value);
	//boolean compare(T value1,T value2);

}
