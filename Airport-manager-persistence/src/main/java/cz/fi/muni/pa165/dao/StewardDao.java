package cz.fi.muni.pa165.dao;


import cz.fi.muni.pa165.entities.Steward;

import java.util.List;

/**
 * Interface representing basic operations with entity.
 *
 * @author Ondřej Přikryl
 */
public interface StewardDao {

    /**
     * Method which adds steward to database.
     *
     * @param steward to be added.
     * @throws NullPointerException when steward is null
     * @throws IllegalArgumentException when steward's firstname or surname is null
     */
    void createSteward(Steward steward);

    /**
     * Method which removes steward from the database.
     *
     * @param steward to be removed.
     * @throws NullPointerException when steward is null
     */
    void deleteSteward(Steward steward);

    /**
     * This method updates stewards attributes.
     *
     * @param steward to be modified.
     * @throws NullPointerException when steward is null
     * @throws IllegalArgumentException when steward's firstname or surname is null, or steward is not in db
     */
    void updateSteward(Steward steward);

    /**
     * This methods returns steward from the database by his ID.
     *
     * @param id identifier of steward.
     * @throws IllegalArgumentException id is null
     * @return Instance of Steward if the id is in database, null otherwise.
     */
    Steward getSteward(Long id);

    /**
     * This method returns all stewards stored in the database.
     *
     * @return List of all stewards currently stored in database.
     */
    List<Steward> listAllStewards();
}
