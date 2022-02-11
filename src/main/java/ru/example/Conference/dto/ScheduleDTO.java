package ru.example.Conference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {
    private Long id;
    private Long room_id;
    private Long talk_id;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm Z")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm Z")
    private Date endTime;
}
