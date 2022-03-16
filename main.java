package iceCreamDispenser;
import java.text.DecimalFormat;
import java.util.*;

public class main {

		public static void main(String[] args) throws InterruptedException {
		// Welcome text / Discount/Offer
		System.out.println("\n [WELCOME TO KEAN ICE CREAM DISPENSER]\n");
		System.out.println("***[BUY $20 GET 20% OFF Code: ice20]***"
				+ "\n***[BUY $10 GET 10% OFF Code: ice10]***\n***[LIMITED TIME ONLY APR 28th-29th]***");
		 
		//Ask customer type - REGULAR or CUSTOM 
		Scanner reader = new Scanner(System.in);
		System.out.format("\nEnter 1 for Regular, 2 for Custom: ");
		int value = reader.nextInt();
		
		if (value==1) {
			
			// REGULAR_METHOD
			 FLAVOR_MENU();
			 REGULAR_METHOD();
			 double G_TOTAL = SCOOP_SIZE_1();
			 
			 //System.out.println();
			 
			 // ADD_MORE
			 System.out.format("\nAdd more flavor? [Enter 1 to add, 2 to Proceed to checkout] ");
			 int ADD_MORE = reader.nextInt();
			 
			 if(ADD_MORE==1) {
				 
				 REGULAR_METHOD();
				 double PRETAX_TOTAL = (G_TOTAL + SCOOP_SIZE_2());
				 System.out.printf("SUBTOTAL $%.2f\n" , PRETAX_TOTAL); // 2nd Item total so far
				 
				 double GRAND_TOTAL = CHECKOUT(PRETAX_TOTAL);
				 System.out.println("\nProceeding to payment >>>");
				 //System.out.println("Please pay $"+ GRAND_TOTAL);
				 
				 PAYMENT(GRAND_TOTAL);
				 
			 }
			 
			 if (ADD_MORE==2) {
				 
				 //Proceed to checkout
				 double PRETAX_TOTAL = G_TOTAL;
				 double GRAND_TOTAL = CHECKOUT(PRETAX_TOTAL);
				 
				 System.out.println("\nProceeding to payment >>>");
				 //System.out.println("Please pay $"+ GRAND_TOTAL);
				 
				 PAYMENT(GRAND_TOTAL);
				 
			 }
			 
		}
		
			if (value==2) {
				
				// CUSTOM METHOD
				FLAVOR_MENU();
				REGULAR_METHOD();
				double FLAVOR_TOTAL = SCOOP_SIZE_1();
				
				//TOPPING SELECTION
				System.out.format("\nEnter 1 to see Toppings Menu: ");
				int value2 = reader.nextInt();
				
				TOPPING_MENU();
				
				//Add 1st TOPPING
				double TOPP_1 = CUSTOM_METHOD();
				float TOPP_TOTAL = (float) TOPP_1; // 1st TOPPING total
				
				// ADD_MORE_TOPPING 2nd
				System.out.format("\nAdd more topping? [Enter 1 to add, 2 to Proceed to checkout] ");
				int ADD_MORE = reader.nextInt();
				
				if(ADD_MORE==1) {
				
				// Add 2nd TOPPING
				double TOPP_2 = CUSTOM_METHOD();
				TOPP_TOTAL = (float) (TOPP_1+TOPP_2); //2nd TOPPING total
				System.out.printf("SUBTOTAL TOPPING $%.2f\n", TOPP_TOTAL);
				
					// ADD_MORE_TOPPING 3rd
					System.out.format("\nAdd more topping? [Enter 1 to add, 2 to Proceed to checkout] ");
					ADD_MORE = reader.nextInt();
					
					if (ADD_MORE==1) {
						
						// Add 3rd TOPPING
						double TOPP_3 = CUSTOM_METHOD();
						
						TOPP_TOTAL =  (float) (TOPP_1+TOPP_2+TOPP_3); //3nd TOPPING total
						
						System.out.printf("\nSUBTOTAL TOPPING $%.2f\n", TOPP_TOTAL);
					}
				
					else {
						// 2nd TOPPING Total
						System.out.printf("\nSUBTOTAL TOPPING $%.2f\n", TOPP_TOTAL);
					}
				
				}
				
				else {
					// 1st TOPPING Total
					System.out.printf("\nSUBTOTAL TOPPING $%.2f\n", TOPP_TOTAL);
				}
				
				
				//SUBTOTAL
				System.out.printf("SUBTOTAL FLAVOR $%.2f\n" , FLAVOR_TOTAL);
				float SUBTOTAL = (float) (TOPP_TOTAL+FLAVOR_TOTAL);
				System.out.printf("TOTAL $%.2f\n" , SUBTOTAL);
				double PRETAX_TOTAL = SUBTOTAL;
				
				// Checkout
				double GRAND_TOTAL = CHECKOUT(PRETAX_TOTAL);
				
				// Payment
				System.out.println("\nProceeding to payment >>>");
				PAYMENT(GRAND_TOTAL);
				
		}
			
			// ***END OF PROGRAM*** //
		
	} 
		public static double SCOOP_SIZE_1() {
		
			//SCOOP SIZE AND PRICE
			Scanner reader = new Scanner(System.in);
			System.out.format("Enter scoop size [1 for Small, 2 for Medium, 3 for Large]: ");
			double size1 = reader.nextDouble();

			if (size1 == 1) {
			size1 = (double) 2.50;
			
			System.out.format("Selected size SMALL - $%.2f\n", size1);
			}

			else if (size1 == 2) {
			size1 = (double) 3.25;
			System.out.format("Selected size MEDIUM - $%.2f\n", size1);
			
			}

			else if (size1 == 3) {
			size1 = (double) 4.00;
			System.out.format("Selected size LARGE - $%.2f\n", size1);
			
			}
			
			// ENTER QUANTITY
			System.out.format("Enter quantity: ");
			int qty = reader.nextInt();

			double SUBTOTAL_1 = qty * size1;
			
			System.out.printf("SUBTOTAL $%.2f\n", SUBTOTAL_1);
			
			return SUBTOTAL_1;
			
		}
		
