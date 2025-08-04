package com.example.productorderservice.product;

import org.springframework.util.Assert;

record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {

  UpdateProductRequest {
    Assert.hasText(name, "name must not be empty");
    Assert.isTrue(price > 0, "price must be greater than 0");
    Assert.notNull(discountPolicy, "discountPolicy must not be null");
  }

}
