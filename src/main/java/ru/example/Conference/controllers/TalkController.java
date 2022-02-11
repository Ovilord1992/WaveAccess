package ru.example.Conference.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.example.Conference.dto.TalkDTO;
import ru.example.Conference.entity.Talk;
import ru.example.Conference.repo.TalkRepository;
import ru.example.Conference.service.TalkService;

import java.util.List;

@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/api/talk")
public class TalkController {

    @Autowired
    private TalkService talkService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_SPEAKER')")
    public void createTalk(@RequestBody Talk talk){
        talkService.createTalk(talk);
    }

}
