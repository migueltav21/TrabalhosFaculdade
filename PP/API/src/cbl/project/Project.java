/**
 * Nome: Gabriel Ferreira Moreira
 * Número: 8220225
 * Turma: 3
 * Nome: Miguel Correira Ribeiro Rangel Tavares
 * Número: 8220229
 * Turma: 3
 */
package cbl.project;

import java.util.Arrays;
import ma02_resources.participants.*;
import ma02_resources.project.Task;
import ma02_resources.project.exceptions.*;

public class Project implements ma02_resources.project.Project {

    private final String name;
    private final String description;
    private int posArray = 0;
    private Participant[] participants;
    private Task[] tasks;
    private int posArrayTask;
    private final int maximumNumberOfTasks;
    private final int maximumNumberOfStudents;
    private final int maximumNumberOfPartners;
    private final int maximumNumberOfFacilitators;
    private final String[] tags;

    /**
     * Creates a new Project object with the specified parameters.
     *
     * @param name The name of the project.
     * @param description The description of the project.
     * @param tags The tags associated with the project.
     * @param tasks The array of tasks for the project.
     * @param maximumNumberOfFacilitators The maximum number of facilitators
     * allowed in the project.
     * @param maximumNumberOfStudents The maximum number of students allowed in
     * the project.
     * @param maximumNumberOfPartners The maximum number of partners allowed in
     * the project.
     */
    public Project(String name, String description, String[] tags, Task[] tasks, int maximumNumberOfFacilitators,
                   int maximumNumberOfStudents, int maximumNumberOfPartners) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.maximumNumberOfTasks = tasks.length + 10;
        this.posArrayTask = tasks.length;
        this.tasks = tasks;
        this.maximumNumberOfStudents = maximumNumberOfStudents;
        this.maximumNumberOfPartners = maximumNumberOfPartners;
        this.maximumNumberOfFacilitators = maximumNumberOfFacilitators;
        this.participants = new Participant[maximumNumberOfFacilitators * maximumNumberOfPartners * maximumNumberOfFacilitators];
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getNumberOfParticipants() {
        return posArray;
    }

    /**
     * This method does a loop through the array that contain all the
     * participants and checks if they are an instance of Student
     *
     * @return the number of students in the project
     */
    @Override
    public int getNumberOfStudents() {
        int num = 0;
        for (int i = 0; i < this.posArray; i++) {
            if (participants[i] instanceof Student) {
                num++;
            }
        }
        return num;
    }

    /**
     * This method does a loop through the array that contain all the
     * participants and checks if they are an instance of Partner
     *
     * @return the number of partners in the project
     */
    @Override
    public int getNumberOfPartners() {
        int num = 0;
        for (int i = 0; i < this.posArray; i++) {
            if (participants[i] instanceof Partner) {
                num++;
            }
        }
        return num;
    }

    /**
     * This method does a loop through the array that contain all the
     * participants and checks if they are an instance of Facilitator
     *
     * @return the number of facilitators in the project
     */
    @Override
    public int getNumberOfFacilitators() {
        int num = 0;
        for (int i = 0; i < this.posArray; i++) {
            if (participants[i] instanceof Facilitator) {
                num++;
            }
        }
        return num;
    }

    @Override
    public int getNumberOfTasks() {
        return posArrayTask;
    }

    @Override
    public int getMaximumNumberOfTasks() {
        return maximumNumberOfTasks;
    }

    /**
     * This method does the sum of all the maximum types of participants
     *
     * @return the maximum numbers of participants in a project
     */
    @Override
    public long getMaximumNumberOfParticipants() {
        return maximumNumberOfTasks + maximumNumberOfStudents + maximumNumberOfFacilitators;
    }

    @Override
    public int getMaximumNumberOfStudents() {
        return maximumNumberOfStudents;
    }

    @Override
    public int getMaximumNumberOfPartners() {
        return maximumNumberOfPartners;
    }

