/**
 * Nome: Gabriel Ferreira Moreira
 * Número: 8220225
 * Turma: 3
 * Nome: Miguel Correira Ribeiro Rangel Tavares
 * Número: 8220229
 * Turma: 3
 */

package cbl;

import cbl.participant.Student;
import ma02_resources.participants.Instituition;
import ma02_resources.participants.InstituitionType;
import ma02_resources.project.*;
import ma02_resources.project.exceptions.InstituitionAlreadyExistException;

import java.util.Arrays;

public class CBL implements ICBL {

    private Edition[] editions;
    private int numberOfEditions = 0;
    private Instituition[] instituitions;
    private int numberOfInstituitions = 0;

    /**
     * Constructor for the CBL class. Creates a new CBL object with default
     * values. Initializes the editions and institutions arrays with a fixed
     * size of 10.
     */
    public CBL() {
        this.editions = new Edition[10];
        this.instituitions = new Instituition[10];
    }

    @Override
    public int getNumberOfEditions() {
        return numberOfEditions;
    }

    private void setEditions(Edition[] editions) {
        this.editions = editions;
    }

    @Override
    public Edition[] getEditions() {
        return editions;
    }

    @Override
    public Instituition[] getInstituitions() {
        return instituitions;
    }

    public void setInstituitions(Instituition[] instituition) {
        this.instituitions = instituition;
    }

    public int getNumberOfInstituitions() {
        return numberOfInstituitions;
    }

    public void setNumberOfInstituitions(int numberOfInstituitions) {
        this.numberOfInstituitions = numberOfInstituitions;
    }

    /**
     * Adds an instituition to the array "instituitions"
     *
     * @param instituition Instituition to add
     * @throws InstituitionAlreadyExistException If this instituition already is
     * in the array
     */
    @Override
    public void addInstituition(Instituition instituition) throws InstituitionAlreadyExistException {
        if (this.getInstituition(instituition.getName()) == null) {
            for (Instituition instituition1 : this.instituitions) {
                try {
                    if (instituition1.getName().equals(instituition.getName())) {
                        throw new InstituitionAlreadyExistException("Instituition already exists");
                    }
                } catch (NullPointerException e) {
                    break;
                }
            }
            try {
                this.instituitions[numberOfInstituitions] = instituition;
            } catch (ArrayIndexOutOfBoundsException e) {
                Instituition[] newArray = new Instituition[this.instituitions.length + 10];
                System.arraycopy(this.instituitions, 0, newArray, 0, this.instituitions.length);
                this.setInstituitions(newArray);
            }
            this.numberOfInstituitions++;
        }
    }

    /**
     This method removes an institution with the specified name from the array of institutions.
     @param name The name of the institution to be removed.
     */
    public void removeInstituition(String name) {
        int instituitionPos = this.getInstituitionPos(name);
        if (instituitionPos != -1) {
            for (int i = instituitionPos; i < numberOfEditions - 1; i++) {
                this.instituitions[i] = this.instituitions[i + 1];
            }
            this.numberOfInstituitions--;
        }
    }

    public Instituition getInstituition(String name) {
        for (Instituition instituition : this.getInstituitions()) {
            try {
                if (instituition.getName().equals(name)) {
                    return instituition;
                }
            } catch (NullPointerException e) {
                return null;
            }
        }
        return null;
    }


