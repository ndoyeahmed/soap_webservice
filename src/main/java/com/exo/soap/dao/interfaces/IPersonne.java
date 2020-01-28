package com.exo.soap.dao.interfaces;

import com.exo.soap.entities.Personne;

import java.util.List;

/**
 * @author Mouhamed NDOYE
 * @since 23/01/2020
 */
public interface IPersonne {

    /**
     * function prototype to save person
     *
     * @param personne the person object to save
     * @return boolean value
     */
    boolean save(Personne personne);

    /**
     * function prototype to update person information
     *
     * @param id       the person identity
     * @param personne new person information
     * @return boolean value
     */
    boolean update(Long id, Personne personne);

    /**
     * function prototype to delete a person
     *
     * @param id the person identity
     * @return boolean value
     */
    boolean delete(Long id);

    /**
     * function prototype to get all person register
     *
     * @return list of person
     */
    List<Personne> findAll();

    /**
     * function to get a person by his id
     *
     * @param id the person identity
     * @return a person object
     */
    Personne getPersonneById(Long id);
}
