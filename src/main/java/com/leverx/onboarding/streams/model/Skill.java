package com.leverx.onboarding.streams.model;

import lombok.*;

import java.util.*;

@Setter
@Getter
public class Skill {

    private String name;
    private long knownPercentage;

    public Skill(String name, long knownPercentage) {
        this.name = name;
        this.knownPercentage = knownPercentage;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", knownPercentage=" + knownPercentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return knownPercentage == skill.knownPercentage && Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, knownPercentage);
    }
}
