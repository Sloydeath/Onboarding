package com.leverx.onboarding.streams.model;

import com.leverx.onboarding.streams.model.enums.TaskType;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private String id;
    private String title;
    private TaskType type;
    private LocalDate createdOn;
    private boolean done = false;
    private Set<String> tags = new HashSet<>();
    private LocalDate dueTo;

    public Task(String title, TaskType type, LocalDate createdOn) {
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    public Task addTag(String name) {
        tags.add(name);
        return this;
    }
}
