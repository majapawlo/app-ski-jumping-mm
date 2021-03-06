package service;

import dao.JumperDao;
import lombok.AllArgsConstructor;
import model.Jumper;

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



}
