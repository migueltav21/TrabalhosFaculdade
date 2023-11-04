package cbl;

import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.project.*;
import ma02_resources.project.exceptions.InstituitionAlreadyExistException;

public interface ICBL {
    Edition[] getEditions();
    void addEdition(Edition edition);
    Instituition[] getInstituitions();
    void removeEdition(String name);
    Edition getEdition(String name);
    void setActiveEdition(String name);
    Edition getActiveEdition();
    int getNumberOfEditions();
    void addSubmissionToProject(String studentName, Submission submission, String projectName, String taskName);
    void addInstituition(Instituition instituition) throws InstituitionAlreadyExistException;
    Edition[] editionsNotCompleted();
    public Project[] projectsNotCompleted(String name);
    int getNumberOfProjects();
    public Task[] getMissingTaskFromProjectOfActiveEdition(String name);
    public Edition[] getEditionsByStatus(Status status);
    Instituition[] getInstituitionsByType(InstituitionType instituitionType);
}
