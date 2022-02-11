package ru.example.Conference;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import ru.example.Conference.entity.ERole;
import ru.example.Conference.entity.Roles;
import ru.example.Conference.entity.Room;
import ru.example.Conference.entity.UserEntity;
import ru.example.Conference.repo.RoleRepository;
import ru.example.Conference.repo.RoomRepository;
import ru.example.Conference.repo.UserRepository;

import javax.annotation.PostConstruct;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class ConferenceApplication {

	private final RoomRepository roomRepository;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@PostConstruct
	private void addRoles(){
		roleRepository.saveAll(
				List.of(
						new Roles(ERole.ROLE_ADMIN),
						new Roles(ERole.ROLE_SPEAKER),
						new Roles(ERole.ROLE_LISTENER)
				)
		);
	}

	@PostConstruct
	private void createRooms(){
		roomRepository.saveAll(
				List.of(new Room("123"),
						new Room("321"),
						new Room("1A"),
						new Room("5Z"),
						new Room("65"),
						new Room("7G"))
		);
	}


	@PostConstruct
	private void createUserAdmin(){
		Set<Roles> roles = new HashSet<>();
		Roles adminRole = roleRepository
				.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error, Role ADMIN is not found"));
		roles.add(adminRole);
		userRepository.save(
				new UserEntity(
						"user",
						passwordEncoder.encode("password"),
						"email@email.ru",
						roles
				)
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}

}
