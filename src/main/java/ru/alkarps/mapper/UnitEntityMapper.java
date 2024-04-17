package ru.alkarps.mapper;

import org.mapstruct.*;
import ru.alkarps.model.annotation.OffsetDateTimeDefault;
import ru.alkarps.model.dto.UnitDto;
import ru.alkarps.model.entity.UnitEntity;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

@Mapper(
        uses = {OffsetDateMapper.class},
        imports = {UUID.class, OffsetDateTime.class},
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface UnitEntityMapper {
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "age", source = "age", defaultValue = "18")
    UnitEntity map(UnitDto dto);

    @InheritConfiguration
    void update(UnitDto dto, @MappingTarget UnitEntity unitEntity);

    @Mapping(target = "updateDate", source = "updateDate")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "createDate", source = "createDate",
            qualifiedBy = {OffsetDateTimeDefault.class},
            conditionExpression = "java(map.containsKey(\"createDate\"))",
            defaultExpression = "java(OffsetDateTime.now())"
    )
    @Mapping(target = "age", source = "age")
    UnitEntity map(Map<String, String> map);
}
