package ru.alkarps.model.entity;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ArmyEntity {
    UUID id;
    String name;
    List<UnitEntity> units;
    UUID head;
}
