package lesson3;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static io.restassured.RestAssured.given;
import static lesson3.PropertiesTest.getApiKey;
import static lesson3.PropertiesTest.getBaseUrl;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//public class RestApi {
//
//    String baseUrl = "https://api.spoonacular.com/";
//    String apiKey = "3ac74321b7ca479b903dbd2263004ec7";
//    int id = 715497;
//
//    @Test
//    void getRecepiesRequestOneTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("includeNutrition", "false")
//                .when()
//                .get("https://api.spoonacular.com/recipes/716429/information")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesResponseOneTest() {
//        Response response = given()
//                .when()
//                .get("https://api.spoonacular.com/recipes/716429/information");
//        Headers allHeaders = response.getHeaders();
//        System.out.println("Content-Encoding: " + response.getHeader("Content-Encoding"));
//    }
//
//    @Test
//    void getRecipeRequestPositiveOneTest() {
//        JsonPath response = given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("includeNutrition", "false")
//                .when()
//                .get("https://api.spoonacular.com/recipes/716429/information")
//                .body()
//                .jsonPath();
//        assertThat(response.get("license"), equalTo("CC BY-SA 3.0"));
//    }

//    @Test
//     void getRecepiesRequestTwoTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("equipment", "pan")
//                .when()
//                .get("https://api.spoonacular.com/recipes/" +
//                        "complexSearch?query=pasta&maxFat=25&number=2")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesResponseTwoTest() {
//        Response response = given()
//                .when()
//                .get("https://api.spoonacular.com/recipes/" +
//                        "complexSearch?query=pasta&maxFat=25&number=2");
//        Headers allHeaders = response.getHeaders();
//        System.out.println("Content-Encoding: " + response.getHeader("Content-Encoding"));
//    }
//
//
//    @Test
//    void getRecipeRequestPositiveTwoTest() {
//        JsonPath response = given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("equipment", "pan")
//                .when()
//                .get("https://api.spoonacular.com/recipes/" +
//                        "complexSearch?query=pasta&maxFat=25&number=2")
//                .body()
//                .jsonPath();
//        assertThat(response.get("offset"), equalTo(0));
//    }
//
//    @Test
//    void getRecepiesRequestThreeTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("maxSodium", 100)
//                .when()
//                .get("https://api.spoonacular.com/recipes/")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesResponseThreeTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("maxSodium", 100)
//                .when()
//                .get("https://api.spoonacular.com/recipes/")
//                .then()
//                .assertThat()
//                .statusLine("HTTP/1.1 200 OK");
//    }
//
//
//
//    @Test
//    void getRecepiesRequestFourTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("maxSugar", 100)
//                .when()
//                .get("https://api.spoonacular.com/recipes/")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesResponseFourTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("maxSugar", 100)
//                .response()
//                .contentType(ContentType.JSON)
//                .header("Connection", "keep-alive")
//                .expect()
//                .body("totalResults", equalTo(177))
//                .when()
//                .get("https://api.spoonacular.com/recipes/complexSearch");
//    }
//
//    @Test
//    void getRecepiesRequestFiveTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("limitLicense", "true")
//                .when()
//                .get("https://api.spoonacular.com/recipes/")
//                .then()
//                .statusCode(200);
//
//    }
//
//    @Test
//    void getRecepiesCuisineRequestOneTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("title", "Pork roast with green beans")
//                .when()
//                .post("https://api.spoonacular.com/recipes/cuisine")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesCuisineRequestTwoTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .queryParam("language", "en")
//                .when()
//                .post("https://api.spoonacular.com/recipes/cuisine")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesCuisineRequestThreeTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("ingredientList", "3 oz pork shoulder")
//                .when()
//                .post("https://api.spoonacular.com/recipes/cuisine")
//                .then()
//                .statusCode(200);
//
//    }
//
//    @Test
//    void getRecepiesCuisineRequestFourTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("ingredientList", "3 oz pork shoulder")
//                .queryParam("language", "en")
//                .when()
//                .post("https://api.spoonacular.com/recipes/cuisine")
//                .then()
//                .statusCode(200);
//    }
//
//    @Test
//    void getRecepiesCuisineRequestFiveTest() {
//        given()
//                .queryParam("apiKey", "3ac74321b7ca479b903dbd2263004ec7")
//                .contentType("application/x-www-form-urlencoded")
//                .formParam("title", "Pork roast with green beans")
//                .queryParam("language", "de")
//                .when()
//                .post("https://api.spoonacular.com/recipes/cuisine")
//                .then()
//                .statusCode(200);
//    }
//
//}
//


