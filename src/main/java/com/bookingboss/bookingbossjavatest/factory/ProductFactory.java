package com.bookingboss.bookingbossjavatest.factory;

import com.bookingboss.bookingbossjavatest.entities.ProductVO;
import com.bookingboss.bookingbossjavatest.models.Product;

/**
 * Product factory bean
 */
public abstract class ProductFactory {

    public static Product getProduct(){
        return new Product();
    }

    public static Product getProduct(ProductVO productVO){
        Product product = getProduct();
        product.setName(productVO.getName());
        product.setQuantity(productVO.getQuantity());
        product.setSaleAmount(productVO.getSaleAmount());

        return product;
    }


}
