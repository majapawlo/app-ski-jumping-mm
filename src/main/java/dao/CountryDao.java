package dao;

import model.Country;

public interface CountryDao {

    void save(Country country);
    boolean isCountryPresent(Country country);
}