		public static double SCOOP_SIZE_2() {
			
			//Scoop size
			Scanner reader = new Scanner(System.in);
			System.out.println("Enter scoop size [1 for Small, 2 for Medium, 3 for Large]: ");
			double size2 = reader.nextDouble();

			if (size2 == 1) {
			size2 = (double) 2.50;
					
			System.out.printf("Selected size SMALL - $%.2f\n", size2);
			}

			else if (size2== 2) {
			size2 = (double) 3.25;
			System.out.printf("Selected size MEDIUM - $%.2f\n", size2);
					
			}

			else if (size2== 3) {
			size2 = (double) 4.00;
			System.out.printf("Selected size LARGE - $%.2f\n", size2);
					
			}
			
			// ENTER QUANTITY
			System.out.format("Enter quantity: ");
			int qty = reader.nextInt();

			double SUBTOTAL_2 = qty * size2;
					
			//System.out.println("Your total so far is $"+ SUBTOTAL_2);
			
			return SUBTOTAL_2;
					
		}
		
		public static double CHECKOUT(double PRETAX_TOTAL) {

			double NJ_TAX = 0.0625;
			double DIS_10 = 0.10;
			double DIS_20 = 0.20;
			DecimalFormat df2 = new DecimalFormat("0.00");
			
			Scanner reader = new Scanner(System.in);
			System.out.format("\nWould you like to add discount? [1 to add, 2 to skip] ");
			int value = reader.nextInt();
			
			if (value==1) {
				double PRE_TOTAL = PRETAX_TOTAL;
				// Apply Discount
				System.out.format("\nEnter discount code: ");
				String CODE = reader.next();
				
				if (CODE.equals("ice20") && PRETAX_TOTAL>=20) {
					float DISCOUNT = (float) (PRE_TOTAL * DIS_20); //newly added
					System.out.printf("\nCongratz! You got $%.2f OFF\n" , DISCOUNT); //decimal OK
					//PRETAX_TOTAL = (double) DISCOUNT;
					PRE_TOTAL = PRETAX_TOTAL - DISCOUNT;
				}
				
				else if (CODE.equals("ice10") && PRETAX_TOTAL>=10) {
					float DISCOUNT = (float) (PRE_TOTAL * DIS_10);
					System.out.printf("\nCongratz! You got $%.2f OFF\n" , DISCOUNT ); // decimal OK
					//PRETAX_TOTAL = (double) DISCOUNT;
					PRE_TOTAL = PRETAX_TOTAL - DISCOUNT;
				}
				
				else {
					System.out.printf("\nSorry! Your selection do no meet discount threshold.\n");
					
				}
				
				// APPLY TAX (decimal OK)
				double POSTDISCOUNT_TOTAL = PRE_TOTAL;
										
				float TAX = (float) (POSTDISCOUNT_TOTAL * NJ_TAX);
				System.out.println("TAX 6.625% $" + df2.format(TAX));
										
				float GRAND_TOTAL = (float) (POSTDISCOUNT_TOTAL + TAX);
				System.out.println("GRAND TOTAL $" + df2.format(GRAND_TOTAL));      // Grand With Discount Applied
									
				return GRAND_TOTAL;
			}
			
			
			else {
			// APPLY TAX (decimal OK)
			double POSTTAX_TOTAL= PRETAX_TOTAL;
									
			float TAX = (float) (POSTTAX_TOTAL * NJ_TAX);
			System.out.println("TAX 6.625% $" + df2.format(TAX));
									
			float GRAND_TOTAL = (float) (POSTTAX_TOTAL + TAX);
			System.out.println("GRAND TOTAL $" + df2.format(GRAND_TOTAL)); // Grand Without Discount 
					
			return GRAND_TOTAL; 
			}
			
		}
		
