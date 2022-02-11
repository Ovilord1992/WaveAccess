package ru.example.Conference.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "schedule")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "talk_id")
    private Talk talk;
    private Date startTime;
    private Date endTime;

    public Schedule(Room room, Talk talk, Date startTime, Date endTime) {
        this.room = room;
        this.talk = talk;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
