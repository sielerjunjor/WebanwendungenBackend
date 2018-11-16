package group.project.riskmanagementBE.model;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import java.util.Map;
import java.util.Vector;

public class Project{
    @Id
    private String uid;
    private String projectName;
    private String riskName;
    private String riskDescription;
    private Double riskCriticality;
    private Double riskProbability;
    private String riskMeassure;

    public Project(String projectName, String riskName, String description, Double criticality, Double probability, String meassure) {
        this.projectName = projectName;
        this.riskName = riskName;
        this.riskDescription = description;
        this.riskCriticality = criticality;
        this.riskProbability = probability;
        this.riskMeassure = meassure;
    }

    public Project() { }

    public Project(String name) {
        this.projectName = name;
    }

    public Project(String name, String description) {
        this.projectName = name; }

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public Double getRiskCriticality() {
        return riskCriticality;
    }

    public void setRiskCriticality(Double riskCriticality) {
        this.riskCriticality = riskCriticality;
    }

    public Double getRiskProbability() {
        return riskProbability;
    }

    public void setRiskProbability(Double riskProbability) {
        this.riskProbability = riskProbability;
    }

    public String getRiskMeassure() {
        return riskMeassure;
    }

    public void setRiskMeassure(String riskMeassure) {
        this.riskMeassure = riskMeassure;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public String getDescription() {
        return riskDescription;
    }

    public void setDescription(String description) {
        this.riskDescription = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Project[uid=%s, projectName='%s', description='%s']",
                uid, projectName, riskDescription);
    }
}
