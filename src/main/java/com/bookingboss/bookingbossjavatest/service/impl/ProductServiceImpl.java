package com.bookingboss.bookingbossjavatest.service.impl;


import com.bookingboss.bookingbossjavatest.entities.ProductVO;
import com.bookingboss.bookingbossjavatest.factory.ProductFactory;
import com.bookingboss.bookingbossjavatest.models.Product;
import com.bookingboss.bookingbossjavatest.repository.ProductRepository;
import com.bookingboss.bookingbossjavatest.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productDao;

	
	@Autowired
	public ProductServiceImpl(ProductRepository productDao){
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		productDao.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product getProductById(Long productId) {
		Product product = productDao.findById(productId).orElse(null);
		return product;
	}


	@Override
	public Product update(long productId, ProductVO valueObject) {
		Product product = this.getProductById(productId);
		Product updatedProduct = ProductFactory.getProduct(valueObject);
		updatedProduct.setId(product.getId());
		product = productDao.save(updatedProduct);
		return product;
	}

   	@Override
	public List<Product> bulkInsert(List<ProductVO> vos) {
		List<Product> products = vos.stream().map(ProductFactory::getProduct).collect(Collectors.toList());
		List<Product> savedList = new ArrayList<>();
		productDao.saveAll(products).forEach(savedList::add);
		return savedList;
	}

	

}
