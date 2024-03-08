package org.acme;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {

  @Test
  void testHelloEndpoint() {
    given()
      .when().get("/hello")
      .then()
        .statusCode(200)
        .body(containsString("Hello"));
  }
}
