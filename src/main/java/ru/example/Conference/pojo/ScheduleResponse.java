package ru.example.Conference.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private Long room;
    private Long talk;
    private String conferenceDay;
}
