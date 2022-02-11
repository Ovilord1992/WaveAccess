package ru.example.Conference.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalkDTO {
    private Long id;
    private String name;
    private String about;
    private List<String> users;
}