    @Override
    public int getMaximumNumberOfFacilitators() {
        return maximumNumberOfFacilitators;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    /**
     * This method is capable of adding participants of any type. Initially, we
     * check if the participant we want to add is in the project or not. If it
     * is already present, an exception is thrown. Then check if it is possible
     * to add the participant in question since there are limits for each type
     * of participant, if it is not possible to add more participants of that
     * type, an exception is thrown. Finally, if no exception is thrown, the
     * participant is added to the array.
     *
     * @param p The participant to add
     * @throws IllegalNumberOfParticipantType Exception that indicates that it's
     * not possible to add more participants of that type
     *
     * @throws ParticipantAlreadyInProject Exception that says the participant
     * to be added is already in the project
     */
    @Override
    public void addParticipant(Participant p) throws IllegalNumberOfParticipantType, ParticipantAlreadyInProject {
        for (int i = 0; i < posArray; i++) {
            if (this.participants[i].getName().equals(p.getName())) {
                throw new ParticipantAlreadyInProject("The participant is already in the project");
            }
        }
        if (this.getNumberOfFacilitators() == this.maximumNumberOfFacilitators) {
            throw new IllegalNumberOfParticipantType("Cannot add more facilitators to the project");
        } else if (this.getNumberOfPartners() == this.maximumNumberOfPartners) {
            throw new IllegalNumberOfParticipantType("Cannot add more partners to the project");
        } else if (this.getNumberOfStudents() == this.maximumNumberOfStudents) {
            throw new IllegalNumberOfParticipantType("Cannot add more students to the project");
        }
        try {
            this.participants[posArray] = p;
        } catch (ArrayIndexOutOfBoundsException e) {
            Participant[] newArray = new Participant[posArray];
            System.arraycopy(this.participants, 0, newArray, 0, posArray);
            this.setParticipants(newArray);
        }
        posArray++;
    }

    /**
     * This method does a loop through the participants array to find the
     * participant
     *
     * @param string The name of the participant that is searched
     * @return the position of the participant in the array, -1 if the
     * participant wasn´t found
     */
    private int getParticipantPos(String string) {
        for (int i = 0; i < posArray; i++) {
            if (this.participants[i].getName().equals(string)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method is capable of remove a participant of the array First of all
     * is checked if the person to remove is pesent in the array. If not null is
     * returned, but if the person exist, the array is updated
     *
     * @param string The name of the person to be removed
     * @return null if the participant wasn't found, The participant removed if
     * he was found
     */
    @Override
    public Participant removeParticipant(String string) {
        Participant participant = null;
        int participantPos = this.getParticipantPos(string);
        if (participantPos != -1) {
            participant = this.participants[participantPos];
            for (int i = participantPos; i < posArray - 1; i++) {
                this.participants[i] = this.participants[i + 1];
            }
            this.posArray--;
        }
        return participant;
    }

    /**
     * This method loops through the participant array and if the name passed as
     * an argument is the same as the name being compared it returns the
     * participant, if the participant is not found it returns null
     *
     * @param string The name of the participant searched
     * @return The participant if he was found, null if not
     */
    @Override
    public Participant getParticipant(String string) {
        for (int i = 0; i < this.posArray; i++) {
            if (this.participants[i].getName().equals(string)) {
                return this.participants[i];
            }
        }
        return null;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

    /**
     * This method check if the string passed as an argument is present in the
     * array of tags If the tag is present in the array it is returned true, if
     * not its returned null
     *
     * @param string The text of the tag
     * @return true if the tag was found, false if not
     */
    @Override
    public boolean hasTag(String string) {
        for (String tag : this.tags) {
            if (tag.equals(string)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is capable of adding tasks. Initially, we check if the task
     * we want to add is in the project or not. If it is already present, an
     * exception is thrown. Then check if it is possible to add the task, if it
     * is not possible to add more tasks an exception is thrown. Finally, if no
     * exception is thrown, the task is added to the array.
     *
     * @param task The task to add
     * @throws IllegalNumberOfTasks Exception that indicates that it's not
     * possible to add more tasks
     * @throws TaskAlreadyInProject Exception that says the task to be added is
     * already in the project
     */
    @Override
    public void addTask(Task task) throws IllegalNumberOfTasks, TaskAlreadyInProject {
        if (posArrayTask >= this.maximumNumberOfTasks) {
            throw new IllegalNumberOfTasks("The limit of tasks has been reached.\nCannot add more tasks.");
        } else {
            for (int i = 0; i < posArrayTask; i++) {
                if (this.tasks[i].equals(task)) {
                    throw new TaskAlreadyInProject("The task is already in the project");
                }
            }
        }
        try {
            this.tasks[posArrayTask] = task;
            posArrayTask++;
        } catch (ArrayIndexOutOfBoundsException e) {
            Task[] newArray = new cbl.project.Task[maximumNumberOfTasks];
            System.arraycopy(this.tasks, 0, newArray, 0, posArrayTask);
            posArrayTask++;
            this.setTasks(newArray);
        }
    }

    /**
     * This method loops through the tasks array and if the name passed as an
     * argument is the same as the name being compared it returns the task, if
     * the task is not found it returns null
     *
     * @param string The name of the task searched
     * @return The Task if he was found, null if not
     */
    @Override
    public Task getTask(String string) {
        for (int i = 0; i < this.posArrayTask; i++) {
            if (this.tasks[i].getDescription().equals(string)) {
                return this.tasks[i];
            }
        }
        return null;
    }

    @Override
    public Task[] getTasks() {
        return tasks;
    }

    /**
     * Checks if the project is completed.
     *
     * @return true if all tasks in the project have at least one submission,
     * false otherwise.
     */
    @Override
    public boolean isCompleted() {
        for (int i = 0; i < this.posArrayTask; i++) {
            if (this.tasks[i].getNumberOfSubmissions() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a string representation of the Project object.
     *
     * @return A string representation of the Project object.
     */
    @Override
    public String toString() {
        return "Project{" + "name=" + name
                + ", description=" + description
                + ", number of participants=" + posArray
                + ", participants=" + Arrays.toString(this.participants)
                + ", tasks=" + Arrays.toString(this.tasks)
                + ", MaximumNumberOfTasks=" + maximumNumberOfTasks
                + ", maximumNumberOfStudents=" + maximumNumberOfStudents
                + ", maximumNumberOfPartners=" + maximumNumberOfPartners
                + ", maximumNumberOfFacilitators=" + maximumNumberOfFacilitators
                + ", completed=" + isCompleted() + '}';
    }

}