		public static double PAYMENT(double GRAND_TOTAL) throws InterruptedException {
			
			// PAYMENT TYPE
			Scanner reader = new Scanner(System.in);
			System.out.format("\nPlease select payment method [1 for Card, 2 for Cash, 3 for Apple Pay] ");
			int value = reader.nextInt();
			
			if(value==1) {
				System.out.println("Insert Card");
				Thread.sleep(3000); // 3000ms = 3s
				System.out.println("Payment processing >>>"); 
				Thread.sleep(2000); // 2000ms = 2s
				System.out.println("Payment approved! Remove Card");
				
				
			}
			
			if(value==2) {
				System.out.println("Insert Cash");
				Thread.sleep(4000); // 4000ms = 4s
				System.out.println("Payment processing >>>"); 
				Thread.sleep(2000); // 2000ms = 2s
				System.out.println("Payment processed!");
						
			}
			
			if(value==3) {
				System.out.println("Hold your phone near the chip reader");
				Thread.sleep(4000); // 4000ms = 4s
				System.out.println("Payment processing >>>"); 
				Thread.sleep(2000); // 2000ms = 2s
				System.out.println("Payment processed!");
				
			}
			
			//System.out.println("\nCustomer receipt");
			//System.out.println("================");
			Thread.sleep(3000); // 2000ms = 2s
			System.out.println("\n\t[Dispensed]\n\nTHANK YOU! FOR YOUR PURCHASE\n\tENJOY :D");
			
			
			
			return 0;
			
		}
		
