package com.leverx.onboarding.streams.util;

import com.leverx.onboarding.streams.dto.TaskDto;
import com.leverx.onboarding.streams.model.Task;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Convert {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static List<TaskDto> convertTasksToTaskDto(List<Task> tasks) {
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }
}
