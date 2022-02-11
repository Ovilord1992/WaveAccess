package ru.example.Conference.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.example.Conference.dto.TalkDTO;
import ru.example.Conference.entity.Talk;
import ru.example.Conference.entity.UserEntity;
import ru.example.Conference.repo.TalkRepository;
import ru.example.Conference.repo.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TalkService {

    @Autowired
    private TalkRepository talkRepository;
    @Autowired
    private UserRepository userRepository;

    public static TalkDTO modelMapTalkDTO(Talk talk){
        List<String> users = talk.getUsers().stream()
                .map(UserEntity::getUsername)
                .collect(Collectors.toList());
        return new TalkDTO(
                talk.getId(),
                talk.getName(),
                talk.getAbout(),
                users
        );
    }

    public void createTalk(@RequestBody Talk talk){
        if (talk.getName() != null && talk.getAbout() != null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Set<UserEntity> users = new HashSet<>();
            users.add(userRepository.findByUsername(authentication.getName()).get());
            talk.setUsers(users);
            talkRepository.save(talk);
        }else throw new  RuntimeException("null data");
    }

}
