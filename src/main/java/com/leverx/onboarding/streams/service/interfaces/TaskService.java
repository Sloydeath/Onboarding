package com.leverx.onboarding.streams.service.interfaces;

import com.leverx.onboarding.streams.model.Task;

import java.util.List;

public interface TaskService {
    void getTasks(List<Task> tasks);
    void printGroupByTitle(List<Task> tasks);
    void printGroupByDone(List<Task> tasks);
    void printGroupByCreatedOn(List<Task> tasks);
    void printGroupByTags(List<Task> tasks);
}
