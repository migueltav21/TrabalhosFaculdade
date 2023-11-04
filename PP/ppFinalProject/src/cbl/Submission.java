package cbl;
public class Submission {

    private int changed_at;
    private boolean submited;
    
    public Submission() {
    }

    public int getChanged_at() {
        return changed_at;
    }

    private void setChanged_at(int changed_at) {
        this.changed_at = changed_at;
    }

    public boolean isSubmited() {
        return submited;
    }

    public void setSubmited(boolean submited, int submited_at) {
        this.submited = submited;
        setChanged_at(submited_at);
    }
}
