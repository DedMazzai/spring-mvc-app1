package ru.davydenko.springcourse.dao;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.davydenko.springcourse.models.Person;

import java.util.HashSet;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);

//        Set<Person> people = new HashSet<Person>(session.createQuery(
//                "SELECT p FROM Person p LEFT JOIN FETCH p.items", Person.class).getResultList());
//
//        for (Person person : people){
//            person.getItems();
    }
}


