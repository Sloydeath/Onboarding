package com.leverx.onboarding.streams;

import com.leverx.onboarding.streams.model.Person;
import com.leverx.onboarding.streams.model.Skill;
import com.leverx.onboarding.streams.model.Student;
import com.leverx.onboarding.streams.model.Task;
import com.leverx.onboarding.streams.service.PersonServiceImpl;
import com.leverx.onboarding.streams.service.StringServiceImpl;
import com.leverx.onboarding.streams.service.StudentServiceImpl;
import com.leverx.onboarding.streams.service.TaskServiceImpl;
import com.leverx.onboarding.streams.service.interfaces.PersonService;
import com.leverx.onboarding.streams.service.interfaces.StringService;
import com.leverx.onboarding.streams.service.interfaces.StudentService;
import com.leverx.onboarding.streams.service.interfaces.TaskService;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leverx.onboarding.streams.mapper.TaskMapper.*;
import static com.leverx.onboarding.streams.model.enums.Subject.*;
import static com.leverx.onboarding.streams.model.enums.TaskType.*;

public class Launcher {

    private static final List<Student> students = new ArrayList<>();
    private static final List<Person> persons = new ArrayList<>();
    private static final List<Task> tasks;

    static {
        students.add(new Student("Andrew").rate(MATH, 8).rate(CHEMISTRY, 10).rate(ENGLISH, 5));
        students.add(new Student("Danila").rate(MATH, 5).rate(ENGLISH, 9));
        students.add(new Student("Artyom").rate(MATH, 3).rate(CHEMISTRY, 5).rate(ENGLISH, 4));
        students.add(new Student("Pasha").rate(CHEMISTRY, 10).rate(ENGLISH, 10));
        students.add(new Student("Zhenya").rate(MATH, 6).rate(CHEMISTRY, 1).rate(ENGLISH, 6));

        Task task1 = new Task("Read Version Control with Git book", READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");
        Task task2 = new Task("Read Java 8 Lambdas book", READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");
        Task task3 = new Task("Write a mobile application to store my tasks", CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");
        Task task4 = new Task("Write a blog on Java 8 Streams", WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");
        Task task5 = new Task("Read Domain Driven Design book", READING, LocalDate.of(2015, Month.JUNE, 5)).addTag("ddd").addTag("books").addTag("reading");
        tasks = Arrays.asList(task1, task2, task3, task4, task5);

        persons.add(new Person(1L, "Lokesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 10)));

        persons.add(new Person(2L, "Mahesh", new Skill("English", 10),
                new Skill("Kannada", 30), new Skill("Hindi", 50)));

        persons.add(new Person(3L, "Ganesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

        persons.add(new Person(4L, "Ramesh", new Skill("English", 10),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

        persons.add(new Person(5L, "Suresh", new Skill("English", 10),
                new Skill("Kannada", 40), new Skill("Hindi", 70)));

        persons.add(new Person(6L, "Gnanesh", new Skill("English", 100),
                new Skill("Kannada", 20), new Skill("Hindi", 40)));

    }

    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        TaskService taskService = new TaskServiceImpl();
        StringService stringService = new StringServiceImpl();

        studentService.getAverageRatingBySubject(students, MATH);
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
        System.out.println("\n");
        System.out.println(stringService.getMostCommonChar("Hello, world!"));
        System.out.println("\n");
        System.out.println(personService.findBestMatchingPerson(persons, new Skill("English", 50), new Skill("Kannada", 50),
                new Skill("Urdu", 50), new Skill("Hindi", 50)));
    }
}
