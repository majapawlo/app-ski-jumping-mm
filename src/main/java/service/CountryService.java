package service;

import dao.CountryDao;
import lombok.AllArgsConstructor;
import model.Country;

@AllArgsConstructor
public class CountryService {

    private final CountryDao countryDao;

    public void saveCountry(Country country){
        if (countryDao.isCountryPresent(country)){
            System.out.println("Country already present");
        } else {
            countryDao.save(country);
        }
    }

    public Country findCountry(Long id) {
        if (countryDao.find(id) != null) {
            return countryDao.find(id);
        }
        return new Country();
    }

}
