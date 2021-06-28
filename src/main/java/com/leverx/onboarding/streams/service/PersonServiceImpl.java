package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Person;
import com.leverx.onboarding.streams.model.Skill;
import com.leverx.onboarding.streams.service.interfaces.PersonService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PersonServiceImpl implements PersonService {

    @Override
    public String findBestMatchingPerson(List<Person> people, Skill ... skills) {
        return Arrays.stream(skills)
                .distinct()
                .map(skill -> skill.getName() + ": " + findAppropriatePersonBySkill(people, skill)
                )
                .collect(joining(", ", "[", "]"));
    }

    private Person findAppropriatePersonBySkill(List<Person> people, Skill skill) {
        Skill appropriateSkill = getPersonSkill(people, skill);
        Optional<Person> appropriatePerson = people.stream()
                .filter(person -> person.getSkills().contains(appropriateSkill))
                .findFirst();
        return appropriatePerson.orElse(null);
    }

    private Skill getPersonSkill(List<Person> people, Skill skill) {
        return  people.stream()
                .flatMap(person -> person.getSkills().stream())
                .filter(personSkill -> personSkill.getName().equals(skill.getName()))
                .filter(personSkill -> personSkill.getKnownPercentage() > skill.getKnownPercentage())
                .max(comparing(Skill::getKnownPercentage))
                .orElse(people.stream()
                        .flatMap(person -> person.getSkills().stream())
                        .filter(personSkill -> personSkill.getName().equals(skill.getName()))
                        .filter(personSkill -> personSkill.getKnownPercentage() <= skill.getKnownPercentage())
                        .max(comparing(Skill::getKnownPercentage))
                        .orElse(null));
    }


    private String anotherVariant(List<Person> persons, Skill ... skills) {
        StringBuilder report = new StringBuilder();
        List<Skill> skillsList = Arrays.stream(skills).distinct().collect(toList());

        report.append("[");
        for (Skill skill: skillsList) {
            Person bufferPerson = null;
            Skill bufferSkill = null;
            report.append(skill.getName()).append(": ");
            for (Person person: persons) {
                for (Skill personSkill: person.getSkills()) {
                    if (personSkill.getName().equals(skill.getName())) {
                        if (bufferPerson == null) {
                            bufferPerson = person;
                            bufferSkill = personSkill;
                        }
                        else if (personSkill.getKnownPercentage() > bufferSkill.getKnownPercentage()) {
                            bufferPerson = person;
                            bufferSkill = personSkill;
                        }
                    }
                }
            }
            if (bufferPerson != null) {
                report.append(bufferPerson.getName());
            }
            else {
                report.append("null");
            }
            report.append(", ");
        }
        report.delete(report.length() - 2, report.length());
        report.append("]");
        return report.toString();
    }
}