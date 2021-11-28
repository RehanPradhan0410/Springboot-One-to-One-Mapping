package net.javatut.springboot;

import net.javatut.springboot.entity.Gender;
import net.javatut.springboot.entity.User;
import net.javatut.springboot.entity.UserProfile;
import net.javatut.springboot.repository.UserProfileRepository;
import net.javatut.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringbootHibernateOneOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOneOneMappingApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void run(String... args) throws Exception {

		//user object

		User user = new User();
		user.setName("Ryan");
		user.setEmail("ryan@gmail.com");

		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Maharajgunj");
		userProfile.setDateOfbirth(LocalDate.of(2001, 10, 04));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("999999999");

		user.setUserProfile(userProfile);

		userProfile.setUser(user);

		userRepository.save(user);
	}
}
