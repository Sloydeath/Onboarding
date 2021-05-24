package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Task;
import com.leverx.onboarding.streams.service.interfaces.*;

import java.util.List;

import static com.leverx.onboarding.streams.model.enums.TaskType.READING;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class TaskServiceImpl implements TaskService {
    @Override
    public void getTasks(List<Task> tasks) {
        String titles = tasks.stream()
                .filter(task -> READING.equals(task.getType()))
                .sorted(comparing(Task::getCreatedOn))
                .limit(5)
                .map(Task::getTitle)
                .collect(joining(", "));
        System.out.println(titles);
    }

    @Override
    public void printGroupByTitle(List<Task> tasks) {
        System.out.println(tasks.stream()
                .collect(groupingBy(Task::getTitle)));
    }

    @Override
    public void printGroupByDone(List<Task> tasks) {
        System.out.println(tasks.stream()
            .collect(groupingBy(Task::isDone)));
    }

    @Override
    public void printGroupByCreatedOn(List<Task> tasks) {
        System.out.println(tasks.stream()
                .collect(groupingBy(Task::getCreatedOn)));
    }

    @Override
    public void printGroupByTags(List<Task> tasks) {
        System.out.println(tasks.stream()
                .collect(groupingBy(Task::getTags)));
    }
}
