package demo.generics;

@FunctionalInterface
public interface Converter<I, O> {

	O convert(I inputValue);

}
		