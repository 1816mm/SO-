package lab3;

import java.util.HashMap;
import java.util.Map;

public class Deposit {
//    public int maxCapacity;
    public String[] products = new String[]{"Aloe", "Bepanten", "Mezim"};
    public Map<String, Integer> maxCapacity = new HashMap<String, Integer>();

    public int currentCapacity;

    public Map<String, Integer> deposit = new HashMap<String, Integer>();




    public Deposit(int maxValue) {
//        this.maxCapacity = maxValue;
        for(String product: products) deposit.put(product, 5);
        for(String product: products) maxCapacity.put(product, 5);
        currentCapacity = 15;
    }
    
    public synchronized void fillDeposit(String product, int quantity) {
        while (deposit.get(product) + quantity > maxCapacity.get(product)) {
            try {
                System.out.println("Deposit is full!");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        deposit.put(product, deposit.get(product) + quantity);
        System.out.printf("Deposit filled with 1 of %s\n", product);
        notifyAll();
    }
    
    public synchronized void sellProducts(String product, int quantity, String name){
        while(quantity > deposit.get(product)){
            try {
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        deposit.put(product, deposit.get(product) - quantity);
        currentCapacity -= quantity;
        System.out.printf("Consumer %s bought %d %s \n", name,  quantity, product);
        notifyAll();
    }
}
