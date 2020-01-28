package com.exo.soap;

import com.exo.soap.config.HibernateInitializerConfig;
import com.exo.soap.service.PersonneService;
import lombok.extern.java.Log;

import javax.xml.ws.Endpoint;

@Log
public class EndPointPublisher {
    public static void main(String[] args) {
        try {
            HibernateInitializerConfig config = new HibernateInitializerConfig();
            config.initDatabase();
            String url = "http://localhost:8999/";
            Endpoint.publish(url, new PersonneService());
            log.info("Tous les objets distants ont été enregistré");
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
        }
    }
}
