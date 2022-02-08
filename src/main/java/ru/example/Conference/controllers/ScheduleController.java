package ru.example.Conference.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.Conference.entity.Room;
import ru.example.Conference.entity.Schedule;
import ru.example.Conference.entity.Talk;
import ru.example.Conference.pojo.ScheduleResponse;
import ru.example.Conference.repo.RoomRepository;
import ru.example.Conference.repo.ScheduleRepository;
import ru.example.Conference.repo.TalkRepository;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    private  ScheduleRepository scheduleRepository;
    @Autowired
    private  RoomRepository roomRepository;
    @Autowired
    private  TalkRepository talkRepository;

    @PostMapping("/add")
    public Schedule addNew(@RequestBody ScheduleResponse scheduleResponse){
        Schedule schedule = new Schedule();
        schedule.setRoom(roomRepository.getById(scheduleResponse.getRoom()));
        schedule.setTalk(talkRepository.getById(scheduleResponse.getTalk()));
        schedule.setConferenceDay(scheduleResponse.getConferenceDay());
        return scheduleRepository.save(schedule);

    }

    @PostMapping("/get")
    public Room ggg(@RequestBody ScheduleResponse scheduleResponse){
        return roomRepository.getById(scheduleResponse.getRoom());
    }
}
