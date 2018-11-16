package group.project.riskmanagementBE.exception;

public class ProjectNotFoundException extends Exception{

      public ProjectNotFoundException(String id)
        {
            super("The project with the ID: "+id+" could not be found!");
    }
}
