package ru.alkarps.model.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class UnitEntity {
    UUID id;
    String name;
    Integer age;
    OffsetDateTime createDate;
    LocalDateTime updateDate;
}
