package ru.example.Conference.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.Conference.dto.TalkDTO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {
    private Long id;
    private TalkDTO talk;
    private Date startTime;
    private Date endTime;
}
