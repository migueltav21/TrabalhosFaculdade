package cbl;

public class Task {
    private String title;
    private String description;
    private int start_at;
    private int duration;
    private Submission submission;

    public Task(String title, String description, int start_at, int duration) {
        this.title = title;
        this.description = description;
        this.start_at = start_at;
        this.duration = duration;
        submission = new Submission();
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStart_at() {
        return start_at;
    }

    public void setStart_at(int start_at) {
        this.start_at = start_at;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}