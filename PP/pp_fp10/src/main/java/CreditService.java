public interface CreditService {
    public double getAnnualRate();
    public void setAnnualRate(double r);
    public double computemonthyPayment(double ammount, int months);
}
