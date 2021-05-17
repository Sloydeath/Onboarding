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
}
