package demo.generics;

//@FunctionalInterface
public interface Action<T> {

	void execute(T value);

}
