package ru.example.Conference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.Conference.pojo.ScheduleResponse;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Long id;
    private String name;
    private List<ScheduleResponse> scheduleDTOS;
}
