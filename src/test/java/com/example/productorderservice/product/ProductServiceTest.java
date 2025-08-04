package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @InjectMocks
  private ProductService productService;

  @Mock
  private ProductPort productPort;

  @Test
  void 상품수정() {

    final Long productId = 1L;
    final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
    final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

    // given
    when(productPort.getProduct(anyLong())).thenReturn(product);

    // when
    productService.updateProduct(productId, request);

    // then
    assertThat(product.getName()).isEqualTo(request.name());
    assertThat(product.getPrice()).isEqualTo(request.price());
    assertThat(product.getDiscountPolicy()).isEqualTo(request.discountPolicy());

  }

}
