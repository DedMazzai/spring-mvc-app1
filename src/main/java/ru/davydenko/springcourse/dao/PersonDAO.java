package ru.davydenko.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.davydenko.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(1, "Konstantin"));
        people.add(new Person(2, "Yana"));
        people.add(new Person(3, "Polya"));
        people.add(new Person(4, "Ratmir"));
    }
    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
