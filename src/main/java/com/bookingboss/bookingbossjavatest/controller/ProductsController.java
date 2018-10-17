package com.bookingboss.bookingbossjavatest.controller;

import com.bookingboss.bookingbossjavatest.entities.ProductVO;
import com.bookingboss.bookingbossjavatest.models.Product;
import com.bookingboss.bookingbossjavatest.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Product Controller
 */
@RestController
@RequestMapping(path = "/products")
@Api(value = "Products", tags = {"Products"})
@Validated
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @ApiOperation(value = "Get a product details")
    @RequestMapping(path = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getOne(@PathVariable @Min(1) long productId) {
        Product product;
        product = productService.getProductById(productId);
        return ResponseEntity.ok().body(product);
    }

    @ApiOperation(value = "Post list of product value objects to insert")
    @RequestMapping(path = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> post(@RequestBody List<ProductVO> vos) {
        List<Product> products = productService.bulkInsert(vos);
        return ResponseEntity.ok().body(products);
    }

    @ApiOperation(value = "Update a product")
    @RequestMapping(path = "/{productId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> put(@PathVariable @Min(1) long productId,@Valid @RequestBody ProductVO valueObject) {
        Product product = productService.update(productId, valueObject);
        return ResponseEntity.ok().body(product);
    }


}
