package com.example.productorderservice.product;


import com.example.productorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.example.productorderservice.product.ProductSteps.상품등록요청_생성;
import static com.example.productorderservice.product.ProductSteps.상풍등록요청;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

  @Test
  void 상풍등록() {

    final var request = 상품등록요청_생성();

    // API 요청
    final var response = 상풍등록요청(request);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

  }

  @Test
  void 상품조회() {
      ProductSteps.상풍등록요청(ProductSteps.상품등록요청_생성());

      Long productId = 1L;

      final ExtractableResponse<Response> response = RestAssured.given().log().all()
              .when()
              .get("/products/{productId}", productId)
              .then().log().all()
              .extract();


      assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
      assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");

  }





}
