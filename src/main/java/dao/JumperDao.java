package dao;

import model.Jumper;

import java.util.function.Consumer;

public interface JumperDao {

    void save(Jumper jumper);
    boolean isJumperPresent(Jumper jumper);
    void edit(Jumper jumper, Long id);
    Jumper find(Long id);


}
