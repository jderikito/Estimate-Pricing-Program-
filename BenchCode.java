import java.util.Scanner;
public class BenchCode
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("What Do You Want To Do?: ");
		System.out.println("- Get sqft");
		System.out.println("- Get price");
		String choice1 = scan.next();
		String choice2 = scan.next();
		double price = 0;
		if((choice1.equals("Get") || choice1.equals("get")) && choice2.equalsIgnoreCase("sqft"))
		{
			System.out.println("What are you trying to measure?: ");
			System.out.println("- Estimate");
			System.out.println("- Remnant");
			System.out.println("- Stairs");
			double totalArea = 0;
			String choiceMeasure = scan.next();
			if(choiceMeasure.equals("estimate") || choiceMeasure.equals("Estimate"))
			{
				System.out.println("How many rooms are there to measure? (Please do not spell out number)");
				System.out.println("If you split up a room into multiple rectangles, make each reactangle count as a room");
				int numOfRooms = scan.nextInt();
				for(int i = 1; i <= numOfRooms; i++)
				{
					System.out.println("Please enter first dimension of room " + i);
					System.out.println("When entering dimension, just enter numbers and put a space between feet and inches");
					double feet = scan.nextDouble();
					double inch = scan.nextDouble();
					System.out.println("Please enter second dimension of room " + i);
					double feet2 = scan.nextDouble();
					double inch2 = scan.nextDouble();
					double areaOfRoom = BenchLibrary.getArea(feet, inch, feet2, inch2);
					totalArea += areaOfRoom; 
				}
				String totalArea2 = String.format("%.2f", totalArea);
				System.out.println("The total square footage of your estamate is " + totalArea2 + " sqft" );
				System.out.println("Do you wish to price this estimate?");
				System.out.println("*This will only account for the price of the material per sqft*");
				System.out.println("- Yes");
				System.out.println("- No");
				String choicePriceEstimate = scan.next();
				if(choicePriceEstimate.equals("yes") || choicePriceEstimate.equals("Yes"))
				{
					System.out.println("Please enter price of material per sqft");
					double pricePerSqFt = scan.nextDouble();
					price = BenchLibrary.getPrice(totalArea, pricePerSqFt);
					double placeHolderPrice = price;
					String totalPrice = String.format("%.2f", price);
					System.out.println("The price of this estimate is $" + totalPrice);
					System.out.println("Are there any other costs you wish to add to price (e.g. Ripping up cost)?");
					System.out.println("- Yes");
					System.out.println("- No");
					String choiceCost = scan.next();
					if(choiceCost.equals("no") || choiceCost.equals("No"))
					{

					}
					else if(choiceCost.equals("yes") || choiceCost.equals("Yes"))
					{
						System.out.println("How many flat rate costs do you wish to add?");
						int numOfFlatCost = scan.nextInt();
						if(numOfFlatCost == 0)
						{

						}
						else if(numOfFlatCost > 0)
						{
							for(int i = 1; i <= numOfFlatCost; i++)
							{
								System.out.println("Flat Rate " + i + " Price:");
								double priceOfFlatCost = scan.nextDouble();
								placeHolderPrice += priceOfFlatCost;
							}
						}
						System.out.println("How many variable rate costs do you wish to add? (e.g. Rip up per sqft)");
						int numOfVarCost = scan.nextInt();
						if(numOfVarCost == 0)
						{

						}
						else if(numOfVarCost > 0)
						{
							for(int i = 1; i <= numOfVarCost; i++)
							{
								System.out.println("Variable Cost " + i + " Price:");
								double priceOfVarCost = scan.nextDouble();
								placeHolderPrice += (price * priceOfVarCost);
							}
						}
						String finalPrice = String.format("%.2f", placeHolderPrice);
						System.out.println("The total price of estimate including extra costs is $" + finalPrice);
					}
				}
				else if(choicePriceEstimate.equals("no") || choicePriceEstimate.equals("No"))
				{

				}
			}
			else if(choiceMeasure.equals("remnant") || choiceMeasure.equals("Remnant"))
			{
				System.out.println("Please enter first dimension of remnant");
				System.out.println("When entering dimension, just enter numbers and put a space between feet and inches");
				double feet = scan.nextDouble();
				double inch = scan.nextDouble();
				System.out.println("Please enter second dimension");
				double feet2 = scan.nextDouble();
				double inch2 = scan.nextDouble();
				double areaOfRemnant = BenchLibrary.getArea(feet, inch, feet2, inch2);
				String areaOfRemnant2 = String.format("%.2f", areaOfRemnant);
				System.out.println("The area of the remnant is " + areaOfRemnant2 + " sqft");
				System.out.println("Do you wish to price the remnant?");
				System.out.println("- Yes");
				System.out.println("- No");
				String choicePriceRemnant = scan.next();
				if(choicePriceRemnant.equals("yes") || choicePriceRemnant.equals("Yes"))
				{
					System.out.println("Please enter the price per sqft of desired remnant");
					double pricePerSqFt = scan.nextDouble();
					price = BenchLibrary.getPrice(areaOfRemnant, pricePerSqFt);
					String totalPrice = String.format("%.2f", price);
					System.out.println("The price of this remnant is $" + totalPrice);
				}
				else if(choicePriceRemnant.equals("no") || choicePriceRemnant.equals("No"))
				{

				}
				
			}
			else if(choiceMeasure.equals("stairs") || choiceMeasure.equals("Stairs"))
			{
				System.out.println("Do you want to find the area of of the runners or both the risers and runners?");
				System.out.println("- Runners");
				System.out.println("- Both");
				String choiceStairs = scan.next();
				if(choiceStairs.equals("runners") || choiceStairs.equals("Runners")|| choiceStairs.equals("runner") || choiceStairs.equals("Runner"))
				{
					System.out.println("How many stairs do you wish to measure?");
					double numOfStairs = scan.nextDouble();
					System.out.println("Please enter first dimension of stairs");
					System.out.println("When entering dimension, just enter numbers and put a space between feet and inches");
					double feet = scan.nextDouble();
					double inch = scan.nextDouble();
					System.out.println("Please enter second dimension");
					double feet2 = scan.nextDouble();
					double inch2 = scan.nextDouble();
					double areaOfRunner = BenchLibrary.getArea(feet, inch, feet2, inch2) * numOfStairs;
					String areaOfRunner2 = String.format("%.2f", areaOfRunner);
					System.out.println("The total area of the runners is " + areaOfRunner2 + " sqft");
					System.out.println("Do you wish to price the runners?");
					System.out.println("*This will only account for the price of the material per sqft*");
					System.out.println("- Yes");
					System.out.println("- No");
					String choicePriceStairs = scan.next();
					if(choicePriceStairs.equals("yes") || choicePriceStairs.equals("Yes"))
					{
						System.out.println("Please enter price of material per sqft");
						double pricePerSqFt = scan.nextDouble();
						price = BenchLibrary.getPrice(areaOfRunner, pricePerSqFt);
						double placeHolderPrice = price;
						String price2 = String.format("%.2f", price);
						System.out.println("The total price of the runners is $" + price2);
						System.out.println("Are there any other costs you wish to add to price (e.g. Ripping up cost)?");
						System.out.println("- Yes");
						System.out.println("- No");
						String choiceCost = scan.next();
						if(choiceCost.equals("no") || choiceCost.equals("No"))
						{

						}
						else if(choiceCost.equals("yes") || choiceCost.equals("Yes"))
						{
							System.out.println("How many flat rate costs do you wish to add?");
							int numOfFlatCost = scan.nextInt();
							if(numOfFlatCost == 0)
							{

							}	
							else if(numOfFlatCost > 0)
							{		
								for(int i = 1; i <= numOfFlatCost; i++)
								{
									System.out.println("Flat Rate " + i + " Price:");
									double priceOfFlatCost = scan.nextDouble();
									placeHolderPrice += priceOfFlatCost;
								}
							}
						}
						System.out.println("How many variable rate costs do you wish to add? (e.g. Rip up per sqft)");
						int numOfVarCost = scan.nextInt();
						if(numOfVarCost == 0)
						{

						}
						else if(numOfVarCost > 0)
						{
							for(int i = 1; i <= numOfVarCost; i++)
							{
								System.out.println("Variable Cost " + i + " Price:");
								double priceOfVarCost = scan.nextDouble();
								placeHolderPrice += (price * priceOfVarCost);
							}
						}
						String finalPrice = String.format("%.2f", placeHolderPrice);
						System.out.println("The total price of the runners including extra costs is $" + finalPrice);
					}
					else if(choicePriceStairs.equals("no") || choicePriceStairs.equals("No"))
					{

					}
				}
				else if(choiceStairs.equals("Both") || choiceStairs.equals("both"))
				{
					System.out.println("How many stairs do you wish to measure?");
					double numOfStairs = scan.nextDouble();
					System.out.println("Please enter first dimension of runners");
					System.out.println("When entering dimension, just enter numbers and put a space between feet and inches");
					double feet = scan.nextDouble();
					double inch = scan.nextDouble();
					System.out.println("Please enter second dimension of runners");
					double feet2 = scan.nextDouble();
					double inch2 = scan.nextDouble();
					double areaOfRunner = BenchLibrary.getArea(feet, inch, feet2, inch2) * numOfStairs;
					System.out.println("Please enter first dimension of risers");
					System.out.println("When entering dimension, just enter numbers and put a space between feet and inches");
					feet = scan.nextDouble();
					inch = scan.nextDouble();
					System.out.println("Please enter second dimension of risers");
					feet2 = scan.nextDouble();
					inch2 = scan.nextDouble();
					double areaOfRiser = BenchLibrary.getArea(feet, inch, feet2, inch2) * numOfStairs;
					double totalAreaOfStairs = areaOfRunner + areaOfRiser;
					String totalAreaOfStairs2 = String.format("%.2f", totalAreaOfStairs);
					System.out.println("The total area of the stairs is " + totalAreaOfStairs2 + " sqft");
					System.out.println("Do you wish to price the stairs?");
					System.out.println("*This will only account for the price of the material per sqft*");
					System.out.println("- Yes");
					System.out.println("- No");
					String choicePriceStairs = scan.next();
					if(choicePriceStairs.equals("yes") || choicePriceStairs.equals("Yes"))
					{
						System.out.println("Please enter price of material per sqft");
						double pricePerSqFt = scan.nextDouble();
						price = BenchLibrary.getPrice(totalAreaOfStairs, pricePerSqFt);
						double placeHolderPrice = price;
						String price2 = String.format("%.2f", price);
						System.out.println("The total price of the stairs is $" + price2);
						System.out.println("Are there any other costs you wish to add to price (e.g. Ripping up cost)?");
						System.out.println("- Yes");
						System.out.println("- No");
						String choiceCost = scan.next();
						if(choiceCost.equals("no") || choiceCost.equals("No"))
						{

						}
						else if(choiceCost.equals("yes") || choiceCost.equals("Yes"))
						{
							System.out.println("How many flat rate costs do you wish to add?");
							int numOfFlatCost = scan.nextInt();
							if(numOfFlatCost == 0)
							{

							}	
							else if(numOfFlatCost > 0)
							{		
								for(int i = 1; i <= numOfFlatCost; i++)
								{
									System.out.println("Flat Rate " + i + " Price:");
									double priceOfFlatCost = scan.nextDouble();
									placeHolderPrice += priceOfFlatCost;
								}
							}
						}
						System.out.println("How many variable rate costs do you wish to add? (e.g. Rip up per sqft)");
						int numOfVarCost = scan.nextInt();
						if(numOfVarCost == 0)
						{

						}
						else if(numOfVarCost > 0)
						{
							for(int i = 1; i <= numOfVarCost; i++)
							{
								System.out.println("Variable Cost " + i + " Price:");
								double priceOfVarCost = scan.nextDouble();
								placeHolderPrice += (price * priceOfVarCost);
							}
						}
						String finalPrice = String.format("%.2f", placeHolderPrice);
						System.out.println("The total price of the stairs including extra costs is $" + finalPrice);
					}
					else if(choicePriceStairs.equals("no") || choicePriceStairs.equals("No"))
					{

					}
				}
			}		
		}	
		else if((choice1.equals("Get") || choice1.equals("get")) && choice2.equals("price"))
		{
			System.out.println("Please enter square footage of desired measurment:");
			double sqFt = scan.nextDouble();
			System.out.println("Please enter price per square foot of desired material:");
			double pricePerSqFt = scan.nextDouble();
			price = BenchLibrary.getPrice(sqFt, pricePerSqFt);
			double placeHolderPrice = price;
			String totalPrice = String.format("%.2f", price);
			System.out.println("The price of your desired measurment is $" + totalPrice);
			System.out.println("Are there any other costs you wish to add to price (e.g. Ripping up cost)?");
			System.out.println("- Yes");
			System.out.println("- No");
			String choiceCost = scan.next();
			if(choiceCost.equals("no") || choiceCost.equals("No"))
			{

			}
			else if(choiceCost.equals("yes") || choiceCost.equals("Yes"))
			{
				System.out.println("How many flat rate costs do you wish to add?");
				int numOfFlatCost = scan.nextInt();
				if(numOfFlatCost == 0)
				{

				}
				else if(numOfFlatCost > 0)
				{
					for(int i = 1; i <= numOfFlatCost; i++)
					{
						System.out.println("Flat Rate " + i + " Price:");
						double priceOfFlatCost = scan.nextDouble();
						placeHolderPrice += priceOfFlatCost;
					}
				}
				System.out.println("How many variable rate costs do you wish to add? (e.g. Rip up per sqft)");
				int numOfVarCost = scan.nextInt();
				if(numOfVarCost == 0)
				{

				}
				else if(numOfVarCost > 0)
				{
					for(int i = 1; i <= numOfVarCost; i++)
					{
						System.out.println("Variable Cost " + i + " Price:");
						double priceOfVarCost = scan.nextDouble();
						placeHolderPrice += (price * priceOfVarCost);
					}
				}
						String finalPrice = String.format("%.2f", placeHolderPrice);
						System.out.println("The total price of estimate including extra costs is $" + finalPrice);
			}
		}
		else
		{
			System.out.println("Invalid Input. Please restart code");
		}
		System.out.println("Have a great day!");
	}
}

