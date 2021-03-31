import java.util.Scanner;

class OutofRangeException extends RuntimeException{

    String message;
    OutofRangeException(String message)
    {
        this.message=message;
    }
    public String toString()
    {
        return("OutofRangeException Occured"+message);

    }
}

class Account {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String Account_holder;
        int Account_number;
        float transaction_amount;
        String type_of_transaction;
        System.out.print("enter name of account holder: ");
        String a = sc.nextLine();
        System.out.print("enter account number: ");
        int b = sc.nextInt();
        System.out.print("enter type of transaction (NEFT/RTGF): ");
        String c = sc.next();

        System.out.print("enter transaction amount: ");
        double d = sc.nextDouble();
        if (c == "RTGF") {
            try {
                if (d > 200000 && d < 1000000) {
                    System.out.println("Transaction successful");
                }
                throw new OutofRangeException("transaction amount is out of limit");
            } catch (OutofRangeException e) {
                e.printStackTrace();
            }
        }
        if (c == "NEFT") {
            try {
                if (d < 1 && d > 1000000) {
                    System.out.println("Transaction successful");
                }
                throw new OutofRangeException("transaction amount is out of limit");
            } catch (OutofRangeException e) {
                e.printStackTrace();
            }
        }
    }
}