package tests.api;

import config.api.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import static helpers.api.CustomAllureListener.withCustomTemplates;

public class TestBase {
    private static final ApiConfig config = ConfigFactory.create(ApiConfig.class);

    @BeforeAll
    static void setUp() {
        RestAssured.filters(withCustomTemplates());
        RestAssured.baseURI = config.baseUrl();
    }
}