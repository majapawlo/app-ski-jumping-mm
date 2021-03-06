package dao;

import model.Jumper;

public interface JumperDao {

    void save(Jumper jumper);
    boolean isJumperPresent(Jumper jumper);


}
