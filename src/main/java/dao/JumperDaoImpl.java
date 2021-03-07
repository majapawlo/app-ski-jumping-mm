package dao;

import model.Country;
import model.Jumper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JumperDaoImpl implements JumperDao {

    private final EntityManagerFactory factory;

    public JumperDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Jumper jumper) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(jumper);
        jumper.getCountry().addJumper(jumper);
        jumper.getTeam().addJumper(jumper);

        transaction.commit();
        entityManager.close();

    }

    @Override
    public boolean isJumperPresent(Jumper jumper) {
        if (jumper.getId() == null){
            return false;
        }
        return find(jumper.getId()) != null;
    }

    @Override
    public void edit(Jumper jumper, Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(jumper);
//        Jumper jumperToEdit = find(id);
//        jumperToEdit.setFirstName(jumper.getFirstName());
//        jumperToEdit.setLastName(jumper.getLastName());
//        jumperToEdit.setDateOfBirth(jumper.getDateOfBirth());
//        jumperToEdit.setWeight(jumper.getWeight());
//        jumperToEdit.setTeam(jumper.getTeam());
//        jumperToEdit.setCountry(jumper.getCountry());
//        jumperToEdit.setWinsOfWorldCup(jumper.getWinsOfWorldCup());
//        jumperToEdit.setActive(jumper.isActive());

        transaction.commit();
        entityManager.close();
    }

    @Override
    public Jumper find(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Jumper jumper = entityManager.find(Jumper.class, id);

        transaction.commit();
        entityManager.close();

        return jumper;
    }


}
