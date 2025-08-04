package com.example.productorderservice.product;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
class ProductAdapter implements ProductPort {
  private final ProductRepository productRepository;

  public ProductAdapter(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void save(final Product product) {
    productRepository.save(product);
  }

  @Override
  public Product getProduct(Long productId) {

    return productRepository.findById(productId)
        .orElseThrow(() -> new IllegalArgumentException("Product not found"));
  }

}
