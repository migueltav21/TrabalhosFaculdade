import cbl.*;
import ma02_resources.participants.*;
import ma02_resources.participants.InstituitionType;
import ma02_resources.project.*;
import ma02_resources.project.exceptions.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int readInt(Scanner read) {
        boolean valid = false;
        int option = 0;
        while (!valid) {
            try {
                option = read.nextInt();
                if (!(option <= 0)) {
                    valid = true;
                }
            } catch (InputMismatchException ignored) {
            }
            read.nextLine();
        }
        return option;
    }

    public static int readIntWithLimit(Scanner read, int min, int max) {
        boolean valid = false;
        int option = 0;
        while (!valid) {
            try {
                option = read.nextInt();
            } catch (InputMismatchException e) {
                read.nextLine();
                continue;
            }
            if (option >= min && option <= max) {
                valid = true;
            }
            read.nextLine();
        }
        return option;
    }

    private static InstituitionType Itype(int studentITypeOption) {
        InstituitionType studentITypeFind = null;
        switch (studentITypeOption) {
            case 0:
                studentITypeFind = InstituitionType.UNIVERSITY;
                break;
            case 1:
                studentITypeFind = InstituitionType.COMPANY;
                break;
            case 2:
                studentITypeFind = InstituitionType.NGO;
                break;
            case 3:
                studentITypeFind = InstituitionType.OTHER;
                break;
        }
        return studentITypeFind;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean run = true;

        CBL cbl = new CBL();

        while (run) {
            System.out.println("[ 0 ] - Student\n"
                    + "[ 1 ] - Administrator\n"
                    + "[ 2 ] - Leave\n");
            System.out.println("Enter your option:");
            int mainOption = readIntWithLimit(read, 0, 2);
            if (mainOption == 0) {
                boolean runStudentMenu = true;
                while (runStudentMenu) {
                    System.out.println("[ 0 ] - Enter with student name\n"
                            + "[ 1 ] - Go back\n");
                    System.out.println("Enter your option:");
                    int optionStudentMenu = readIntWithLimit(read, 0, 1);

                    switch (optionStudentMenu) {
                        case 0:
                            System.out.println("Enter your name:");
                            String studentCheckName = read.nextLine();
                            boolean valid = cbl.studentInCbl(studentCheckName);
                            if (!valid) {
                                System.out.println("Student does not exist");
                                runStudentMenu = false;
                                continue;
                            } else {
                                boolean runStudentOptionMenu = true;
                                while (runStudentOptionMenu) {
                                    System.out.println("[ 0 ] - See projects\n"
                                            + "[ 1 ] - Add submission to project\n"
                                            + "[ 2 ] - Add task to project\n"
                                            + "[ 3 ] - See tags\n"
                                            + "[ 4 ] - See tasks\n"
                                            + "[ 5 ] - See if it has a specific tag\n"
                                            + "[ 6 ] - See project progress\n"
                                            + "[ 7 ] - Go back\n");
                                    System.out.print("Enter your option: ");
                                    int option = readIntWithLimit(read, 0, 10);
                                    switch (option) {
                                        case 0:
                                            for (Project project : cbl.getActiveEdition().getProjectsOf(studentCheckName)) {
                                                try {
                                                    System.out.println(project.getName());
                                                } catch (NullPointerException e) {
                                                    break;
                                                }
                                            }
                                            break;
                                        case 1:
                                            System.out.println("Enter the name of the project:");
                                            String studentProject = read.nextLine();

                                            try {
                                                Project project = cbl.getActiveEdition().getProject(studentProject);
                                                System.out.println("Enter the text to you submission");
                                                String submissionText = read.nextLine();

                                                Submission submission = new cbl.project.Submission((Student) cbl.getActiveEdition().getProject(studentProject).getParticipant(studentCheckName), submissionText);

                                                System.out.println("Enter the task name:");
                                                String taskName = read.nextLine();

                                                cbl.addSubmissionToProject(studentCheckName, submission, studentProject, taskName);

                                            } catch (NullPointerException e) {
                                                System.out.println("There is no project with that name");
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Insert the task name: ");
                                            String taskName = read.nextLine();

                                            System.out.println("Insert the year to start: ");
                                            int startYearTask = readInt(read);

                                            System.out.println("Insert the month to start: ");
                                            int startMonthTask = readIntWithLimit(read, 0, 12);

                                            System.out.println("Insert the day to start: ");
                                            int startDayTask;
                                            if (startMonthTask == 1 || startMonthTask == 3 || startMonthTask == 5 || startMonthTask == 7 || startMonthTask == 8) {
                                                startDayTask = readIntWithLimit(read, 1, 31);
                                            } else if (startMonthTask == 2) {
                                                if (startYearTask % 4 == 0) {
                                                    startDayTask = readIntWithLimit(read, 1, 29);
                                                } else {
                                                    startDayTask = readIntWithLimit(read, 1, 28);
                                                }
                                            } else {
                                                startDayTask = readIntWithLimit(read, 1, 30);
                                            }

                                            System.out.println("Insert the year to end: ");
                                            int endYearTask = readInt(read);

                                            System.out.println("Insert the month to end: ");
                                            int endMonthTask = readIntWithLimit(read, 0, 12);

                                            System.out.println("Insert the day to end: ");
                                            int endDayTask;
                                            if (endMonthTask == 1 || endMonthTask == 3 || endMonthTask == 5 || endMonthTask == 7 || endMonthTask == 8) {
                                                endDayTask = readIntWithLimit(read, 1, 31);
                                            } else if (endMonthTask == 2) {
                                                if (endYearTask % 4 == 0) {
                                                    endDayTask = readIntWithLimit(read, 1, 29);
                                                } else {
                                                    endDayTask = readIntWithLimit(read, 1, 28);
                                                }
                                            } else {
                                                endDayTask = readIntWithLimit(read, 1, 30);
                                            }
                                            System.out.println("Insert the description of the task:");
                                            String taskDescription = read.nextLine();

                                            Task newTask = new cbl.project.Task(LocalDate.of(startYearTask, startMonthTask, startDayTask),
                                                    LocalDate.of(endYearTask, endMonthTask, endDayTask),
                                                    taskName, taskDescription);

                                            System.out.println("Enter the project name:");
                                            String projectName = read.nextLine();

                                            if (cbl.getActiveEdition().getProject(projectName) != null) {
                                                try {
                                                    cbl.getActiveEdition().getProject(projectName).addTask(newTask);
                                                } catch (IllegalNumberOfTasks e) {
                                                    System.out.println("You cant add any more tasks to thos project");
                                                } catch (TaskAlreadyInProject e) {
                                                    System.out.println("This task is already in project");
                                                }
                                            } else {
                                                System.out.println("Project does not exist");
                                            }

                                            break;
                                        case 3:
                                            System.out.println("Enter the project name:");
                                            String nameToSeTags = read.nextLine();

                                            if (cbl.getActiveEdition().getProject(nameToSeTags) != null) {
                                                for (String tag : cbl.getActiveEdition().getProject(nameToSeTags).getTags()) {
                                                    try {
                                                        System.out.println(tag);
                                                    } catch (NullPointerException e) {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                System.out.println("Project does not exist");
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Enter the project name:");
                                            String nameToSeTasks = read.nextLine();
                                            if (cbl.getActiveEdition().getProject(nameToSeTasks) != null) {
                                                for (Task task : cbl.getActiveEdition().getProject(nameToSeTasks).getTasks()) {
                                                    try {
                                                        System.out.println(task.getTitle());
                                                    } catch (NullPointerException e) {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                System.out.println("Project does not exist");
                                            }
                                            break;
                                        case 5:
                                            System.out.println("Enter the project name:");
                                            String nameHasTag = read.nextLine();

                                            System.out.println("Enter the tag name:");
                                            String tagName = read.nextLine();

                                            if (cbl.getActiveEdition().getProject(nameHasTag) != null) {
                                                System.out.println("Has tag:");
                                                System.out.println(cbl.getActiveEdition().getProject(nameHasTag).hasTag(tagName));
                                            } else {
                                                System.out.println("Project does not exist");
                                            }
                                            break;
                                        case 6:
                                            System.out.println("Enter the project name:");
                                            String nameProjectProgress = read.nextLine();

                                            if (cbl.getActiveEdition().getProject(nameProjectProgress) != null) {
                                                System.out.println(cbl.getProjectProgress(cbl.getActiveEdition().getName(), nameProjectProgress));
                                            } else {
                                                System.out.println("Project does not exist");
                                            }
                                            break;
                                        case 7:
                                            runStudentOptionMenu = false;
                                            break;
                                    }
                                }
                            }
                            break;
                        case 1:
                            runStudentMenu = false;
                    }
                }
            } else if (mainOption == 1) {
                boolean runMainMenu = true;
                while (runMainMenu) {
                    System.out.println("[ 0 ] - Create Edition\n"
                            + "[ 1 ] - Remove edition\n"
                            + "[ 2 ] - Edition Menu\n"
                            + "[ 3 ] - Add Institution\n"
                            + "[ 4 ] - Remove Institution\n"
                            + "[ 5 ] - See number of Projects in all editions of CBL\n"
                            + "[ 6 ] - See editions by status\n"
                            + "[ 7 ] - See missing tasks from one project of the active edition\n"
                            + "[ 8 ] - See institutions by type\n"
                            + "[ 9 ] - Go back\n");
                    System.out.print("Enter your option: ");
                    int option = readIntWithLimit(read, 0, 9);

                    switch (option) {
                        case 0:
                            System.out.println("Insert the edition name: ");
                            String editionName = read.nextLine();

                            System.out.println("Insert the year to start: ");
                            int startYear = readInt(read);

                            System.out.println("Insert the month to start: ");
                            int startMonth = readIntWithLimit(read, 0, 12);

                            System.out.println("Insert the day to start: ");
                            int startDay;
                            if (startMonth == 1 || startMonth == 3 || startMonth == 5 || startMonth == 7 || startMonth == 8) {
                                startDay = readIntWithLimit(read, 1, 31);
                            } else if (startMonth == 2) {
                                if (startYear % 4 == 0) {
                                    startDay = readIntWithLimit(read, 1, 29);
                                } else {
                                    startDay = readIntWithLimit(read, 1, 28);
                                }
                            } else {
                                startDay = readIntWithLimit(read, 1, 30);
                            }

                            System.out.println("Insert the path to the project template: ");
                            String projectTemplate = read.nextLine();

                            System.out.println("Choose the satus:\n"
                                    + "[ 0 ] - Active\n"
                                    + "[ 1 ] - Inactive\n"
                                    + "[ 2 ] - Closed\n"
                                    + "[ 3 ] - Canceled\n");
                            int status = readIntWithLimit(read, 0, 3);
                            Status editionStatus = null;
                            switch (status) {
                                case 0:
                                    editionStatus = Status.ACTIVE;
                                    break;
                                case 1:
                                    editionStatus = Status.INACTIVE;
                                    break;
                                case 2:
                                    editionStatus = Status.CLOSED;
                                    break;
                                case 3:
                                    editionStatus = Status.CANCELED;
                                    break;
                            }

                            System.out.println("How many days has the edition: ");
                            int days = readInt(read);

                            cbl.addEdition(new cbl.project.Edition(editionName, LocalDate.of(startYear, startMonth, startDay),
                                    LocalDate.of(startYear, startMonth, startDay).plusDays(days), projectTemplate, editionStatus));
                            break;
                        case 1:
                            if (cbl.getNumberOfEditions() > 0) {
                                System.out.println("Insert the name of the edition you want to remove:");
                                String name = read.nextLine();
                                cbl.removeEdition(name);
                            } else {
                                System.out.println("There are no editions to remove|");
                            }
                            break;
                        case 2:
                            boolean runEditionsMenu = true;
                            while (runEditionsMenu) {
                                System.out.println("Editions Menu:\n"
                                        + "[ 0 ] - Add project to an edition\n"
                                        + "[ 1 ] - Remove project from an edition\n"
                                        + "[ 2 ] - Projects Menu\n"
                                        + "[ 3 ] - Set Active Edition\n"
                                        + "[ 4 ] - Set Inactive Edition\n"
                                        + "[ 5 ] - Set Closed Edition\n"
                                        + "[ 6 ] - Set Canceled Edition\n"
                                        + "[ 7 ] - See editions with missing projects\n"
                                        + "[ 8 ] - See the progress of an edition\n"
                                        + "[ 9 ] - Go back");
                                System.out.print("Enter your option: ");
                                int optionEditionMenu = readIntWithLimit(read, 0, 9);

                                switch (optionEditionMenu) {
                                    case 0:
                                        System.out.println("Insert the name of the edition:");
                                        String nameEdition = read.nextLine();

                                        ma02_resources.project.Edition editionToChange = cbl.getEdition(nameEdition);
                                        try {
                                            System.out.println("Insert the name of the project:");
                                            String projectName = read.nextLine();

                                            System.out.println("Insert the description of the project:");
                                            String projectDescription = read.nextLine();

                                            System.out.println("How many tags do you want to insert:");
                                            int tagsNumber = readInt(read);

                                            String[] tags = new String[tagsNumber];
                                            for (int i = 0; i < tagsNumber; i++) {
                                                System.out.println("Insert the tag:");
                                                tags[i] = read.nextLine();
                                            }
                                            try {
                                                editionToChange.addProject(projectName, projectDescription, tags);
                                            } catch (IOException | ParseException e) {
                                                System.out.println("Something went wrong while reading the template file.");
                                            }
                                        } catch (NullPointerException e) {
                                            System.out.println("Edition does not exist.");
                                        }
                                        break;
                                    case 1:
                                        System.out.println("Insert the name of the edition which the project is part of:");
                                        String projectRemoveEdition = read.nextLine();

                                        System.out.println("Insert the name of the project to remove:");
                                        String projectRemove = read.nextLine();

                                        try {
                                            if (cbl.getEdition(projectRemoveEdition).getNumberOfProjects() > 0) {
                                                cbl.getEdition(projectRemoveEdition).removeProject(projectRemove);
                                            }
                                        } catch (NullPointerException e) {
                                            System.out.println("The edition does not exist");
                                        }
                                        break;
                                    case 2:
                                        boolean runProjectsMenu = true;
                                        // Aqui tens de meter todas as funcoes relativas aos projects
                                        System.out.println("Insert the name of the edition:");
                                        String nameOfEdition = read.nextLine();
                                        ma02_resources.project.Edition edition = cbl.getEdition(nameOfEdition);
                                        if (edition != null) {
                                            System.out.println("Insert the name of the project: ");
                                            String nameOfProject = read.nextLine();
                                            Project project = edition.getProject(nameOfProject);
                                            if (project != null) {
                                                while (runProjectsMenu) {
                                                    System.out.println("Project menu:\n"
                                                            + "[ 0 ] - Get number of participants\n"
                                                            + "[ 1 ] - Get number of students\n"
                                                            + "[ 2 ] - Get number of partners\n"
                                                            + "[ 3 ] - Get number of facilitators\n"
                                                            + "[ 4 ] - Get number of tasks\n"
                                                            + "[ 5 ] - Add participant\n"
                                                            + "[ 6 ] - Remove participant\n"
                                                            + "[ 7 ] - Get information of participant\n"
                                                            + "[ 8 ] - Add task\n"
                                                            + "[ 9 ] - Is completed\n"
                                                            + "[ 10 ] - See informations of the project\n"
                                                            + "[ 11 ] - See information of the participant\n"
                                                            + "[ 12 ] - See project progress\n"
                                                            + "[ 13 ] - Go back\n");
                                                    System.out.print("Enter your option: ");
                                                    int optionProjectMenu = readIntWithLimit(read, 0, 13);
                                                    switch (optionProjectMenu) {
                                                        case 0:
                                                            System.out.println("There are " + project.getNumberOfParticipants()
                                                                    + " participants on the project\n");
                                                            break;
                                                        case 1:
                                                            System.out.println("There are " + project.getNumberOfStudents()
                                                                    + " students on the project\n");
                                                            break;
                                                        case 2:
                                                            System.out.println("There are " + project.getNumberOfPartners()
                                                                    + " parteners on the project\n");
                                                            break;
                                                        case 3:
                                                            System.out.println("There are " + project.getNumberOfFacilitators()
                                                                    + " facilitators on the project\n");
                                                            break;
                                                        case 4:
                                                            System.out.println("There are " + project.getNumberOfTasks()
                                                                    + " tasks on the project\n");
                                                            break;
                                                        case 5:
                                                            System.out.println("Witch type of participant:\n"
                                                                    + "[ 1 ] - Facilitator\n"
                                                                    + "[ 2 ] - Partner\n"
                                                                    + "[ 3 ] - Student\n");
                                                            System.out.print("Enter your option: ");
                                                            int optionPartMenu = readIntWithLimit(read, 0, 3);
                                                            switch (optionPartMenu) {
                                                                case 1:
                                                                    System.out.println("Insert the name of the facilitator:");
                                                                    String facilitatorName = read.nextLine();
                                                                    System.out.println("Insert the email of the facilitator:");
                                                                    String emailFacilitator = read.nextLine();

                                                                    System.out.println("Contact:");
                                                                    System.out.println("Insert the street of the contact:");
                                                                    String streetContactF = read.nextLine();
                                                                    System.out.println("Insert the city of the contact:");
                                                                    String citytContactF = read.nextLine();
                                                                    System.out.println("Insert the state of the contact:");
                                                                    String stateContactF = read.nextLine();
                                                                    System.out.println("Insert the zip code of the contact:");
                                                                    String zipContactF = read.nextLine();
                                                                    System.out.println("Insert the country of the contact:");
                                                                    String countryContactF = read.nextLine();
                                                                    System.out.println("Insert the phone numbre of the contact:");
                                                                    String phoneContactF = read.nextLine();
                                                                    Contact contactFacilitator = new cbl.participant.Contact(streetContactF, citytContactF, stateContactF,
                                                                            zipContactF, countryContactF, phoneContactF);

                                                                    System.out.println("Instituition:");
                                                                    cbl.participant.Instituition institution = null;
                                                                    for (int i = 0; i < cbl.getNumberOfInstituitions(); i++) {
                                                                        System.out.println("[ " + i + " ] -" + cbl.getInstituitions()[i].getName());
                                                                    }
                                                                    System.out.println("[ " + ((int) cbl.getNumberOfInstituitions() + 1) + " ] - Create a new one");
                                                                    int num = readIntWithLimit(read, 0, cbl.getNumberOfInstituitions() + 1);
                                                                    if (num != cbl.getNumberOfInstituitions() + 1) {
                                                                        institution = (cbl.participant.Instituition) cbl.getInstituitions()[num];
                                                                    } else {
                                                                        System.out.println("Insert the name of the institution:");
                                                                        String institutionNameF = read.nextLine();
                                                                        System.out.println("Insert the email of the institution:");
                                                                        String institutionEmailF = read.nextLine();
                                                                        System.out.println("Insert the website of the institution:");
                                                                        String WebSiteContactF = read.nextLine();
                                                                        System.out.println("Insert the description of the institution:");
                                                                        String descriptionContactF = read.nextLine();
                                                                        System.out.println("Insert the type of the institution:");
                                                                        System.out.println("[ 0 ] - UNIVERSITY"
                                                                                + "[ 1 ] - COMPANY"
                                                                                + "[ 2 ] - NGO"
                                                                                + "[ 3 ] - OTHER");
                                                                        int type = readIntWithLimit(read, 0, 3);
                                                                        InstituitionType t = null;
                                                                        t = Itype(type);
                                                                        System.out.println("Contact of the institution:");
                                                                        System.out.println("Insert the street of the contact:");
                                                                        String streetContactFinst = read.nextLine();
                                                                        System.out.println("Insert the city of the contact:");
                                                                        String citytContactFinst = read.nextLine();
                                                                        System.out.println("Insert the state of the contact:");
                                                                        String stateContactFinst = read.nextLine();
                                                                        System.out.println("Insert the zip code of the contact:");
                                                                        String zipContactFinst = read.nextLine();
                                                                        System.out.println("Insert the country of the contact:");
                                                                        String countryContactFinst = read.nextLine();
                                                                        System.out.println("Insert the phone number of the contact:");
                                                                        String phoneContactFinst = read.nextLine();
                                                                        Contact contactofInstitution = new cbl.participant.Contact(streetContactFinst, citytContactFinst, stateContactFinst,
                                                                                zipContactFinst, countryContactFinst, phoneContactFinst);
                                                                        institution = new cbl.participant.Instituition(institutionNameF, institutionEmailF, t, contactofInstitution,
                                                                                WebSiteContactF, descriptionContactF);
                                                                        try {
                                                                            cbl.addInstituition(institution);
                                                                        } catch (InstituitionAlreadyExistException e) {
                                                                            e.getMessage();
                                                                        }
                                                                    }
                                                                    System.out.println("Insert the area of expertise:");
                                                                    String areaExpertise = read.nextLine();
                                                                    try {
                                                                        Participant p = new cbl.participant.Facilitator(facilitatorName, emailFacilitator, contactFacilitator,
                                                                                institution, areaExpertise);
                                                                        cbl.getEdition(nameOfEdition).getProject(nameOfProject).addParticipant(p);
                                                                        System.out.println("Participant added");
                                                                    } catch (ParticipantAlreadyInProject | IllegalNumberOfParticipantType e) {
                                                                        e.getMessage();
                                                                    }
                                                                    break;
                                                                case 2:

                                                                    System.out.println("Insert the name of the partner:");
                                                                    String partnerName = read.nextLine();
                                                                    System.out.println("Insert the email of the partner:");
                                                                    String emailPartner = read.nextLine();
                                                                    System.out.println("Contact:");
                                                                    System.out.println("Insert the street of the contact:");
                                                                    String streetContactP = read.nextLine();
                                                                    System.out.println("Insert the city of the contact:");
                                                                    String citytContactP = read.nextLine();
                                                                    System.out.println("Insert the state of the contact:");
                                                                    String stateContactP = read.nextLine();
                                                                    System.out.println("Insert the zip code of the contact:");
                                                                    String zipContactP = read.nextLine();
                                                                    System.out.println("Insert the country of the contact:");
                                                                    String countryContactP = read.nextLine();
                                                                    System.out.println("Insert the phone numbre of the contact:");
                                                                    String phoneContactP = read.nextLine();
                                                                    Contact contactPartenr = new cbl.participant.Contact(streetContactP, citytContactP, stateContactP,
                                                                            zipContactP, countryContactP, phoneContactP);

                                                                    System.out.println("Instituition:");
                                                                    institution = null;
                                                                    for (int i = 0; i < cbl.getNumberOfInstituitions(); i++) {
                                                                        System.out.println("[ " + i + " ] -" + cbl.getInstituitions()[i].getName());
                                                                    }
                                                                    System.out.println("[ " + ((int) cbl.getNumberOfInstituitions() + 1) + " ] - Create a new one");
                                                                    int numm = readIntWithLimit(read, 0, cbl.getNumberOfInstituitions() + 1);
                                                                    if (numm != cbl.getNumberOfInstituitions() + 1) {
                                                                        institution = (cbl.participant.Instituition) cbl.getInstituitions()[numm];
                                                                    } else {
                                                                        System.out.println("Insert the name of the institution:");
                                                                        String institutionNameP = read.nextLine();
                                                                        System.out.println("Insert the email of the institution:");
                                                                        String institutionEmailP = read.nextLine();
                                                                        System.out.println("Insert the website of the institution:");
                                                                        String WebSiteContactP = read.nextLine();
                                                                        System.out.println("Insert the description of the institution:");
                                                                        String descriptionContactP = read.nextLine();
                                                                        System.out.println("Insert the type of the institution:");
                                                                        System.out.println("[ 0 ] - UNIVERSITY"
                                                                                + "[ 1 ] - COMPANY"
                                                                                + "[ 2 ] - NGO"
                                                                                + "[ 3 ] - OTHER");
                                                                        int type = readIntWithLimit(read, 0, 3);
                                                                        InstituitionType t = null;
                                                                        t = Itype(type);
                                                                        System.out.println("Contact of the institution:");
                                                                        System.out.println("Insert the street of the contact:");
                                                                        String streetContactPinst = read.nextLine();
                                                                        System.out.println("Insert the city of the contact:");
                                                                        String citytContactPinst = read.nextLine();
                                                                        System.out.println("Insert the state of the contact:");
                                                                        String stateContactPinst = read.nextLine();
                                                                        System.out.println("Insert the zip code of the contact:");
                                                                        String zipContactPinst = read.nextLine();
                                                                        System.out.println("Insert the country of the contact:");
                                                                        String countryContactPinst = read.nextLine();
                                                                        System.out.println("Insert the phone number of the contact:");
                                                                        String phoneContactPinst = read.nextLine();
                                                                        Contact contactofInstitution = new cbl.participant.Contact(streetContactPinst, citytContactPinst, stateContactPinst,
                                                                                zipContactPinst, countryContactPinst, phoneContactPinst);
                                                                        institution = new cbl.participant.Instituition(institutionNameP, institutionEmailP, t, contactofInstitution,
                                                                                WebSiteContactP, descriptionContactP);
                                                                        try {
                                                                            cbl.addInstituition(institution);
                                                                        } catch (InstituitionAlreadyExistException e) {
                                                                            e.getMessage();
                                                                        }
                                                                    }

                                                                    System.out.println("Insert the vat of the partner:");
                                                                    String vatPartner = read.nextLine();
                                                                    System.out.println("Insert the website of the partner:");
                                                                    String websitePartner = read.nextLine();
                                                                    try {
                                                                        Participant p = new cbl.participant.Partner(partnerName, emailPartner, contactPartenr, institution,
                                                                                vatPartner, websitePartner);
                                                                        cbl.getEdition(nameOfEdition).getProject(nameOfProject).addParticipant(p);
                                                                        System.out.println("Participant added");
                                                                    } catch (ParticipantAlreadyInProject | IllegalNumberOfParticipantType e) {
                                                                        System.out.println("Could not add the participant");
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    System.out.println("Insert the name of the student:");
                                                                    String studentName = read.nextLine();
                                                                    System.out.println("Insert the email of the student:");
                                                                    String emailStudent = read.nextLine();
                                                                    System.out.println("Contact:");
                                                                    System.out.println("Insert the street of the contact:");
                                                                    String streetContactS = read.nextLine();
                                                                    System.out.println("Insert the city of the contact:");
                                                                    String citytContactS = read.nextLine();
                                                                    System.out.println("Insert the state of the contact:");
                                                                    String stateContactS = read.nextLine();
                                                                    System.out.println("Insert the zip code of the contact:");
                                                                    String zipContactS = read.nextLine();
                                                                    System.out.println("Insert the country of the contact:");
                                                                    String countryContactS = read.nextLine();
                                                                    System.out.println("Insert the phone numbre of the contact:");
                                                                    String phoneContactS = read.nextLine();
                                                                    Contact contactStudent = new cbl.participant.Contact(streetContactS, citytContactS, stateContactS,
                                                                            zipContactS, countryContactS, phoneContactS);

                                                                    System.out.println("Instituition:");
                                                                    for (int i = 0; i < cbl.getNumberOfInstituitions(); i++) {
                                                                        System.out.println("[ " + i + " ] - " + cbl.getInstituitions()[i].getName());
                                                                    }
                                                                    System.out.println("[ " + ((int) cbl.getNumberOfInstituitions()) + " ] - Create a new one");
                                                                    int n = readIntWithLimit(read, 0, cbl.getNumberOfInstituitions());
                                                                    if (n != cbl.getNumberOfInstituitions()) {
                                                                        institution = (cbl.participant.Instituition) cbl.getInstituitions()[n];
                                                                    } else {
                                                                        System.out.println("Insert the name of the institution:");
                                                                        String institutionNameS = read.nextLine();
                                                                        System.out.println("Insert the email of the institution:");
                                                                        String institutionEmailS = read.nextLine();
                                                                        System.out.println("Insert the website of the institution:");
                                                                        String WebSiteContactS = read.nextLine();
                                                                        System.out.println("Insert the description of the institution:");
                                                                        String descriptionContactS = read.nextLine();
                                                                        System.out.println("Insert the type of the institution:");
                                                                        System.out.println("[ 0 ] - UNIVERSITY"
                                                                                + "[ 1 ] - COMPANY"
                                                                                + "[ 2 ] - NGO"
                                                                                + "[ 3 ] - OTHER");
                                                                        int type = readIntWithLimit(read, 0, 3);
                                                                        InstituitionType t = null;
                                                                        t = Itype(type);
                                                                        System.out.println("Contact of the institution:");
                                                                        System.out.println("Insert the street of the contact:");
                                                                        String streetContactSinst = read.nextLine();
                                                                        System.out.println("Insert the city of the contact:");
                                                                        String citytContactSinst = read.nextLine();
                                                                        System.out.println("Insert the state of the contact:");
                                                                        String stateContactSinst = read.nextLine();
                                                                        System.out.println("Insert the zip code of the contact:");
                                                                        String zipContactSinst = read.nextLine();
                                                                        System.out.println("Insert the country of the contact:");
                                                                        String countryContactSinst = read.nextLine();
                                                                        System.out.println("Insert the phone number of the contact:");
                                                                        String phoneContactSinst = read.nextLine();
                                                                        Contact contactofInstitution = new cbl.participant.Contact(streetContactSinst, citytContactSinst, stateContactSinst,
                                                                                zipContactSinst, countryContactSinst, phoneContactSinst);
                                                                        institution = new cbl.participant.Instituition(institutionNameS, institutionEmailS, t, contactofInstitution,
                                                                                WebSiteContactS, descriptionContactS);
                                                                        try {
                                                                            cbl.addInstituition(institution);
                                                                        } catch (InstituitionAlreadyExistException e) {
                                                                            e.getMessage();
                                                                        }
                                                                    }
                                                                    try {
                                                                        Participant p = new cbl.participant.Student(studentName, emailStudent, contactStudent, institution);
                                                                        cbl.getEdition(nameOfEdition).getProject(nameOfProject).addParticipant(p);
                                                                        System.out.println("Participant added");
                                                                    } catch (ParticipantAlreadyInProject | IllegalNumberOfParticipantType e) {
                                                                        e.getMessage();
                                                                    }
                                                                    break;
                                                            }
                                                            break;

                                                        case 6:
                                                            System.out.println("Insert the name of the participant:");
                                                            String participantRemoved = read.nextLine();
                                                            try {
                                                                if (project.getNumberOfParticipants() > 0) {
                                                                    cbl.getEdition(nameOfEdition).getProject(nameOfProject).removeParticipant(participantRemoved);
                                                                }
                                                            } catch (NullPointerException e) {
                                                                System.out.println("The participant does not exist");
                                                            }
                                                            break;
                                                        case 7:
                                                            System.out.println("Insert the name of the participant:");
                                                            String participant = read.nextLine();
                                                            try {
                                                                System.out.println(project.getParticipant(participant).toString());
                                                            } catch (NullPointerException e) {
                                                                System.out.println("The participant does not exist");
                                                            }
                                                            break;
                                                        case 8:
                                                            try {
                                                                System.out.println("Insert the task name: ");
                                                                String TaskName = read.nextLine();

                                                                System.out.println("Insert the year to start: ");
                                                                int startYearTask = readInt(read);

                                                                System.out.println("Insert the month to start: ");
                                                                int startMonthTask = readIntWithLimit(read, 0, 12);

                                                                System.out.println("Insert the day to start: ");
                                                                int startDayTask;
                                                                if (startMonthTask == 1 || startMonthTask == 3 || startMonthTask == 5 || startMonthTask == 7 || startMonthTask == 8) {
                                                                    startDayTask = readIntWithLimit(read, 1, 31);
                                                                } else if (startMonthTask == 2) {
                                                                    if (startYearTask % 4 == 0) {
                                                                        startDayTask = readIntWithLimit(read, 1, 29);
                                                                    } else {
                                                                        startDayTask = readIntWithLimit(read, 1, 28);
                                                                    }
                                                                } else {
                                                                    startDayTask = readIntWithLimit(read, 1, 30);
                                                                }

                                                                System.out.println("Insert the year to end: ");
                                                                int endYearTask = readInt(read);

                                                                System.out.println("Insert the month to end: ");
                                                                int endMonthTask = readIntWithLimit(read, 0, 12);

                                                                System.out.println("Insert the day to end: ");
                                                                int endDayTask;
                                                                if (endMonthTask == 1 || endMonthTask == 3 || endMonthTask == 5 || endMonthTask == 7 || endMonthTask == 8) {
                                                                    endDayTask = readIntWithLimit(read, 1, 31);
                                                                } else if (endMonthTask == 2) {
                                                                    if (endYearTask % 4 == 0) {
                                                                        endDayTask = readIntWithLimit(read, 1, 29);
                                                                    } else {
                                                                        endDayTask = readIntWithLimit(read, 1, 28);
                                                                    }
                                                                } else {
                                                                    endDayTask = readIntWithLimit(read, 1, 30);
                                                                }
                                                                System.out.println("Insert the description of the task:");
                                                                String taskDescription = read.nextLine();

                                                                cbl.getEdition(nameOfEdition).getProject(nameOfProject).addTask(new cbl.project.Task(LocalDate.of(startYearTask, startMonthTask, startDayTask),
                                                                        LocalDate.of(endYearTask, endMonthTask, endDayTask), TaskName, taskDescription));
                                                            } catch (IllegalNumberOfTasks | TaskAlreadyInProject e) {
                                                                e.getMessage();
                                                            }

                                                            break;
                                                        case 9:
                                                            System.out.println("The project is completed: " + project.isCompleted());
                                                            break;
                                                        case 10:
                                                            System.out.println(project.toString());
                                                            break;
                                                        case 11:
                                                            System.out.println("Insert the name of the participant:");
                                                            String participantSearched = read.nextLine();
                                                            try {
                                                                if (project.getNumberOfParticipants() > 0) {
                                                                    project.getParticipant(participantSearched).toString();
                                                                }
                                                            } catch (NullPointerException e) {
                                                                System.out.println("The participant does not exist");
                                                            }
                                                            break;
                                                        case 12:
                                                            System.out.println(cbl.getProjectProgress(edition.getName(), project.getName()));
                                                            break;
                                                        case 13:
                                                            runProjectsMenu = false;
                                                            break;
                                                    }

                                                }
                                            }
                                            System.out.println("The project does not exist");
                                        } else {
                                            System.out.println("The edition does not exist");
                                            runProjectsMenu = false;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Insert the name of the edition:");
                                        String activeEdition = read.nextLine();
                                        cbl.setActiveEdition(activeEdition);
                                        break;
                                    case 4:
                                        System.out.println("Insert the name of the edition:");
                                        String inactiveEdition = read.nextLine();
                                        cbl.setInactiveEdition(inactiveEdition);
                                        break;
                                    case 5:
                                        System.out.println("Insert the name of the edition:");
                                        String closedEdition = read.nextLine();
                                        cbl.setClosedEdition(closedEdition);
                                        break;
                                    case 6:
                                        System.out.println("Insert the name of the edition:");
                                        String canceledEdition = read.nextLine();
                                        cbl.setCanceledEdition(canceledEdition);
                                        break;
                                    case 7:
                                        System.out.println("Editions with missing projects:");
                                        for (ma02_resources.project.Edition editions : cbl.editionsNotCompleted()) {
                                            System.out.println(editions.getName());
                                        }
                                        break;
                                    case 8:
                                        System.out.println("Insert the name of the edition:");
                                        String name = read.nextLine();

                                        String progress = cbl.getEditionProgress(name);
                                        if (progress == null) {
                                            System.out.println("The edition does not exist");
                                        } else {
                                            System.out.println(progress);
                                        }
                                        break;
                                    case 9:
                                        runEditionsMenu = false;
                                        break;
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Insert the name:");
                            String name = read.nextLine();

                            System.out.println("Insert the email:");
                            String email = read.nextLine();

                            System.out.println("Choose the type:\n"
                                    + "[ 0 ] - University\n"
                                    + "[ 1 ] - Company\n"
                                    + "[ 2 ] - NGO\n"
                                    + "[ 3 ] - Other");
                            int typeOption = readIntWithLimit(read, 0, 3);
                            InstituitionType typeFind = Itype(typeOption);

                            System.out.println("Insert the website:");
                            String website = read.nextLine();

                            System.out.println("Insert the description:");
                            String description = read.nextLine();

                            System.out.println("Insert the street where it locates:");
                            String street = read.nextLine();

                            System.out.println("Insert the city where it locates:");
                            String city = read.nextLine();

                            System.out.println("Insert the state where it locates:");
                            String state = read.nextLine();

                            System.out.println("Insert the zip code:");
                            String zipCode = read.nextLine();

                            System.out.println("Insert the country where it locates:");
                            String country = read.nextLine();

                            System.out.println("Insert the phone number:");
                            String phoneNumber = read.nextLine();
                            try {
                                cbl.addInstituition(new cbl.participant.Instituition(name, email, typeFind, new cbl.participant.Contact(street,
                                        city, state, zipCode, country, phoneNumber), website, description));
                            } catch (InstituitionAlreadyExistException e) {
                                System.out.println("Institution already exists");
                            }
                            break;
                        case 4:
                            if (cbl.getNumberOfInstituitions() > 0) {
                                System.out.println("Insert the name of the institution you want to remove:");
                                String nameToRemove = read.nextLine();
                                cbl.removeInstituition(nameToRemove);
                            } else {
                                System.out.println("There are no institutions to remove|");
                            }
                            break;
                        case 5:
                            System.out.println("There are " + cbl.getNumberOfProjects() + " projects across all CBL");
                            break;
                        case 6:
                            System.out.println("Choose the satus:\n"
                                    + "[ 0 ] - Active\n"
                                    + "[ 1 ] - Inactive\n"
                                    + "[ 2 ] - Closed\n"
                                    + "[ 3 ] - Canceled\n");
                            int statusOption = readIntWithLimit(read, 0, 3);
                            Status statusToFind = null;
                            switch (statusOption) {
                                case 0:
                                    statusToFind = Status.ACTIVE;
                                    break;
                                case 1:
                                    statusToFind = Status.INACTIVE;
                                    break;
                                case 2:
                                    statusToFind = Status.CLOSED;
                                    break;
                                case 3:
                                    statusToFind = Status.CANCELED;
                                    break;
                            }
                            System.out.println("Editions with that status:");
                            for (ma02_resources.project.Edition edition : cbl.getEditionsByStatus(statusToFind)) {
                                System.out.println(edition.getName());
                            }
                            break;
                        case 7:
                            System.out.println("Insert the project name: ");
                            String projectName = read.nextLine();

                            System.out.println("Missing tasks:");
                            try {
                                for (Task task : cbl.getMissingTaskFromProjectOfActiveEdition(projectName)) {
                                    System.out.println(task.getTitle());
                                }
                            } catch (NullPointerException ignored) {
                            }
                            break;
                        case 8:
                            System.out.println("Choose the type:\n"
                                    + "[ 0 ] - University\n"
                                    + "[ 1 ] - Company\n"
                                    + "[ 2 ] - NGO\n"
                                    + "[ 3 ] - Other\n");
                            int type = readIntWithLimit(read, 0, 3);
                            InstituitionType typeToFind = Itype(type);
                            System.out.println("Institutions with that type:");
                            try {
                                for (Instituition instituition : cbl.getInstituitionsByType(typeToFind)) {
                                    System.out.println(instituition.getName());
                                }
                            } catch (NullPointerException ignored) {
                            }
                            break;
                        case 9:
                            runMainMenu = false;
                            break;
                    }
                }
            } else {
                run = false;
            }
        }

    }
}