		public static double REGULAR_METHOD() {
			
			Scanner reader = new Scanner(System.in);
			System.out.format("\nEnter flavor: ");
			int FLAVOR_1 = reader.nextInt();
			
			// SELECT FLAVOR
			if(FLAVOR_1==1) {
				System.out.println("Selected flavor Vanilla"+"\t- 75 kCal per scoop");
				}
			if (FLAVOR_1==2) {
				System.out.println("Selected flavor Chocolate"+" - 95 kCal per scoop");
				}
			if (FLAVOR_1==3) {
				System.out.println("Selected flavor Cookies N' Cream"+" - 95 kCal per scoop");
			}
			if(FLAVOR_1==4) {
				System.out.println("Selected flavor Mint Chocolate Chip"+" - 85 kCal per scoop");
				}
			if (FLAVOR_1==5) {
				System.out.println("Selected flavor Cookie Dough"+" - 75 kCal per scoop");
				}
			if (FLAVOR_1==6) {
				System.out.println("Selected flavor Rum Raisin"+" - 75 kCal per scoop");
			}
			if(FLAVOR_1==7) {
				System.out.println("Selected flavor Strawberry"+" - 65 kCal per scoop");
				}
			if (FLAVOR_1==8) {
				System.out.println("Selected flavor Pistachio"+" - 75 kCal per scoop");
				}
			if (FLAVOR_1==9) {
				System.out.println("Selected flavor Mango"+" - 85 kCal per scoop");
			}
			if (FLAVOR_1==10) {
				System.out.println("Selected flavor Bubblegum"+" - 65 kCal per scoop");
			}
			return FLAVOR_1;
				
		}
		
		public static double CUSTOM_METHOD() {
			
			Scanner reader = new Scanner(System.in);
			System.out.format("\nEnter topping [3 MAX] ");
			double TOPPING_1 = reader.nextInt();
			double KCAL_1;
			
			// SELECT FLAVOR
			if(TOPPING_1==1) {
				TOPPING_1 = (double) 1.25;  KCAL_1 = 25; 
				System.out.printf("Selected topping Sprinkles $%.2f - 25 kCal\n", TOPPING_1);
				}
			if (TOPPING_1==2) {
				TOPPING_1 = (double) 1.50; KCAL_1 = 35;
				System.out.printf("Selected topping Chocochip $%.2f - 35 kCal\n", TOPPING_1);
				}
			if (TOPPING_1==3) {
				TOPPING_1 = (double) 1.75; KCAL_1 = 40;
				System.out.printf("Selected topping M&M $%.2f - 40 kCal\n", TOPPING_1);
			}
			if(TOPPING_1==4) {
				TOPPING_1 = (double) 1.25; KCAL_1 = 25;
				System.out.printf("Selected topping Blueberry $%.2f - 25 kCal\n", TOPPING_1);
				}
			if (TOPPING_1==5) {
				TOPPING_1 = (double) 1.50; KCAL_1 = 35;
				System.out.printf("Selected topping Cherry $%.2f - 35 kCal\n", TOPPING_1);
				}
			if (TOPPING_1==6) {
				TOPPING_1 = (double) 2.00; KCAL_1 = 40;
				System.out.printf("Selected topping Mixed Fruit Syrup $%.2f - 40 kCal\n", TOPPING_1);
			}
			if(TOPPING_1==7) {
				TOPPING_1 = (double) 1.75; KCAL_1 = 30;
				System.out.printf("Selected topping Strawberry Syrup $%.2f - 30 kCal\n", TOPPING_1);
				}
			if (TOPPING_1==8) {
				TOPPING_1 = (double) 2.00; KCAL_1 = 40;
				System.out.printf("Selected topping Caramel Syrup $%.2f - 40 kCal\n", TOPPING_1);
				}
			if (TOPPING_1==9) {
				TOPPING_1 = (double) 1.50; KCAL_1 = 30;
				System.out.printf("Selected topping Raspberry Syrup $%.2f - 30 kCal per scoop\n", TOPPING_1);
			}
			if (TOPPING_1==10) {
				TOPPING_1 = (double) 1.75; KCAL_1 = 35;
				System.out.printf("Selected topping White Chocolate $%.2f - 35 kCal\n", TOPPING_1);
				
				//return KCAL_1; //returned 2nd value of this method
			}
			return (TOPPING_1);
			
		}
		
