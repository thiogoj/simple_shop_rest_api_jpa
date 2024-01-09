package joaquin.thiogo.shoprestapi.repository.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.entity.Product;
import joaquin.thiogo.shoprestapi.util.JpaUtil;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    @Override
    public void save(Product product, Integer brandId) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            product.setName(product.getName());
            product.setDescription(product.getDescription());
            product.setPrice(product.getPrice());

            Brand brand = entityManager.find(Brand.class, brandId);
            product.setBrand(brand);
            entityManager.persist(product);

            entityTransaction.commit();
        }
    }

    @Override
    public List<Product> findAll() {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            TypedQuery<Product> query = entityManager.createQuery("select p from Product p join fetch p.brand b", Product.class);
            List<Product> resultList = query.getResultList();

            entityTransaction.commit();

            return resultList;
        }
    }

    @Override
    public Product findById(Integer productId) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            try {
                TypedQuery<Product> query = entityManager.createQuery("select p from Product p join fetch p.brand b where p.id = :id", Product.class);
                query.setParameter("id", productId);
                Product product = query.getSingleResult();

                entityTransaction.commit();

                return product;
            } catch (NoResultException e) {
                return null;
            }
        }
    }

    @Override
    public void update(Product product, Integer productId) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Product result = entityManager.find(Product.class, productId);

            if (result != null) {
                result.setName(product.getName());
                result.setDescription(product.getDescription());
                result.setPrice(product.getPrice());
                result.setBrand(product.getBrand());

                entityManager.merge(result);
            }

            entityTransaction.commit();
        }
    }

    @Override
    public void delete(Integer productId) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Product product = entityManager.find(Product.class, productId);

            if (product != null) {
                entityManager.remove(product);
            }

            entityTransaction.commit();
        }
    }
}
