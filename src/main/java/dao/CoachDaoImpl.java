package dao;

import model.Coach;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CoachDaoImpl implements CoachDao{

    private EntityManagerFactory factory;

    public CoachDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Coach coach) {

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(coach);
        coach.getCountry().addCoach(coach);
        coach.getTeam().setCoach(coach);

        transaction.commit();
        entityManager.close();

    }
    @Override
    public boolean isCoachPresent(Coach coach){
        return false;
    }


}
