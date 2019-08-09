package demo.generics;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	
	
	public <T> T [] copyToArray(List<T> values,
			T[] container) {
		
		for(int i=0;i<values.size();i++) {
			container[i]= values.get(i);
		}
		
		return container;
	}
	
	public <T> List<T> search(List<T> values, 
			Selector<T> selector) {
		// TODO Auto-generated method stub
		List<T> result=new ArrayList<>();
		
		for(T value: values)
			if(selector.selects(value))
				result.add(value);
		
		return result;
	}
	
	
	
//	public List<Integer> searchEvens(List<Integer> values) {
//		// TODO Auto-generated method stub
//		List<Integer> result=new ArrayList<>();
//		for(int value: values)
//			if(value%2==0)
//				result.add(value);
//		return result;
//	}
	
	
//	public List<String> searchMinStringLength(List<String> values,int min) {
//		// TODO Auto-generated method stub
//		List<String> result=new ArrayList<>();
//		for(String value : values)
//			if(value.length()>=min)
//				result.add(value);
//		return result;
//	}
//	public List<String> searchForUpperCaseWords(List<String> values) {
//		// TODO Auto-generated method stub
//		List<String> result=new ArrayList<>();
//		for(String value : values)
//			if(value.equals(value.toUpperCase()))
//				result.add(value);
//		return result;
//	}
//
//	
	
	
	
	public <I,O> List<O> convert(List<I> inputValues, Converter<I,O> converter) {
		// TODO Auto-generated method stub
		List<O> outputValues=new ArrayList<>();
		
		for(I inputValue : inputValues) {
		
			//O output = inputValue.length();
			O output= converter.convert(inputValue);
			
			outputValues.add(output);
		}
		
		
		return outputValues;
	}
	
	
	
	public <T> void process(List<T> list, Action<T> action) {
		
		for(T value : list) {
			action.execute(value);
		}
		
	}
		
}
