package RestAssuredReference;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Put_Reference {
	public static void main(String[] args) {

		RestAssured.baseURI="https://reqres.in/";
		int statuscode=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().put("/api/users/2").then().extract().statusCode();
		String responseBody=given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").log().all().when().put("/api/users/2").then().log().all().extract().response().asString();
		System.out.println(responseBody);
		//parse	the response body
		JsonPath jsp=new JsonPath(responseBody);
		String res_name=jsp.getString("name");
		String res_job=jsp.getString("job");
		System.out.println(res_name);

	//validate response body 
	Assert.assertEquals(res_name,"morpheus");
	Assert.assertEquals(res_job,"zion resident");

	}

}
