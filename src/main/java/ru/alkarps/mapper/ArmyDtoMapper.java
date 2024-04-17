package ru.alkarps.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.alkarps.model.dto.ArmyDto;
import ru.alkarps.model.dto.UnitDto;
import ru.alkarps.model.entity.ArmyEntity;
import ru.alkarps.model.entity.UnitEntity;

import java.util.List;
import java.util.UUID;

@Mapper(uses = {UnitDtoMapper.class})
public abstract class ArmyDtoMapper {
    private final UnitDtoMapper mapper = Mappers.getMapper( UnitDtoMapper.class );

    @Mapping(target = "soldiers", expression = "java(map(entity.getUnits(), requestId))")
    @Mapping(target = "head", expression = "java(findUnitDto(entity.getUnits(), entity.getHead(), requestId))")
    public abstract ArmyDto map(ArmyEntity entity, String requestId);

    public List<UnitDto> map(List<UnitEntity> entities, String requestId) {
        if(entities == null || requestId == null){
            return null;
        }
        return entities.stream()
                .map(it -> mapper.toDto(it, requestId))
                .toList();
    }

    public UnitDto findUnitDto(List<UnitEntity> soldiers, UUID headId, String requestId) {
        if(soldiers == null || headId == null){
            return null;
        }
        return soldiers.stream().filter(it-> headId == it.getId()).findFirst()
                .map(it -> mapper.toDto(it, requestId))
                .orElse(null);
    }
}
