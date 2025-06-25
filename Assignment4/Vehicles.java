import java.util.*;

class Vehicle
{
    String company;
    double price;

    Vehicle()
    {
        company = "";
        price = 0;
    }

    Vehicle(String company, double price)
    {
        this.company = company;
        this.price = price;
    }

    public void display()
    {
        System.out.println("\nCompany of Vehicle: " +company);
        System.out.println("Price of Vehicle: " +price);
    }
}

class LightMotorVehicle extends Vehicle
{
    int mileage;

    LightMotorVehicle()
    {
        super();
        mileage = 0;
    }

    LightMotorVehicle(String company, double price, int mileage)
    {
        super(company, mileage);
        this.mileage = mileage;
    }

    public void display()
    {
        super.display();
        System.out.println("Mileage: " +mileage);
    }
}

class HeavyMotorVehicle extends Vehicle
{
    int capacity_in_tons;

    HeavyMotorVehicle()
    {
        super();
        capacity_in_tons = 0;
    }

    HeavyMotorVehicle(String company, double price, int capacity_in_tons)
    {
        super(company, price);
        this.capacity_in_tons = capacity_in_tons;
    }

    public void display()
    {
        super.display();
        System.out.println("Capacity in tons: " +capacity_in_tons);
    }
}

public class Vehicles
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        Vehicle[] vh = new Vehicle[n];

        for(int i=0; i<n; i++)
        {
            System.out.print("Enter Vehicle type (1: for Light-Motor-Vehicle, 2: for Heavy-Motor-Vehicle): ");
            int vehicleType = sc.nextInt();

            System.out.print("Enter Company of Vehicle: ");
            String company = sc.next();

            System.out.print("Enter Price of Vehicle: ");
            double price = sc.nextInt();

            if(vehicleType == 1)
            {
                System.out.print("Enter Vehicle mileage: ");
                int mileage = sc.nextInt();

                vh[i] = new LightMotorVehicle(company, price, mileage);
            }
            else if(vehicleType == 2)
            {
                System.out.print("Enter Vehicle Capacity-in-tons: ");
                int capacity_in_tons = sc.nextInt();

                vh[i] = new HeavyMotorVehicle(company, price, capacity_in_tons);
            }
            else
            {
                System.out.println("Invalid choice!");
                return;
            }
        }

        System.out.println("\nDetails of Vehicle: ");
        for(int i=0; i<n; i++)
        {
            vh[i].display();
        }
    }
}