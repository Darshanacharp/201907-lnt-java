package in.conceptarchitect.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SimpleRestClient {
	
	String contentType = "application/json";
	String baseUrl;
	
	
	
	public String get(String url) {
		HttpURLConnection connection=null;
		try {
			
			
			connection = getConnection(url);
			
			
	
			if (connection.getResponseCode() != 200) {
				throw new ServiceException("Failed : HTTP error code : "
						+ connection.getResponseCode(), connection.getResponseCode());
			}
	
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(connection.getInputStream())));
	
			StringBuilder responseData=new StringBuilder();
			String output=null;
			
			while ((output = br.readLine()) != null) {
				responseData.append(output);
			}
	
			return responseData.toString();
		}catch(ServiceException ex) {
			throw ex;
		}
		catch(Exception ex) {
			throw new ServiceException("Error Invoking Service  : "+ex.getMessage(),ex);
		}
		finally {
			connection.disconnect();
		}
	}



	private HttpURLConnection getConnection(String url) throws MalformedURLException, IOException, ProtocolException {
		
		
		HttpURLConnection conn;
		URL _url = new URL(url);
		conn = (HttpURLConnection) _url.openConnection();
		
		conn.setRequestMethod("GET");
		
		
		conn.setRequestProperty("Accept", contentType);
		return conn;
	}

}
