package vn.fis.training.ordermanagement.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.training.ordermanagement.model.Product;
import vn.fis.training.ordermanagement.repository.ProductRepository;
import vn.fis.training.ordermanagement.service.ProductService;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product findById(Long productId) {
        Product product = productRepository.findById(productId).get();

        log.info("Product with id {} : {}", productId, product);
        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
