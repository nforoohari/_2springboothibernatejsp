package ir.digixo.service;

import ir.digixo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void delete(Long id);
}
