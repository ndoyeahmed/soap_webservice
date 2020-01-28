package com.exo.soap.dao.implementation;

import com.exo.soap.config.HibernateInitializerConfig;
import com.exo.soap.dao.interfaces.IPersonne;
import com.exo.soap.entities.Personne;
import lombok.extern.java.Log;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mouhamed NDOYE
 * @since 23/01/2020
 */
@Log
public class PersonneImp implements IPersonne {

    private Session session = HibernateInitializerConfig.getSession();

    @Override
    public boolean save(Personne personne) {
        try {
            session.beginTransaction();
            session.save(personne);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.severe(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean update(Long id, Personne personne) {
        try {
            Personne p = getPersonneById(id);
            if (p != null) {
                p.setNom(personne.getNom());
                p.setPrenom(personne.getPrenom());
                p.setAdresse(personne.getAdresse());
                p.setTelephone(personne.getTelephone());
                session.beginTransaction();
                session.update(p);
                session.getTransaction().commit();
                return true;
            } else return false;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    @Override
    public boolean delete(Long id) {
        try {
            Personne p = getPersonneById(id);
            if (p != null) {
                session.beginTransaction();
                session.delete(p);
                session.getTransaction().commit();
                return true;
            } else return false;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    @Override
    public List<Personne> findAll() {
        try {
            return session.createQuery("select p from Personne p", Personne.class).getResultList();
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Personne getPersonneById(Long id) {
        try {
            return session.createQuery("select p from Personne p where p.id=:id", Personne.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            return null;
        }
    }
}
