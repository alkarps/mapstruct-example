package ru.alkarps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.alkarps.model.annotation.Default;

import java.util.List;

@Data
@AllArgsConstructor
public class ArmyDto {
    String name;
    List<UnitDto> soldiers;
    UnitDto head;

    @Default
    public ArmyDto(String name) {
    }
}
