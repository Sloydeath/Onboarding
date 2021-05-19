package com.leverx.onboarding.streams.mapper;

import com.leverx.onboarding.streams.dto.TaskDto;
import com.leverx.onboarding.streams.model.Task;

import java.util.List;

import static java.util.stream.Collectors.*;


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
                .collect(toList());
    }
}
