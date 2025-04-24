package ir.digixo.dao;

import ir.digixo.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void delete(Long id);
}
