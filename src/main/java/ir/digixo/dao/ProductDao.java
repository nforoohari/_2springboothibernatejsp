package ir.digixo.dao;

import ir.digixo.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void delete(Long id);
}
