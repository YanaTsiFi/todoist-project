package models;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import config.api.ApiConfig;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class ApiSpecs {
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);
    static String token = config.token();
    static String baseUrl = config.baseUrl();

    public static RequestSpecification getRequest = with()
            .header("Authorization", "Bearer " + token)
            .baseUri(baseUrl)
            .contentType(ContentType.JSON);

    public static ResponseSpecification response200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification response204 = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification response400or422 = new ResponseSpecBuilder()
            .expectStatusCode(anyOf(is(400), is(422)))
            .log(LogDetail.BODY)
            .build();


    public static RequestSpecification creationRequest = with()
            .header("Authorization", "Bearer " + token)
            .header("X-Request-Id", "$(uuidgen)")
            .contentType("application/json")
            .baseUri(baseUrl);
}