package ru.davydenko.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.davydenko.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Konstantin", 45, "konstantin@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Yana", 40, "yana@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Polya", 18, "polya@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ratmir", 11, "ratmir@email.ru"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person toBeUpdated = show(id);

        toBeUpdated.setName(updatePerson.getName());
        toBeUpdated.setAge(updatePerson.getAge());
        toBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId()==id);
    }
}
