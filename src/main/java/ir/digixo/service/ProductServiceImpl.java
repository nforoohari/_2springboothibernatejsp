package ir.digixo.service;

import ir.digixo.dao.ProductDao;
import ir.digixo.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productDao.delete(id);
    }
}
