package lesson4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ExampleMain {

    ResponseSpecification responseSpecification = null;
    RequestSpecification requestSpecification = null;
    private final String apiKey = "3ac74321b7ca479b903dbd2263004ec7";

    @BeforeEach
    void beforeTest() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
//                .expectHeader("Access-Control-Allow-Credentials", "true")
                .build();

//        RestAssured.responseSpecification = responseSpecification;
//        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("includeNutrition", "false")
                .log(LogDetail.ALL)
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("intolerances", "gluten")
                .log(LogDetail.ALL)
                .build();

//        RestAssured.responseSpecification = responseSpecification
//                        .expect()
//                        .body(containsString("offset"));
    }

    @Test
    void getRecipePositiveTest() {
        given().spec(requestSpecification)
                .when()
                .get("https://api.spoonacular.com/recipes/716429/information").prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getAccountInfoWithExternalEndpointTest() {
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","Burger")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("American"));
    }

    @Test
    void getRecipeСomplexSearchTest() {
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","Pasta With Tuna")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("Italian"));
    }

    @Test
    void getRecipeComplexSearchPositiveTest() {
        given()
                .spec(requestSpecification)
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch?query=pasta&minProtein=10")
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getRecipesСomplexSearchTest() {
        Response response = given().spec(requestSpecification)
                .when()
                .queryParam("offset",0)
                .get("https://api.spoonacular.com/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("nutrition"));
    }

    @Test
    void getRequestSpecificationTest() {
        Response response = given().spec(requestSpecification)
                .when()
                .queryParam("query", "Pasta")
                .post("https://api.spoonacular.com/recipes/complexSearch").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("totalResults"));
    }

    @Test
    void getResponseIngredientListTest() {
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("ingredientList","3 oz pork shoulder")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("Italian"));
    }

    @Test
    void getPositiveTest() {
        given().spec(requestSpecification)
                .when()
                .get("https://api.spoonacular.com/recipes/recipes/complexSearch?maxReadyTime=20").prettyPeek()
                .then()
                .spec(responseSpecification);
    }

    @Test
    void getAccountInfoWithExternalTitleTest() {
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","Burger")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("Caribbean"));
    }

}



