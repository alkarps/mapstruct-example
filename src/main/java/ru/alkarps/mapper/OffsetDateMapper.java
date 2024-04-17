package ru.alkarps.mapper;

import org.springframework.stereotype.Component;
import ru.alkarps.model.annotation.OffsetDateTimeCustom;
import ru.alkarps.model.annotation.OffsetDateTimeDefault;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class OffsetDateMapper {
    @OffsetDateTimeDefault
    public OffsetDateTime parse(String date) {
        return OffsetDateTime.parse(date);
    }

    @OffsetDateTimeDefault
    public String format(OffsetDateTime date) {
        return date.toString();
    }

    @OffsetDateTimeCustom
    public OffsetDateTime parseCustom(String date) {
        return OffsetDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME);
    }

    @OffsetDateTimeCustom
    public String formatCustom(OffsetDateTime date) {
        return DateTimeFormatter.ISO_DATE_TIME.format(date);
    }

    public OffsetDateTime now(){
        return OffsetDateTime.now();
    }
}
