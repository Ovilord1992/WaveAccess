package ru.example.Conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.example.Conference.dto.ScheduleDTO;
import ru.example.Conference.dto.RoomDTO;
import ru.example.Conference.service.ScheduleService;

import java.util.List;


@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;


    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_SPEAKER')")
    public void addNewSchedule(@RequestBody ScheduleDTO scheduleDTO) throws Exception {
        scheduleService.createSchedule(scheduleDTO);
    }

    @GetMapping("/registerInTalk")
    @PreAuthorize("hasRole('ROLE_LISTENER')")
    public void registerInTalk(@RequestParam Long id){
       scheduleService.registerInTalk(id);
    }

    @GetMapping("/getAllSchedules")
    public List<RoomDTO> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }
}
