package ru.alkarps.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.alkarps.model.dto.UnitDto;
import ru.alkarps.model.entity.UnitEntity;

import java.util.UUID;

@Mapper(imports = {UUID.class})
public interface UnitDtoMapper {
    @Mapping(target = "army", constant = "NONE")
    @Mapping(target = "requestId", source = "requestId", defaultExpression = "java(UUID.randomUUID().toString())")
    UnitDto toDto(UnitEntity entity, String requestId);
}
