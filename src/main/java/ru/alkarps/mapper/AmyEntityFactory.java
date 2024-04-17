package ru.alkarps.mapper;

import ru.alkarps.model.entity.ArmyEntity;

import java.util.UUID;

public class AmyEntityFactory {
    public ArmyEntity create() {
        var army = new ArmyEntity();
        army.setId(UUID.randomUUID());
        return army;
    }
}
