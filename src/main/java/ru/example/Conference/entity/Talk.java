package ru.example.Conference.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "talk")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String about;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "talk_user",
            joinColumns = @JoinColumn(name = "talk_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserEntity> users;
    @OneToOne(mappedBy = "talk", fetch = FetchType.LAZY)
    private Schedule schedule;
}
