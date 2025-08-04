package com.example.productorderservice.product;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import static com.example.productorderservice.product.ProductSteps.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductApiTest extends ProductSteps{

  @Autowired
  ProductRepository productRepository;

  @Test
  void 상풍등록() {

    final var request = 상품등록요청_생성();

    final var response = 상품등록요청(request);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());

  }

  @Test
  void 상품조회() {

    상품등록요청(상품등록요청_생성());
    Long productId = 1L;

    final var response = 상품조회요청(productId);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");

  }

  @Test
  void 상품수정() {

    상품등록요청(상품등록요청_생성());
    final Long productId = 1L;

    final var response = ProductSteps.상품수정요청(productId);

    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");

  }




}
