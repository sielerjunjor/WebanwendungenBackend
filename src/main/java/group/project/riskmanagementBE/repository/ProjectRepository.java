package group.project.riskmanagementBE.repository;

import group.project.riskmanagementBE.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProjectRepository extends MongoRepository<Project, String> {

    public Project findByProjectName(String projectName);
    public Project findByUid(String uid);

}