package com.exo.soap.service;

import com.exo.soap.dao.implementation.PersonneImp;
import com.exo.soap.dao.interfaces.IPersonne;
import com.exo.soap.entities.Personne;
import lombok.extern.java.Log;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * @author Mouhamed NDOYE
 * @since 23/01/2020
 * a web service class
 */
@Log
@WebService(serviceName = "PersonneServiceWS")
public class PersonneService {

    private IPersonne iPersonne = new PersonneImp();

    // web service method to add a person
    @WebMethod(operationName = "addPersonne")
    public boolean addPersonne(Personne personne) {
        return iPersonne.save(personne);
    }

    // web service method to update a person information
    @WebMethod(operationName = "updatePersonne")
    public boolean updatePersonne(Long id, Personne personne) {
        return iPersonne.update(id, personne);
    }

    // web service method to delete a person
    @WebMethod(operationName = "deletePersonne")
    public boolean deletePersonne(Long id) {
        return iPersonne.delete(id);
    }

    // web service method to get all person
    @WebMethod(operationName = "personneList")
    public List<Personne> personneList() {
        return iPersonne.findAll();
    }

    // web service method to get a person by his id
    @WebMethod(operationName = "getPersonneById")
    public Personne getPersonneById(Long id) {
        return iPersonne.getPersonneById(id);
    }
}
