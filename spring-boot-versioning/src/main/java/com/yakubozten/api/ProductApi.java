package com.yakubozten.api;


import com.yakubozten.dto.ProductV1;
import com.yakubozten.dto.ProductV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {

    //Uri Versioning

    //http://localhost:8080/api/v1/product
    @GetMapping(value = "/v1/product")
    public ResponseEntity<ProductV1> pathVersioningProductV1(){
         return ResponseEntity.of(Optional.of(new ProductV1("Hp Laptop")));
    }
    //http://localhost:8080/api/v2/product
    @GetMapping(value = "/v2/product")
    public ResponseEntity<ProductV2> pathVersioningProductV2(){
        return ResponseEntity.of(Optional.of(new ProductV2("Hp Laptop", BigDecimal.TEN)));
    }


    //Param Versioning

    //http://localhost:8080/api/param/product?
    @GetMapping(value = "/param/product",params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersioningProductV1(){
        return ResponseEntity.of(Optional.of(new ProductV1("Hp Laptop")));
    }
    //http://localhost:8080/api/param/product?
    @GetMapping(value = "/param/product",params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersioningProductV2(){
        return ResponseEntity.of(Optional.of(new ProductV2("Hp Laptop", BigDecimal.TEN)));
    }

    //Header Versioning

    //http://localhost:8080/api/header/product?
    @GetMapping(value = "/header/product",headers = "X-API-VERSİON=1")
    public ResponseEntity<ProductV1> headerVersioningProductV1(){
        return ResponseEntity.of(Optional.of(new ProductV1("Hp Laptop")));
    }
    //http://localhost:8080/api/header/product?
    @GetMapping(value = "/header/product",headers = "X-API-VERSİON=2")
    public ResponseEntity<ProductV2> headerVersioningProductV2(){
        return ResponseEntity.of(Optional.of(new ProductV2("Hp Laptop", BigDecimal.TEN)));
    }
}
