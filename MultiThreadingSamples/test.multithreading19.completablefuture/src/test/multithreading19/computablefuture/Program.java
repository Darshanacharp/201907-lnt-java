package test.multithreading19.computablefuture;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Program {

	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		

		
		
		int [] ranges= {500000,50000,200000};
		
		
		for(int max:ranges) {
			
			//TODO: 2. invoke the countPrimeAsync and then provide the completion task
			
			System.out.println("finding primes between 2 - "+max);
			countPrimeAsync(2, max)  //when the program complete accept the result
				.thenAccept(r->System.out.println(r)); //and do whatever you like
			
			
		
			
		}
		
		System.out.println("waiting for responses");
		
		new Scanner(System.in).nextLine();
			
	}
	
	static CompletableFuture<PrimeResult> countPrimeAsync(final int min,final int max){
		
		//TODO: 1. convert countPrime to countPrimeAsync by calling supplyAsync() method
		CompletableFuture<PrimeResult> result= CompletableFuture.supplyAsync(()->countPrimes(min,max));
		
		return result;
		
	}
	
	
	static PrimeResult countPrimes(int min,int max) {
		PrimeResult result=new PrimeResult(min, max);
		long start=System.currentTimeMillis();
		for(int i=min;i<max;i++) {
			if(isPrime(i))
				result.addPrime();
		}
		long end=System.currentTimeMillis();
		
		result.setTimeTaken(end-start);
		return result;
	}

	private static boolean isPrime(int x) {
		
		x=Math.abs(x);
		if(x<2)
			return false;
		
		for(int i=2;i<x;i++)
			if(x%i==0)
				return false;
		
		return true;
	}

}
