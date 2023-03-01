package ObjectRepository;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetPrice {
	
	
	Response response;
	
	public String getPrice(double amount, String symbol, String convert)
	{
		 response = given().header("X-CMC_PRO_API_KEY", "18b8185f-b3d3-43b8-93f4-88654037befd")
		   .header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		   .header("Accept-Encoding", "deflate, gzip")
		   .queryParam("amount", amount)
		   .queryParam("symbol", symbol)
           .queryParam("convert", convert)
           .when().get("/v1/tools/price-conversion")
       	   .then().extract().response();
		
		String rep=response.asString();
       	   
       	JsonPath js = new JsonPath(rep);
		String cnvert = convert;
		String t = "data."+"quote."+ cnvert +".price";
		String value = js.getString(t);
		return value;
		

	}
	
	public int getResponseCode()
	{
		
	int code=response.getStatusCode();                   
	Assert.assertEquals(code, 200);
	return code;
	
	}
	

}
