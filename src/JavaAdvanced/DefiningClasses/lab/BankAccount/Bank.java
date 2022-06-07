package JavaAdvanced.DefiningClasses.lab.BankAccount;

public class Bank {
    private int nextId = 1;
    private int id;
    private double balance;
    private double interestRate = 0.02;


    public Bank() {
        this.id = nextId;
        nextId++;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    double getInterestRate(int years) {
        return this.interestRate * years * this.balance;
    }
}
