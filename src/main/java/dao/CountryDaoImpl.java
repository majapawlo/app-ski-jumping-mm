package dao;

import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CountryDaoImpl implements CountryDao{

    private final EntityManagerFactory factory;

    public CountryDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Country country) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(country);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public boolean isCountryPresent(Country country) {
        return false;
    }

    @Override
    public Country find(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Country country = entityManager.find(Country.class, id);

        transaction.commit();
        entityManager.close();

        return country;
    }
}
