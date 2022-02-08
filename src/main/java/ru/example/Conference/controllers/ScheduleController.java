package ru.example.Conference.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import ru.example.Conference.entity.Room;
import ru.example.Conference.entity.Schedule;
import ru.example.Conference.pojo.ScheduleResponse;
import ru.example.Conference.repo.RoomRepository;
import ru.example.Conference.repo.ScheduleRepository;
import ru.example.Conference.repo.TalkRepository;

import java.text.Format;
import java.time.LocalDateTime;


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
    public void addNew(@RequestBody ScheduleResponse scheduleResponse){
        Schedule s = new Schedule();
        s.setTalk(talkRepository.getById(scheduleResponse.getTalk()));
        s.setRoom(roomRepository.getById(scheduleResponse.getRoom()));
        s.setStartTime(scheduleResponse.getStartTime());
       scheduleRepository.save(s);
    }

}
