import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub


        int number_of_sellers;
        int number_of_customers;

        Scanner sc=new Scanner(System.in);

        System.out.println("Number of Customer: ");
        number_of_customers = Integer.parseInt(sc.nextLine());
        System.out.println("Number of Seller: ");
        number_of_sellers = Integer.parseInt(sc.nextLine());


        PriorityQueue number_of_products = new PriorityQueue(number_of_sellers);
        for (int i = 0; i < number_of_sellers; i++) {
            System.out.println("Enter number of products for seller " + i+1);
            int quantity_of_product = Integer.parseInt(sc.nextLine());
            QueueElement seller_product_inf = new QueueElement(i+1,quantity_of_product);
            number_of_products.enqueue(seller_product_inf);
        }


        //print priority Queue
        System.out.println("Remaining quantity per seller: ");
        QueueElement productInf = number_of_products.dequeue();

        PriorityQueue tempQueue = new PriorityQueue(number_of_sellers);

        while(productInf != null)
        {
            tempQueue.enqueue(productInf);
            System.out.println("Seller ID: " + productInf.getData() + " Product Quantity: " + productInf.getPriority());
            productInf = number_of_products.dequeue();

        }

        //find maximum profit
        int profit = 0;
        for (int i = 0; i < number_of_customers; i++) {
            QueueElement x = tempQueue.dequeue();
            profit += x.getPriority();
            QueueElement n = new QueueElement(x.getData(), x.getPriority()-1);
            tempQueue.enqueue(n);
        }

        System.out.println("Profit: " + profit + "*" + "75" + ": " + profit*75 );
    }

}
