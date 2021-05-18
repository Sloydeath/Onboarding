package com.leverx.onboarding.streams.model;

import lombok.*;

import java.util.*;

@Setter
@Getter
public class Person {

    private Long personId;
    private String name;
    private List<Skill> skills;

    public Person(Long personId, String name, Skill... skills) {
        this.personId = personId;
        this.name = name;
        this.skills = Arrays.asList(skills);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId) && Objects.equals(name, person.name) && Objects.equals(skills, person.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, skills);
    }
}
