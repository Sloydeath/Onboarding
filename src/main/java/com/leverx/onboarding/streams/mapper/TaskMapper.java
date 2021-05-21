package com.leverx.onboarding.streams.mapper;

import com.leverx.onboarding.streams.dto.TaskDto;
import com.leverx.onboarding.streams.model.Task;

import java.util.*;
import java.util.stream.*;

public class TaskMapper {
    public static List<TaskDto> convertTasksToTaskDto(List<Task> tasks){
        return tasks.stream()
                .map(task -> TaskDto.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .type(task.getType())
                        .createdOn(task.getCreatedOn())
                        .tags(task.getTags())
                        .build())
                .collect(Collectors.toList());
    }
}
