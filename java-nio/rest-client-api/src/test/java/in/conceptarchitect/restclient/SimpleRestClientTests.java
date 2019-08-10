package in.conceptarchitect.restclient;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleRestClientTests {

	@Test
	public void test() {
		SimpleRestClient client=new SimpleRestClient();
		String data= client.get("http://api.conceptarchitect.in/api/movies");
		System.out.println(data);
		assertTrue(data.length()>0);
	}

}
