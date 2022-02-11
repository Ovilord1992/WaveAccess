package ru.example.Conference.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.Conference.entity.Room;
import ru.example.Conference.dto.RoomDTO;
import ru.example.Conference.entity.UserEntity;
import ru.example.Conference.pojo.ScheduleResponse;
import ru.example.Conference.repo.ScheduleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {
    final ScheduleService scheduleService;

    public static RoomDTO getRoomDTO(Room room){
        return new RoomDTO(
                room.getId(),
                room.getName(),
                room.getSchedule().stream().map(ScheduleService::modelMapScheduleDTO).collect(Collectors.toList())
        );
    }
}
