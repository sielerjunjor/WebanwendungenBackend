package group.project.riskmanagementBE.controller;

import group.project.riskmanagementBE.exception.ProjectNotFoundException;
import group.project.riskmanagementBE.model.Project;
import group.project.riskmanagementBE.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

   // String baseURL=System.getenv("BASEURL");
  //  String baseURLFE=System.getenv("BASEURL_FE");

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @PostMapping("")
    Project newProject(@RequestBody Project newProject) {
        Project projectWithId = new Project(newProject.getProjectName());
        return projectRepository.save(projectWithId);
    }

    @GetMapping("/{id}")
    Project one(@PathVariable String id) {

        try{
            Project project = projectRepository.findById(id)
                    .orElseThrow(() -> new ProjectNotFoundException(id));
            return project;}
        catch(ProjectNotFoundException e){
            System.out.println(e);
            return null;
        }
    }

    @PutMapping("/{id}")
    Project replaceProject(@RequestBody Project newProject, @PathVariable String id){
        return projectRepository.findById(id)
                .map(project -> {
                    project.setDescription(newProject.getDescription());
                    project.setProjectName(newProject.getProjectName());
                    return projectRepository.save(newProject);
                })
                .orElseGet(() ->{
                    newProject.setUid(id);
                    return projectRepository.save(newProject);
                });
    }


    @DeleteMapping("/{id}")
    void deleteProject(@PathVariable String id){
        projectRepository.deleteById(id);
    }

    @RequestMapping(value= "/findByProjectName/{projectName}", method = RequestMethod.GET)
    public Project getProjectbyProjectName(@PathVariable("projectName") String projectName){
        return projectRepository.findByProjectName(projectName);
    }


}
