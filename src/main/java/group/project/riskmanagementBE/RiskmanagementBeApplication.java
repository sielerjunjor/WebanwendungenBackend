package group.project.riskmanagementBE;

import group.project.riskmanagementBE.model.Project;
import group.project.riskmanagementBE.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class RiskmanagementBeApplication {

	@Autowired
	private ProjectRepository projectRepository;

	@RequestMapping("/")
	String home(){




		projectRepository.deleteAll();
		projectRepository.save(new Project("test"));
		return "go to <a href=\"/projects\"> Projects </a> to see all initialized projects" + "</br>";
	}
	public static void main(String[] args) {

		String mongoLogin = System.getenv("MONGO_LOGIN");
		System.setProperty("spring.data.mongodb.uri",mongoLogin);
		SpringApplication.run(RiskmanagementBeApplication.class, args);

	}
}
