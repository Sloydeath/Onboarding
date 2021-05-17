package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Student;
import com.leverx.onboarding.streams.model.enums.Subject;

import java.util.List;

public interface StudentService {
    void printAvgRatingBySubject(List<Student> student, Subject subject);
}
