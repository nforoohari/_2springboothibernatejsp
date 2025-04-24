package ir.digixo.dao;

import ir.digixo.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoHibernate implements ProductDao {

    private final EntityManager entityManager;

    public ProductDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {
        return entityManager
                .createQuery("from product order by price desc ")
                .getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void delete(Long id) {
        entityManager
                .createQuery("delete from product where id=:productId")
                .setParameter("productId", id)
                .executeUpdate();
    }
}
