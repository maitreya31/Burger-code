import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
    {
    	//Initialisations

			new Helper().detailsAll();
	    	Scanner sc= new Scanner (System.in);
	    	System.out.println("Choose the Burger Type: \n1.Standard Burger\n2.Healthy Burger\n3.Deluxe Burger");
	    	int burgerType=sc.nextInt();
	    	Hamburger standard= new Hamburger();
	    	Healthy healthy= new Healthy();
	    	double totalPrice= 0.0;

    	if (burgerType==1)
    	{
    		new Helper().detailsStandard();

				System.out.println("Enter 1 for lettuce, 0 for without.");
				int lettuce= sc.nextInt();
				System.out.println("Enter 1 for tomato, 0 for without.");
				int tomato= sc.nextInt();
				System.out.println("Enter 1 for carrots, 0 for without.");
				int carrots= sc.nextInt();
				System.out.println("Enter 1 for cheese, 0 for without.");
				int cheese= sc.nextInt();

				standard= new Hamburger(lettuce, tomato, carrots, cheese);
				standard.printPrice();
				totalPrice=standard.getPrice();
			}


    	

    	if (burgerType==2)
    	{
    		new Helper().detailsHealthy();
				System.out.println("Enter 1 for lettuce, 0 for without.");
				int lettuce= sc.nextInt();
				System.out.println("Enter 1 for tomato, 0 for without.");
				int tomato= sc.nextInt();
				System.out.println("Enter 1 for carrots, 0 for without.");
				int carrots= sc.nextInt();
				System.out.println("Enter 1 for cheese, 0 for without.");
				int cheese= sc.nextInt();
				System.out.println("Enter 1 for cucumber, 0 for without.");
				int cucumber= sc.nextInt();
				System.out.println("Enter 1 for extra meat, 0 for without.");
				int extraMeat= sc.nextInt();
				
				healthy= new Healthy(lettuce, tomato, carrots, cheese, cucumber, extraMeat);
				healthy.printPrice();
				totalPrice=healthy.getPrice();
			}
		if (burgerType==3)
		{
			new Helper().detailsDeluxe();
			System.out.println("You have bought deluxe hamburgers.");
			totalPrice+= ( new Deluxe().getPrice());
		}

		bill(standard,healthy,totalPrice,burgerType);
    }

    public static void bill (Hamburger standard, Healthy healthy, double totalPrice,int burgerType)
	{
		System.out.println("\t\t\tBILL\n");
		System.out.println("\tItems\t\t\t\t\t\tPrice");
		
		if(burgerType==1) {
			System.out.println("\n\tSTANDARD\t\t\t");
			System.out.println("\tStandard Hamburger \t\t\t\t" + standard.getBasePrice());
			
			if (standard.getExtraPrice() != 0.0) 
			{
				System.out.println("\t\tAdditionals");

				if(standard.getCheese() == 1)
					System.out.println("\t\tCheese\t\t\t\t\t" + standard.PriceCheese());
				if(standard.getCarrots() == 1)
					System.out.println("\t\tCarrots\t\t\t\t\t" + standard.PriceCarrots());
				if(standard.getTomato() == 1)
					System.out.println("\t\tTomato\t\t\t\t\t" + standard.PriceTomato());
			    if(standard.getLettuce() == 1)
					System.out.println("\t\tLettuce\t\t\t\t\t" + standard.PriceLettuce());
				System.out.println("\t\t\t\t\t\t\t" + standard.getPrice());
			}
		}
			
		

		if (burgerType==2)
		{
			System.out.println("\n\tHEALTHY\t\t\t");

			System.out.println("\tHealthy Hamburger \t\t\t\t" + healthy.getBasePrice());
			
			if (healthy.getExtraPrice() != 0.0) 
			{
				System.out.println("\t\tAdditionals");

				if(healthy.getCheese() == 1)
					System.out.println("\t\tCheese\t\t\t\t\t" + healthy.PriceCheese());
				if(healthy.getCarrots() == 1)
					System.out.println("\t\tCarrots\t\t\t\t\t" + healthy.PriceCarrots());
				if(healthy.getTomato() == 1)
					System.out.println("\t\tTomato\t\t\t\t\t" + healthy.PriceTomato());
			    if(healthy.getLettuce() == 1)
					System.out.println("\t\tLettuce\t\t\t\t\t" + healthy.PriceLettuce());
				if(healthy.getCucumber() == 1)
					System.out.println("\t\tCucumber\t\t\t\t" + healthy.PriceCucumber());
				if(healthy.getEgg() == 1)
					System.out.println("\t\tEgg\t\t\t\t\t" + healthy.PriceEgg());
				System.out.println("\t\t\t\t\t\t\t" + healthy.getPrice());
			}
		}

		if (burgerType==3)
		{
			System.out.println("\n\tDELUXE\t\t\t\t\t\t" + (new Deluxe().getPrice()));
		}
		System.out.println("\tTOTAL PRICE= Rs." + totalPrice);
	}
}

class Helper
{	
	Hamburger dummy_ham= new Hamburger();
	Healthy dummy_healthy= new Healthy();
	Deluxe dummy_deluxe= new Deluxe();

	public void detailsAll()
	{
		detailsStandard();
		detailsHealthy();
		detailsDeluxe();
	}
	public void detailsStandard ()
	{
		System.out.println("Standard Hamburger contains basic bread roll and a single slice of meat.");
		System.out.println("Base price is Rs." + dummy_ham.getBasePrice() + "(Bread is Rs." + dummy_ham.PriceBread() + ", Meat is Rs." + dummy_ham.PriceMeat() + ")");
		System.out.println("Additionals include lettuce(Rs."+ dummy_ham.PriceLettuce()+ "), tomato(Rs." + dummy_ham.PriceTomato() + "), carrots(Rs." + dummy_ham.PriceCarrots() + ") and cheese(Rs." + dummy_ham.PriceCheese() + ").");
	}

	public void detailsHealthy()
	{
		System.out.println("Healthy Hamburger contains Brown rye bread roll and a single slice of meat.");
		System.out.println("Base price is Rs" + dummy_healthy.getBasePrice() + " (Bread is Rs" + dummy_healthy.PriceBread() + ", Meat is Rs" + dummy_healthy.PriceMeat() + ")");
		System.out.println("Additionals include lettuce(Rs."+ dummy_ham.PriceLettuce()+ "), tomato(Rs." + dummy_ham.PriceTomato() + "), carrots(Rs." + dummy_ham.PriceCarrots() + "), cheese(Rs." + dummy_ham.PriceCheese() + "), cucumber(Rs." + dummy_healthy.PriceCucumber() + ") and egg (Rs." + dummy_healthy.PriceEgg() + "). ");
	}
	
	public void detailsDeluxe()
	{
		System.out.println("Deluxe hamburger comes with Standard Hamburger containing basic bread roll and a single slice of meat, along with chips and drinks.");
		System.out.println("Standard Hamburger contains basic bread roll and a single slice of meat.");
		System.out.println("Base price of standard hamburger is Rs." + dummy_ham.getBasePrice() + "(Bread is Rs." + dummy_ham.PriceBread() + ", Meat is Rs." + dummy_ham.PriceMeat() + ")");
		System.out.println("Total Deluxe hamburger price is Rs." + dummy_deluxe.getPrice() + " (Bread is Rs." + dummy_ham.PriceBread() + ", Meat is Rs." + dummy_ham.PriceMeat() + ", along with chips (Rs." + dummy_deluxe.PriceChips() + ") and drinks (Rs." + dummy_deluxe.PriceDrinks() + ")." );
	}
}	