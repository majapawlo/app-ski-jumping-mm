package service;

import dao.JumperDao;
import lombok.AllArgsConstructor;
import model.Country;
import model.Jumper;

import java.util.Optional;
import java.util.function.Consumer;

@AllArgsConstructor
public class JumperService {
    private final JumperDao jumperDao;

    public void saveJumper(Jumper jumper){
        if (jumperDao.isJumperPresent(jumper)){
            System.out.println("Jumper already present");
        } else {
            jumperDao.save(jumper);
        }
    }
    public void editJumper(Jumper jumper, Long id){
        if (jumperDao.isJumperPresent(jumper)){
            jumperDao.edit(jumper, id);
        } else {
            System.out.println("Jumper doesn't exists");
        }
    }
    public Jumper findJumper(Long id){
        if (jumperDao.find(id) != null) {
            return jumperDao.find(id);
        }
        return null;
    }





}
