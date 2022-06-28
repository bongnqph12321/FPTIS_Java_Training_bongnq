package vn.fis.training.ordermanagement.service;

import vn.fis.training.ordermanagement.model.Product;

public interface ProductService {
    Product findById(Long productId);
    Product update(Product product);
}
