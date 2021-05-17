package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Student;
import com.leverx.onboarding.streams.model.enums.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public void printAvgRatingBySubject(List<Student> students, Subject subject) {
        OptionalDouble averageRating = students.stream().mapToInt(s -> s.getRating().get(subject)).average();
        if (averageRating.isPresent()) {
            System.out.printf("%s average rating is %.2f", subject, averageRating.getAsDouble());
        }
    }

    @Override
    public void printRatingReport(List<Student> students) {
        List<Subject> subjects = Arrays.asList(Subject.values());

        System.out.println(subjects.stream()
                .map(subject -> subject + ": (" +
                        students.stream()
                            .map(student -> student.getName() + ": " + student.getRating().get(subject))
                            .collect(Collectors.joining(", ")) +
                        ")")
                .collect(Collectors.joining("\n")));
    }
}
