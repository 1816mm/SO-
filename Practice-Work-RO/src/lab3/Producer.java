package lab3;

public class Producer extends Thread{
    private String name = "";

    private Deposit deposit;

    private String product;

    public Producer(String name, Deposit deposit, String product){
        this.name = name;
        this.deposit = deposit;
        this.product = product;
    }

    public void run() {
        System.out.printf("Producer %s started production!\n", name);
        produce();
    }

    private void produce() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread was interrupted. Handle the interruption gracefully.\n");
        }

        deposit.fillDeposit(product, 1);

        produce();

    }
}