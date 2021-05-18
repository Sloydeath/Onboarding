package com.leverx.onboarding.streams;

import com.leverx.onboarding.streams.model.Student;
import com.leverx.onboarding.streams.model.Task;
import com.leverx.onboarding.streams.model.enums.Subject;
import com.leverx.onboarding.streams.model.enums.TaskType;
import com.leverx.onboarding.streams.service.StudentService;
import com.leverx.onboarding.streams.service.StudentServiceImpl;
import com.leverx.onboarding.streams.service.TaskService;
import com.leverx.onboarding.streams.service.TaskServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leverx.onboarding.streams.mapper.TaskMapper.*;

public class Launcher {

    private static final List<Student> students = new ArrayList<>();
    private static final List<Task> tasks;

    static {
        students.add(new Student("Andrew").rate(Subject.MATH, 8).rate(Subject.CHEMISTRY, 10).rate(Subject.ENGLISH, 5));
        students.add(new Student("Danila").rate(Subject.MATH, 5).rate(Subject.ENGLISH, 9));
        students.add(new Student("Artyom").rate(Subject.MATH, 3).rate(Subject.CHEMISTRY, 5).rate(Subject.ENGLISH, 4));
        students.add(new Student("Pasha").rate(Subject.CHEMISTRY, 10).rate(Subject.ENGLISH, 10));
        students.add(new Student("Zhenya").rate(Subject.MATH, 6).rate(Subject.CHEMISTRY, 1).rate(Subject.ENGLISH, 6));

        Task task1 = new Task("Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");
        Task task2 = new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");
        Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");
        Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");
        Task task5 = new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JUNE, 5)).addTag("ddd").addTag("books").addTag("reading");
        tasks = Arrays.asList(task1, task2, task3, task4, task5);
    }

    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        TaskService taskService = new TaskServiceImpl();

        studentService.getAverageRatingBySubject(students, Subject.MATH);
        System.out.println("\n");
        taskService.getTasks(tasks);
        System.out.println("\n");
        convertTasksToTaskDto(tasks).forEach(System.out::println);
        System.out.println("\n");
        studentService.getRatingReport(students);
        System.out.println("\n");
        taskService.printGroupByTitle(tasks);
        System.out.println("\n");
        taskService.printGroupByDone(tasks);
        System.out.println("\n");
        taskService.printGroupByTags(tasks);
        System.out.println("\n");
        taskService.printGroupByCreatedOn(tasks);
    }
}
