package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Task;
import com.leverx.onboarding.streams.model.enums.TaskType;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    @Override
    public void printTasks(List<Task> tasks) {
        String titles = tasks.stream()
                .filter(task -> task.getType().equals(TaskType.READING))
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(5)
                .map(Task::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println(titles);
    }

    @Override
    public void printGroupByTitle(List<Task> tasks) {
        System.out.println(tasks.stream()
                .collect(Collectors.groupingBy(Task::getTitle)));
    }

    @Override
    public void printGroupByDone(List<Task> tasks) {
        System.out.println(tasks.stream()
            .collect(Collectors.groupingBy(Task::isDone)));
    }

    @Override
    public void printGroupByCreatedOn(List<Task> tasks) {
        System.out.println(tasks.stream()
                .collect(Collectors.groupingBy(Task::getCreatedOn)));
    }

    @Override
    public void printGroupByTags(List<Task> tasks) {
        System.out.println(tasks.stream()
                .collect(Collectors.groupingBy(Task::getTags)));
    }
}
