package specs;

import config.api.ApiConfig;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class ApiSpecs {
    private static final ApiConfig config = ConfigFactory.create(ApiConfig.class);
    private static final String TOKEN = config.token();

    public static final RequestSpecification baseRequest = with()
            .header("Authorization", "Bearer " + TOKEN)
            .contentType(ContentType.JSON)
            .log().all();

    public static final RequestSpecification creationRequest = baseRequest
            .header("X-Request-Id", java.util.UUID.randomUUID().toString());

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(LogDetail.BODY)
                .build();
    }

    public static ResponseSpecification responseSpec(int... statusCodes) {
        if (statusCodes.length == 1) {
            return responseSpec(statusCodes[0]);
        }
        return new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(statusCodes[0]), is(statusCodes[1])))
                .log(LogDetail.BODY)
                .build();
    }
}