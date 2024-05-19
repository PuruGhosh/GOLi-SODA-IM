package com.Golisoda.storageService.Service;

import com.Golisoda.storageService.Dto.ProductDto;
import com.Golisoda.storageService.Repository.ProductRepository;
import com.Golisoda.storageService.Util.ProductMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

@Slf4j
@Service
@Data
public class ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductMapper productMapper;

  public Page<ProductDto> getAllProducts(Pageable page) {
    log.info("Fetching all products.");
    var productPage = productRepository.findAll(page);
    var productdtolist =
        productPage.getContent().stream().map(productMapper::toProductDto).toList();
    return new PageImpl<>(
        productdtolist, productPage.getPageable(), productPage.getTotalElements());
  }

  public ProductDto addProduct(ProductDto productDto) {
    Assert.notNull(productDto,"Product dto is null");
    var productEntity = productMapper.toProduct(productDto);
    productEntity.setProductID(UUID.randomUUID().toString());
    return productMapper.toProductDto(productRepository.save(productEntity));
  }
}
