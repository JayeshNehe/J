interface CreditCardInterface
{
    void viewCreditAmount();
    void useCard(double amount);
    void payCredit(double amount);
    void increaseLimit(double amount);
}

class SilverCardCustomer implements CreditCardInterface
{
    String name;
    String cardNumber;
    double creditAmount;
    double creditLimit;

    public SilverCardCustomer(String name, String cardNumber)
    {
        this.name = name;
        this.cardNumber = cardNumber;
        this.creditAmount = 0;
        this.creditLimit = 50000;
    }

    @Override
    public void viewCreditAmount()
    {
        System.out.println("Credit Amount for " + name + ": " + creditAmount);
    }

    @Override
    public void useCard(double amount)
    {
        if (creditAmount + amount <= creditLimit)
        {
            creditAmount += amount;
            System.out.println("Transaction Successful. Credit Amount increased by " + amount);
        }
        else
        {
            System.out.println("Transaction Failed. Exceeds Credit Limit.");
        }
    }

    @Override
    public void payCredit(double amount)
    {
        if (amount <= creditAmount)
        {
            creditAmount -= amount;
            System.out.println("Payment Successful. Credit Amount reduced by " + amount);
        }
        else
        {
            System.out.println("Payment Failed. Insufficient Credit Amount.");
        }
    }

    @Override
    public void increaseLimit(double amount)
    {
        System.out.println("SilverCardCustomer cannot increase the credit limit.");
    }
}

class GoldCardCustomer extends SilverCardCustomer
{
    private int limitIncreaseCount;

    public GoldCardCustomer(String name, String cardNumber)
    {
        super(name, cardNumber);
        this.creditLimit = 100000;
        this.limitIncreaseCount = 0;
    }

    @Override
    public void increaseLimit(double amount)
    {
        if (limitIncreaseCount < 3 && creditLimit + amount <= 150000)
        {
            creditLimit += amount;
            limitIncreaseCount++;
            System.out.println("Credit Limit Increased for GoldCardCustomer by " + amount);
        }
        else
        {
            System.out.println("Limit Increase Failed. Exceeded Maximum Increase or Limit Reached.");
        }
    }
}

public class creditCard
{
    public static void main(String[] args)
    {
        SilverCardCustomer silverCustomer = new SilverCardCustomer("John", "1234567890123456");
        GoldCardCustomer goldCustomer = new GoldCardCustomer("Jane", "9876543210987654");

        silverCustomer.viewCreditAmount();
        silverCustomer.useCard(20000);
        silverCustomer.viewCreditAmount();
        silverCustomer.payCredit(10000);
        silverCustomer.viewCreditAmount();
        silverCustomer.increaseLimit(5000); // This should display a message saying SilverCardCustomer cannot increase the limit.

        goldCustomer.viewCreditAmount();
        goldCustomer.useCard(80000);
        goldCustomer.viewCreditAmount();
        goldCustomer.increaseLimit(10000);
        goldCustomer.viewCreditAmount();
        goldCustomer.increaseLimit(6000); // This should display a message saying Limit Increase Failed.
        goldCustomer.increaseLimit(4000);
        goldCustomer.viewCreditAmount();
    }
}