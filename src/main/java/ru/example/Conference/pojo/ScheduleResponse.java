package ru.example.Conference.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private Long id;
    private Long room;
    private Long talk;
//    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
//    private Date year;
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date startTime;
//    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
//    private Date endTime;
}
