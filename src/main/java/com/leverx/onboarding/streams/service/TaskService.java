package com.leverx.onboarding.streams.service;

import com.leverx.onboarding.streams.model.Task;

import java.util.List;

public interface TaskService {
    void printTasks(List<Task> tasks);
    void printGroupByTitle(List<Task> tasks);
    void printGroupByDone(List<Task> tasks);
    void printGroupByCreatedOn(List<Task> tasks);
    void printGroupByTags(List<Task> tasks);
}
