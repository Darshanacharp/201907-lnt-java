package in.conceptarchitect.finance;

@FunctionalInterface
public interface Action<T> {
	void act(T value);
}
