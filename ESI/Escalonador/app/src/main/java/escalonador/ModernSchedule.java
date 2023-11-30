package escalonador;

public class ModernSchedule {
    private Hour[] hours;

    public ModernSchedule(int numberOfHours) {
        this.hours = new Hour[numberOfHours];

        for(int i = 0; i < numberOfHours; i++) {
            this.hours[i] = new Hour();
            this.hours[i].setRequiredNumber(0);
            this.hours[i].setWorkingEmployees(new String[0]);
        }
    }

    public Hour readSchedule(int hourIndex) {
        return this.hours[hourIndex];
    }

    public void setRequiredNumber(int minHourIndex, int maxHourIndex, int requiredNumber) {
        for(int i = minHourIndex; i <= maxHourIndex; i++) {
            this.hours[i].setRequiredNumber(requiredNumber);
        }
    }

    public boolean addWorkingPeriod(String employeeName, int minHourIndex, int maxHourIndex) {
        if (minHourIndex >= 0 && maxHourIndex < this.hours.length) {
            int i;
            for(i = minHourIndex; i <= maxHourIndex; ++i) {
                for(int j = 0; j < this.hours[i].getWorkingEmployees().length; ++j) {
                    if (this.hours[i].getWorkingEmployees()[j].equals(employeeName)) {
                        return false;
                    }
                }

                if (this.hours[i].getRequiredNumber() == this.hours[i].getWorkingEmployees().length) {
                    return false;
                }
            }


            for(i = minHourIndex; i <= maxHourIndex; ++i) {
                String[] newWorkingEmployees = new String[this.hours[i].getWorkingEmployees().length + 1];
                for(int j = 0; j < this.hours[i].getWorkingEmployees().length; ++j) {
                    newWorkingEmployees[j] = this.hours[i].getWorkingEmployees()[j];
                }
                newWorkingEmployees[this.hours[i].getWorkingEmployees().length] = employeeName;
                this.hours[i].setWorkingEmployees(newWorkingEmployees);
            }

            return true;
        }else {
            return false;
        }
    }

    public String[] workingEmployees(int minHourIndex, int maxHourIndex) {
        String[] workingEmployees = new String[this.hours[minHourIndex].getWorkingEmployees().length + this.hours[maxHourIndex].getWorkingEmployees().length];
        
        int i = 0;
        int k, j;

        for(j = 0; j < this.hours[minHourIndex].getWorkingEmployees().length; ++j) {
            for (k = 0; k < i && !workingEmployees[k].equals(this.hours[minHourIndex].getWorkingEmployees()[j]); ++k) {}

            if (k == i) {
                workingEmployees[i++] = this.hours[minHourIndex].getWorkingEmployees()[j];
            }
        }

        for(j = 0; j < this.hours[maxHourIndex].getWorkingEmployees().length; ++j) {
            for(k = 0; k < i && !workingEmployees[k].equals(this.hours[maxHourIndex].workingEmployees[j]); ++k) {

            }

            if (k == i) {
                workingEmployees[i++] = this.hours[maxHourIndex].getWorkingEmployees()[j];
            }
        }

        String[] employess = new String[i];

        for(k = 0; k < i; ++k) {
            employess[k] = workingEmployees[k];
        }

        return employess;
    }


    public int nextIncomplete(int hourIndex) {
        for(int i = hourIndex; i < this.hours.length; ++i) {
            if (this.hours[i].getRequiredNumber() > this.hours[i].getWorkingEmployees().length) {
                return i;
            }
        }

        return -1;
    }
    
    public class Hour {
        private int requiredNumber;
        private String[] workingEmployees;

        public Hour() {
        }
        public Hour(int requiredNumber, String[] workingEmployees) {
            this.requiredNumber = requiredNumber;
            this.workingEmployees = workingEmployees;
        }
        public void setRequiredNumber(int requiredNumber) {
            this.requiredNumber = requiredNumber;
        }
        public int getRequiredNumber() {
            return requiredNumber;
        }
        public void setWorkingEmployees(String[] workingEmployees) {
            this.workingEmployees = workingEmployees;
        }
        public String[] getWorkingEmployees() {
            return workingEmployees;
        }
    }
}

