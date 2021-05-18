package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Student;
import com.leverx.onboarding.streams.model.enums.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import static java.util.stream.Collectors.*;

public class StudentServiceImpl implements StudentService {

    @Override
    public void getAverageRatingBySubject(List<Student> students, Subject subject) {
        OptionalDouble averageRating = students.stream()
                .filter(student -> student.getRating().containsKey(subject))
                .mapToInt(student -> student.getRating().get(subject))
                .average();
        if (averageRating.isPresent()) {
            System.out.printf("%s average rating is %.2f", subject, averageRating.getAsDouble());
        }
    }

    @Override
    public void getRatingReport(List<Student> students) {
        List<Subject> subjects = Arrays.asList(Subject.values());

        String ratingReport = subjects.stream()
                .map(subject -> subject + ": (" +
                        getStudentsWithRating(students, subject) +
                        ")")
                .collect(joining("\n"));
        printRatingReport(ratingReport);
    }

    private String getStudentsWithRating(List<Student> students, Subject subject) {
        return students.stream()
                .filter(student -> student.getRating().containsKey(subject))
                .map(student -> student.getName() + ": " + student.getRating().get(subject))
                .collect(joining(", "));
    }

    private void printRatingReport(String ratingReport) {
        System.out.println(ratingReport);
    }
}
