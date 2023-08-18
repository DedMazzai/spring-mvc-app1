package ru.davydenko.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.davydenko.springcourse.models.Mood;
import ru.davydenko.springcourse.models.Person;
import ru.davydenko.springcourse.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findById(int id){
        var byId = peopleRepository.findById(id);
        return byId.orElse(null);
    }

    public void save(Person person){
        person.setCreatedAt(new Date());
        person.setMood(Mood.CALM);
        peopleRepository.save(person);
    }

    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    public void delete(int id){
        peopleRepository.deleteById(id);
    }

}
