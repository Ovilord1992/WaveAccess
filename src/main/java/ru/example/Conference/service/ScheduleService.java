package ru.example.Conference.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.example.Conference.dto.RoomDTO;
import ru.example.Conference.dto.ScheduleDTO;
import ru.example.Conference.dto.UserDTO;
import ru.example.Conference.entity.*;
import ru.example.Conference.pojo.ScheduleResponse;
import ru.example.Conference.repo.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final RoomRepository roomRepository;

    private final ScheduleRepository scheduleRepository;

    private final TalkRepository talkRepository;

    private final UserRepository userRepository;


    public static ScheduleResponse modelMapScheduleDTO(Schedule schedule){
        return new ScheduleResponse(
                schedule.getId(),
                TalkService.modelMapTalkDTO(schedule.getTalk()),
                schedule.getStartTime(),
                schedule.getEndTime()
        );
    }


    public Schedule modelMapSchedule(ScheduleDTO schedule) {
        return new Schedule(
                roomRepository.getById(schedule.getRoom_id()),
                talkRepository.getById(schedule.getTalk_id()),
                schedule.getStartTime(),
                schedule.getEndTime()
        );
    }

    public void createSchedule(ScheduleDTO scheduleDTO) throws Exception {
        if (roomTimeChecker(scheduleDTO)){
            scheduleRepository.save(modelMapSchedule(scheduleDTO));
        }else {
            throw new Exception("this time for room denied");
        }
    }


    public void registerInTalk(Long id){
        Talk talk = talkRepository.getById(id);
        Set<UserEntity> user = talk.getUsers();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user.add(userRepository.findByUsername(authentication.getName()).get());
        talk.setUsers(user);
        talkRepository.save(talk);
    }

    private boolean roomTimeChecker(ScheduleDTO scheduleDTO){
        Room room = roomRepository.getById(scheduleDTO.getRoom_id());
        List<Schedule> schedules = room.getSchedule();
        List<Schedule> s = schedules
                .stream()
                .filter(v ->
                        (v.getStartTime().before(scheduleDTO.getEndTime()) && scheduleDTO.getStartTime().before(v.getEndTime()))).collect(Collectors.toList());
        return s.size() <= 0;
    }

    public List<RoomDTO> getAllSchedules(){
        return roomRepository.findAll()
                .stream().map(RoomService::getRoomDTO).collect(Collectors.toList());
    }
}