    /**
     This method returns the position of an institution with the specified name in the array of institutions.
     @param name The name of the institution to search for.
     @return The position of the institution in the array, or -1 if not found.
     */
    public int getInstituitionPos(String name) {
        for (int i = 0; i < numberOfInstituitions; i++) {
            if (this.instituitions[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds an edition to the CBL. If the editions array is full, it will be
     * resized to accommodate more editions.
     *
     * @param edition The edition to be added.
     */
    @Override
    public void addEdition(Edition edition) {
        if (this.getEdition(edition.getName()) == null) {
            try {
                this.editions[numberOfEditions] = edition;
                if (edition.getStatus().equals(Status.ACTIVE)) {
                    this.setActiveEdition(edition.getName());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Edition[] newArray = new Edition[this.editions.length + 10];
                System.arraycopy(this.editions, 0, newArray, 0, this.editions.length);
                this.setEditions(newArray);
            }
            this.numberOfEditions++;
        }
    }

    /**
     * Found the position of the edition with the given name in the editions
     * array.
     *
     * @param name The name of the edition.
     * @return The position of the edition in the editions array, or -1 if not
     * found.
     */
    private int getEditionPos(String name) {
        for (int i = 0; i < numberOfEditions; i++) {
            if (this.editions[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the edition with the given name from the CBL.
     *
     * @param name The name of the edition to be removed.
     */
    @Override
    public void removeEdition(String name) {
        int editionPos = this.getEditionPos(name);
        if (editionPos != -1) {
            for (int i = editionPos; i < numberOfEditions - 1; i++) {
                this.editions[i] = this.editions[i + 1];
            }
            this.numberOfEditions--;
        }
    }

    /**
     * Found the edition with the given name from the CBL.
     *
     * @param name The name of the edition.
     * @return The edition with the given name, or null if not found.
     */
    @Override
    public Edition getEdition(String name) {
        for (Edition edition : this.getEditions()) {
            try {
                if (edition.getName().equals(name)) {
                    return edition;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        return null;
    }

    /**
     * Sets the active edition in the CBL by changing its status to ACTIVE and
     * setting all other editions with ACTIVE status to INACTIVE.
     *
     * @param name The name of the edition to be set as active.
     */
    @Override
    public void setActiveEdition(String name) {
        Edition edition = getEdition(name);
        if (edition != null) {
            for (int i = 0; i < this.numberOfEditions; i++) {
                if (this.editions[i].getStatus().equals(Status.ACTIVE)) {
                    this.editions[i].setStatus(Status.INACTIVE);
                }
            }
            edition.setStatus(Status.ACTIVE);
        }
    }

    /**
     This method sets the status of a specified edition to "INACTIVE".
     @param name The name of the edition to be set as inactive.
     */
    public void setInactiveEdition(String name) {
        Edition edition = getEdition(name);
        try {
            edition.setStatus(Status.INACTIVE);
        } catch (NullPointerException ignored) {

        }
    }


    /**
     This method sets the status of a specified edition to "CLOSED".
     @param name The name of the edition to be closed.
     */
    public void setClosedEdition(String name) {
        Edition edition = getEdition(name);
        try {
            edition.setStatus(Status.CLOSED);
        } catch (NullPointerException ignored) {

        }
    }

    /**
     This method sets the status of a specified edition to "CANCELED".
     @param name The name of the edition to be canceled.
     */
    public void setCanceledEdition(String name) {
        Edition edition = getEdition(name);
        try {
            edition.setStatus(Status.CANCELED);
        } catch (NullPointerException ignored) {

        }
    }

    /**
     * This method found the active edition in the CBL.
     *
     * @return The active edition, or null if no active edition is found.
     */
    @Override
    public Edition getActiveEdition() {
        for (Edition edition : editions) {
            try {
                if (edition.getStatus().equals(Status.ACTIVE)) {
                    return edition;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        return null;
    }

    /**
     * Retrieves the total number of projects across all editions in the CBL.
     *
     * @return The total number of projects.
     */
    @Override
    public int getNumberOfProjects() {
        int numberOfProjects = 0;
        for (Edition edition : this.editions) {
            try {
                numberOfProjects += edition.getNumberOfProjects();
            } catch (NullPointerException e) {
                break;
            }
        }
        return numberOfProjects;
    }

    /**
     * Returns an array of editions that have missing projects, projects that
     * are not completed.
     *
     * @return An array of editions with missing projects.
     */
    @Override
    public Edition[] editionsNotCompleted() {
        int maxNumberOfProjects = this.numberOfEditions;
        int posArray = 0, count;
        Edition[] newArray = new Edition[maxNumberOfProjects];
        for (Edition edition : this.editions) {
            count = 0;
            try {
                for (Project project : edition.getProjects()) {
                    try {
                        if (project.isCompleted()) {
                            count++;
                        }
                    } catch (NullPointerException e) {
                        break;
                    }
                }
                if (count != edition.getNumberOfProjects()) {
                    newArray[posArray] = edition;
                    posArray++;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        Edition[] array = new Edition[posArray];
        System.arraycopy(newArray, 0, array, 0, posArray);
        return array;
    }

    /**
     * This method found an array of projects in a specific edition that are not completed
     *
     * @param name The name of the edition to search for projects.
     * @return An array of projects that are not completed in the specified
     * edition.
     */
    @Override
    public Project[] projectsNotCompleted(String name) {
        Edition edition = this.getEdition(name);
        if (edition != null) {
            Project[] project = new Project[edition.getNumberOfProjects() + this.getActiveEdition().getNumberOfProjects()];
            int posArray = 0;
            for (int i = 0; i < edition.getNumberOfProjects(); i++) {
                if (!edition.getProjects()[i].isCompleted()) {
                    project[posArray] = edition.getProjects()[i];
                    posArray++;
                }
            }
            for (int i = 0; i < this.getActiveEdition().getNumberOfProjects(); i++) {
                if (!this.getActiveEdition().getProjects()[i].isCompleted()) {
                    project[posArray] = this.getActiveEdition().getProjects()[posArray];
                    posArray++;
                }
            }
            Project[] array = new Project[posArray];
            System.arraycopy(project, 0, array, 0, posArray);
            return array;
        }
        return null;
    }

    /**
     * Adds a submission to a specific task in a project for a given student.
     *
     * @param studentName The name of the student submitting the submission.
     * @param submission The submission to be added.
     * @param projectName The name of the project.
     * @param taskName The name of the task within the project.
     */
    @Override
    public void addSubmissionToProject(String studentName, Submission submission, String projectName, String taskName) {
        try {
            if (this.getActiveEdition().getProject(projectName).getParticipant(studentName) != null) {
                this.getActiveEdition().getProject(projectName).getTask(taskName).addSubmission(submission);
            }
        } catch (NullPointerException e) {
            System.out.println("Couldn't add submission");
        }
    }

    /**
     * This method found an array of editions with the specified status.
     *
     * @param status The status to filter the editions.
     * @return An array of editions with the specified status.
     */
    @Override
    public Edition[] getEditionsByStatus(Status status) {
        Edition[] editions1 = new Edition[this.numberOfEditions];
        int posArray = 0;

        for (Edition edition : this.editions) {
            try {
                if (edition.getStatus().equals(status)) {
                    editions1[posArray] = edition;
                    posArray++;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        Edition[] array = new Edition[posArray];
        System.arraycopy(editions1, 0, array, 0, posArray);
        return array;
    }

    /**
     * This method found an array of tasks that have no submissions from the
     * specified project of the active edition.
     *
     * @param name The name of the project.
     * @return An array of tasks with no submissions from the specified project.
     * Returns null if the project is completed or has no tasks.
     */
    @Override
    public Task[] getMissingTaskFromProjectOfActiveEdition(String name) {
        Project project;
        try {
            project = this.getActiveEdition().getProject(name);
        } catch (NullPointerException e) {
            return null;
        }
        try {
            if (project.isCompleted() || project.getNumberOfTasks() == 0) {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        }

        Task[] tasks = new Task[project.getNumberOfTasks()];
        int posArray = 0;

        for (Task task : project.getTasks()) {
            try {
                if (task.getNumberOfSubmissions() == 0) {
                    tasks[posArray] = task;
                    posArray++;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        Task[] array = new Task[posArray];
        System.arraycopy(tasks, 0, array, 0, posArray);
        return array;
    }

    /**
     * This method found an array of institutions of the specified type.
     *
     * @param instituitionType The type of institution.
     * @return An array of institutions of the specified type.
     */
    @Override
    public Instituition[] getInstituitionsByType(InstituitionType instituitionType) {
        Instituition[] instituitionsArray = new Instituition[this.numberOfInstituitions];
        int posArray = 0;

        for (Instituition instituition : this.instituitions) {
            try {
                if (instituition.getType().equals(instituitionType)) {
                    instituitionsArray[posArray] = instituition;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        Instituition[] array = new Instituition[posArray];
        System.arraycopy(instituitionsArray, 0, array, 0, posArray);
        return array;
    }

    /**
     This method calculates the number of completed tasks in a given project.

     @param project The project for which the completed tasks need to be counted.

     @return The count of completed tasks in the project.
     */
    private int getNumberOfCompletedTasks(Project project) {
        int completedTask = 0;
        for (Task task : project.getTasks()) {
            try {
                if (task.getNumberOfSubmissions() > 0) {
                    completedTask++;
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        return completedTask;
    }

    /**
     This method calculates the progress of a specific project within an edition based on the completion status of its tasks.

     @param editionName The name of the edition that contains the project.
     @param projectName The name of the project for which the progress needs to be calculated.
     @return A string representing the progress of the project in percentage.
     */
    public String getProjectProgress(String editionName, String projectName) {
        Project project;
        Edition edition = getEdition(editionName);
        int completedTasks = 0, totalNumberOfTasks;
        try {
            project = edition.getProject(projectName);
            totalNumberOfTasks = project.getNumberOfTasks();
        } catch (NullPointerException e) {
            return null;
        }

        completedTasks = getNumberOfCompletedTasks(project);

        int result;
        try {
            result = (completedTasks / totalNumberOfTasks) * 100;
        } catch (ArithmeticException e) {
            result = 0;
        }

        return "This project is " + result + "% completed";
    }

    /**
     This method calculates the progress of an edition based on the completion status of its projects.

     @param editionName The name of the edition for which the progress needs to be calculated.

     @return A string representing the progress of the edition in percentage.
     */
    public String getEditionProgress(String editionName) {
        Edition edition = getEdition(editionName);
        int totalNumberOfTasks = 0;
        int completedTasks = 0;
        try {
            for (Project project : edition.getProjects()) {
                try {
                    totalNumberOfTasks += project.getNumberOfTasks();
                    completedTasks += getNumberOfCompletedTasks(project);
                } catch (NullPointerException e) {
                    break;
                }
            }
        } catch (NullPointerException e) {
            return null;
        }

        int result;
        try {
            result = (completedTasks / totalNumberOfTasks) * 100;
        } catch (ArithmeticException e) {
            result = 0;
        }

        return "This edition is " + result + "% completed";
    }

    /**
     This method checks if a student with the specified name is participating in any active project within the CBL system.
     @param name The name of the student to check.
     @return true if the student is participating in an active project, false otherwise.
     */
    public boolean studentInCbl(String name) {
        try {
            for (Project project : this.getActiveEdition().getProjects()) {
                try {
                    if (project.getParticipant(name) != null && project.getParticipant(name) instanceof Student) {
                        return true;
                    }
                } catch (NullPointerException e) {
                    break;
                }
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CBL{"
                + "editions=" + Arrays.toString(editions)
                + ", numberOfEditions=" + numberOfEditions
                + ", instituitions=" + Arrays.toString(instituitions)
                + ", numberOfInstituitions=" + numberOfInstituitions
                + '}';
    }
}