		public static void FLAVOR_MENU() {
			
			//Menu Header
			//System.out.printf("\n\t\t\t\t\tFlavor Menu");
			System.out.printf("\n------------------------------------------------------------------------------------------------");
			String[] flavors = {" 1. Vanilla", " 2. Chocolate", " 3. Cookies N' Cream", " 4. Mint Chocolate Chip",
					" 5. Cookie Dough", " 6. Rum Raisin", " 7. Strawberry", " 8. Pistachio", " 9. Mango", "10. Bubblegum"};
			String[] scoop = {"$2.50", "$3.25", "$4.00"};
			String[] calorie = {"65 kcal", "75 kcal", "85 kcal", "95 kcal"};
			
			//Table
			System.out.printf("\nFlavors             Single Scoop(S)    Double Scoop(M)    Tripple Scoop(L)    Calories per scoop");
			System.out.printf("\n----------------    ---------------    ---------------    ----------------    ------------------\n");
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[0], scoop[0], scoop[1], scoop[2], calorie[1]);
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[1], scoop[0], scoop[1], scoop[2], calorie[3]);
			System.out.printf("%-10s %14s %18s %19s %21s\n", flavors[2], scoop[0], scoop[1], scoop[2], calorie[3]);
			System.out.printf("%-10s %11s %18s %19s %21s\n", flavors[3], scoop[0], scoop[1], scoop[2], calorie[2]);
			System.out.printf("%-14s %18s %18s %19s %21s\n", flavors[4], scoop[0], scoop[1], scoop[2], calorie[1]);
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[5], scoop[0], scoop[1], scoop[2], calorie[1]);
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[6], scoop[0], scoop[1], scoop[2], calorie[0]);
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[7], scoop[0], scoop[1], scoop[2], calorie[1]);
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[8], scoop[0], scoop[1], scoop[2], calorie[2]);
			System.out.printf("%-14s %20s %18s %19s %21s\n", flavors[9], scoop[0], scoop[1], scoop[2], calorie[0]);
			
		}
		
		public static void TOPPING_MENU() {
			//Menu Header
			//System.out.printf("\n\t\t\tToppings Menu");
			System.out.printf("\n--------------------------------------------------------");
			String[] toppings = {" 1. Sprinkles", " 2. Chocochip", " 3. M&M", " 4. Blueberry",
			" 5. Cherry", " 6. Mixed Fruit Syrup", " 7. Strawberry Syrup", " 8. Caramel Syrup",
			" 9. Raspberry Syrup", "10. White Chocolate"};
			String[] scoop = {"$1.25", "$1.50", "$1.75", "$2.00"};
			String[] calorie = {"25 kcal", "30 kcal", "35 kcal", "40 kcal"};

			System.out.printf("\nToppings                  Scoop       Calories per scoop");
			System.out.printf("\n----------------          -----       ------------------\n");
			System.out.printf("%-14s %16s %24s\n", toppings[0], scoop[0], calorie[0]);
			System.out.printf("%-14s %16s %24s\n", toppings[1], scoop[1], calorie[2]);
			System.out.printf("%-10s %20s %24s\n", toppings[2], scoop[2], calorie[3]);
			System.out.printf("%-10s %17s %24s\n", toppings[3], scoop[0], calorie[0]);
			System.out.printf("%-14s %16s %24s\n", toppings[4], scoop[1], calorie[2]);
			System.out.printf("%-14s %9s %24s\n",  toppings[5], scoop[3], calorie[3]);
			System.out.printf("%-14s %10s %24s\n", toppings[6], scoop[2], calorie[1]);
			System.out.printf("%-14s %13s %24s\n", toppings[7], scoop[3], calorie[3]);
			System.out.printf("%-14s %11s %24s\n", toppings[8], scoop[1], calorie[1]);
			System.out.printf("%-14s %11s %24s\n", toppings[9], scoop[2], calorie[2]);
			
		}
		
}
