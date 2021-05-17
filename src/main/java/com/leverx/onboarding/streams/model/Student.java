package com.leverx.onboarding.streams.model;

import com.leverx.onboarding.streams.model.enums.Subject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@ToString
public class Student {
    private Map<Subject, Integer> rating;
    private String name;

    public Student(String name){
        rating = new HashMap<>();
        this.name = name;
    }

    public Student rate(Subject subject, Integer rate){
        rating.put(subject, rate);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rating, student.rating) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, name);
    }
}
