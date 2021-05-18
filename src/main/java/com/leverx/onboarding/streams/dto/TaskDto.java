package com.leverx.onboarding.streams.dto;

import com.leverx.onboarding.streams.model.enums.TaskType;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TaskDto {
    private String id;
    private String title;
    private TaskType type;
    private LocalDate createdOn;
    private Set<String> tags = new HashSet<>();
}
