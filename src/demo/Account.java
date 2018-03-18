package demo;

public class Account {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized boolean withdraw(int amount){
        if(this.balance >= amount){
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized void deposit(int amount){
        this.balance += amount;
    }
}
