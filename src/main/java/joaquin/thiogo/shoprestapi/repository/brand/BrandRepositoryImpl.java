package joaquin.thiogo.shoprestapi.repository.brand;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.util.JpaUtil;

import java.util.List;

public class BrandRepositoryImpl implements BrandRepository{

    @Override
    public void save(Brand brand) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            brand.setName(brand.getName());
            entityManager.persist(brand);

            entityTransaction.commit();
        }
    }

    @Override
    public List<Brand> findAll() {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            TypedQuery<Brand> query = entityManager.createQuery("select b from Brand b", Brand.class);
            List<Brand> resultList = query.getResultList();

            entityTransaction.commit();

            return resultList;
        }
    }

    @Override
    public Brand findById(Integer id) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {

            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Brand brand = entityManager.find(Brand.class, id);
            if (brand != null) {
                return brand;
            }

            entityTransaction.commit();
        }
        return null;
    }

    @Override
    public void update(Brand brand, Integer id) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Brand result = entityManager.find(Brand.class, id);

            if (result != null) {
                result.setName(brand.getName());
                entityManager.merge(result);
            }

            entityTransaction.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try (EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Brand result = entityManager.find(Brand.class, id);

            if (result != null) {
                entityManager.remove(result);
            }

            entityTransaction.commit();
        }
    }
}
