package lab3;

public class Consumer extends Thread {


    public String name;
    public String product;
    public int productNeeded;

    private Deposit deposit;

    public void run() {
        System.out.printf("Consumer %s started trade", name);
        startSelfTrade();
    }

    public Consumer(String name, Deposit deposit, String product, int productNeeded){
        this.name = name;
        this.deposit = deposit;
        this.product = product;
        this.productNeeded = productNeeded;
    }

    public void startSelfTrade() {
        deposit.sellProducts(product, 1, name);
        productNeeded -= 1;
        if(productNeeded == 0) {
            System.out.printf("Consumer %s bought enough products\n", name);
            this.interrupt();
            return;
        };
        startSelfTrade();
    }
}