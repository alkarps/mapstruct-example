package ru.alkarps.mapper;

import org.mapstruct.*;
import ru.alkarps.model.dto.ArmyDto;
import ru.alkarps.model.entity.ArmyEntity;
import ru.alkarps.model.entity.UnitEntity;

import java.util.UUID;

@Mapper(
        uses = {UnitEntityMapper.class, AmyEntityFactory.class},
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        imports = {UUID.class},
        componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ArmyEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "units", source = "soldiers")
    @Mapping(target = "head", ignore = true)
    ArmyEntity map(ArmyDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "units", ignore = true)
    @Mapping(target = "head", source = "id")
    void update(@MappingTarget ArmyEntity army, UnitEntity head);
}
