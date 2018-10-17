package com.bookingboss.bookingbossjavatest.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bookingboss.bookingbossjavatest.models.Product;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{

    @Query(value = "SELECT p.id FROM Product p")
    List<Long> getAllId();

    @Query(value = "SELECT p.id FROM Product p")
    List<Long> getAllId(Pageable pageable);
}
