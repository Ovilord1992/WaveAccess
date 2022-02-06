package ru.example.Conference.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "talk")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "talk_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "talk_id")
    )
    private Set<UserEntity> users;

    @OneToOne(mappedBy = "talk")
    private Schedule schedule;

}
