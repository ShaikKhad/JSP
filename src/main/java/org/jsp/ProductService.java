package org.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

@Autowired
private static ProductRepository productRepository;

public static Page<Product> findAll(Pageable pageable) {
return productRepository.findAll(pageable);
}

public Product findById(Integer id) {
return productRepository.findById(id).orElse(null);
}

public Product save(Product product) {
return productRepository.save(product);
}

public void deleteById(Integer id) {
productRepository.deleteById(id);
}
}
