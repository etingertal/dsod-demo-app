package io.github.anantharajuc.sbmwa.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

/**
 * Class that implements the API utility methods.
 * 
 * @author <a href="mailto:anantharajuc@gmail.com">Anantha Raju C</a>
 */
public class APIutil 
{
	@Value("${api.name}")
	private static final String API_NAME = "spring-boot-minimal-web-app";
	
	@Value("${api.version}")
	private static final String API_VERSION = "2021-11-28";
	
	private APIutil() 
	{
		
	}
	
	/**
	* Field to represent API version on the requests/responses header
	* 
	*/
	public static final String HEADER_API_VERSION = "api-version";
	
	/**
	* Field to represent API name on the requests/responses header
	* 
	*/
	public static final String HEADER_API_NAME = "api-name";
	
	/**
	* Method to return API responses headers
	* 
	*/
	public static final HttpHeaders returnHttpHeaders() 
	{
        HttpHeaders headers = new HttpHeaders();
        
        headers.set(APIutil.HEADER_API_NAME, API_NAME);
        headers.set(APIutil.HEADER_API_VERSION, API_VERSION);

        return headers;
    }
}