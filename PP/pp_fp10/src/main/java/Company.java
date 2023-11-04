public abstract class Company {
    private String name;
    private int vatNumber;

    public Company(String name, int vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(int vatNumber) {
        this.vatNumber = vatNumber;
    }
    
    
}
