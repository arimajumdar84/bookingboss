package com.bookingboss.bookingbossjavatest.service;

import com.bookingboss.bookingbossjavatest.entities.ProductVO;
import com.bookingboss.bookingbossjavatest.models.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Long productId);

    Product update(long productId, ProductVO valueObject);

    List<Product> bulkInsert(List<ProductVO> vos);

 
}
