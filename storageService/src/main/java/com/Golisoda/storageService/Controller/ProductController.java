package com.Golisoda.storageService.Controller;

import com.Golisoda.storageService.Dto.ProductDto;
import com.Golisoda.storageService.Entity.RestResponse;
import com.Golisoda.storageService.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<RestResponse<Page<ProductDto>>> getAllProducts(Pageable page) {
    log.info("welcome");
    RestResponse<Page<ProductDto>> response = new RestResponse<>();
    response.setData(productService.getAllProducts(page));
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<RestResponse<ProductDto>> addProduct(@RequestBody ProductDto productDto) {
    log.info("Adding product {}",productDto);
    RestResponse<ProductDto> response = new RestResponse<>();
    response.setData(productService.addProduct(productDto));
    return ResponseEntity.ok(response);
  }

}
