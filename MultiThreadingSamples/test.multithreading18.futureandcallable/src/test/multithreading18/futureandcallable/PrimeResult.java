package test.multithreading18.futureandcallable;

public class PrimeResult {
	
	int min;
	int max;
	int primes;
	long timeTaken;
	
	
	public long getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrimes() {
		return primes;
	}
	public PrimeResult(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	public void addPrime() { primes++; }
	@Override
	public String toString() {
		return "PrimeResult [min=" + min + ", max=" + max + ", primes=" + primes + ", timeTaken=" + timeTaken + "]";
	}
	
	
	

}
