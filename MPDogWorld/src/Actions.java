import java.util.Scanner;
import java.text.NumberFormat;

public class Actions {
	
	/**
	 * This method displays what the owner has.
	 * @param numFood bowls of food purchased
	 * @param numTreat number of treats purchased
	 * @param money amount of money available
	 */
	public void DisplayStats(int numFood, int numTreat, double money) {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		System.out.println("---------------------------------------------");
		System.out.println("You have " + numFood + " bowls of food left.");
		System.out.println("You have " + numTreat + " treats left.");
		System.out.println("You have " + currency.format(money) + " left.");
		System.out.println("---------------------------------------------");
	}
	
	/**
	 * Player goes to the store to purchase food and treats.
	 * @param numFood bowls of food purchased
	 * @param numTreat number of treats purchased
	 * @param money amount of money available
	 * @return bowls of food, number of treats, amount of money
	 */
	public double[] shopping(int numFood, int numTreat, double money, Scanner input) {
		double foodPrice = 1.50;
		double treatPrice = .50;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("You have " + currency.format(money));
		System.out.println("A bowl of food costs $1.50.");
		System.out.println("One treat costs $0.50.");
		System.out.println("How many bowls of food would you like to buy?");
		int buyFood = input.nextInt();
		while (buyFood < 0) {
			System.out.println("Please enter in a number greater than or equal to 0");
			buyFood = input.nextInt();
		}
		while (buyFood*foodPrice > money) {
			System.out.println("You cannot afford that! Please enter in a different number.");
			buyFood = input.nextInt();
		}
		System.out.println("Perfect! You bought " + buyFood + " bowls of food for " + currency.format(buyFood*foodPrice));
		money -= buyFood*foodPrice;
		numFood += buyFood;
		System.out.println("You have " + currency.format(money));
		System.out.println("How many treats would you like to buy?");
		int buyTreat = input.nextInt();
		while (buyTreat < 0) {
			System.out.println("Please enter in a number greater than or equal to 0.");
			buyTreat = input.nextInt();
		}
		while (buyTreat*treatPrice > money) {
			System.out.println("You cannot afford that! Please enter in a different number.");
			buyTreat = input.nextInt();
		}
		System.out.println("Perfect! You bought " + buyTreat + " treats for " + currency.format(buyTreat*treatPrice));
		money -= buyTreat*treatPrice;
		numTreat += buyTreat;
		System.out.println("You have " + currency.format(money));
		if (money <= 0) {
			System.out.println("You ran out of money!");
			money = 0.0;
		}
		double[] returnArray = new double[3];
		returnArray[0] = numFood;
		returnArray[1] = numTreat;
		returnArray[2] = money;
		return returnArray;
	}
	
	/**
	 * Player gives bowl of food to dog.
	 * @param feedCounter number of times dog was fed
	 * @param playCounter number of times dog was played with
	 * @param walkCounter number of times dog was walked
	 * @param numFood bowls of food purchased
	 * @return 1+feedCounter, 0 = playCounter, 0 = walkCounter, 1-numFood
	 */
	public int[] giveFood(int feedCounter, int playCounter, int walkCounter, int numFood) {
		System.out.println("--------------------------------------------------------------------------");
		int[] returnArray = new int[4];
		if (numFood <= 0) {
			System.out.println("You have no food for your dog!");
			returnArray[0] = feedCounter;
			returnArray[1] = playCounter;
			returnArray[2] = walkCounter;
			returnArray[3] = numFood;
			return returnArray;		
		}
		System.out.println("You have fed your dog!");
		feedCounter++;
		numFood--;
		playCounter = 0;
		walkCounter = 0;
		returnArray[0] = feedCounter;
		returnArray[1] = playCounter;
		returnArray[2] = walkCounter;
		returnArray[3] = numFood;
		return returnArray;
	}
	
	/**
	 * Player plays with dog.
	 * @param playCounter number of times played with dog
	 * @param feedCounter number of times dog was fed
	 * @param napCounter number of times dog slept
	 * @param treatCounter number of treats given
	 * @param agilityAbility indicates if dog can compete yet
	 * @return 1+playCounter, 0 = feedCounter, 0 = napCounter, 0 = treatCounter, 1+agilityAbility
	 */
	public int[] playTime(int playCounter, int feedCounter, int napCounter, int treatCounter, int agilityAbility) {
		System.out.println("--------------------------------------------------------------------------");
		int[] returnArray = new int[5];
		System.out.println("Yay! You played with your dog!");
		playCounter++;
		agilityAbility++;
		if (agilityAbility >= 6) {
			System.out.println("You can now compete in agility trials with your dog!");
		}
		feedCounter = 0;
		napCounter = 0;
		treatCounter = 0;
		returnArray[0] = playCounter;
		returnArray[1] = feedCounter;
		returnArray[2] = napCounter;
		returnArray[3] = treatCounter;
		returnArray[4] = agilityAbility;
		return returnArray;
	}
	
	/**
	 * Player lets dog take a nap.
	 * @param napCounter number of times dog napped
	 * @param feedCounter number of times dog was fed
	 * @param walkCounter number of times dog went on walk
	 * @param playCounter number of times played with dog
	 * @return 1+napCounter, 0 = feedCounter, 0 = walkCounter, 0 = playCounter
	 */
	public int[] napTime(int napCounter, int feedCounter, int walkCounter, int playCounter) {
		System.out.println("--------------------------------------------------------------------------");
		int[] returnArray = new int[4];
		System.out.println("Your dog had a successful nap!");
		napCounter++;
		feedCounter = 0;
		walkCounter = 0;
		playCounter = 0;
		returnArray[0] = napCounter;
		returnArray[1] = feedCounter;
		returnArray[2] = walkCounter;
		returnArray[3] = playCounter;
		return returnArray;
	}
	
	/**
	 * Player takes dog on walk
	 * @param walkCounter number of times dog went on walk
	 * @param feedCounter number of times dog was fed
	 * @param treatCounter number of treats given
	 * @return 1+walkCounter, 0 = feedCounter, 0 = treatCounter
	 */
	public int[] goWalk(int walkCounter, int feedCounter, int treatCounter) {
		System.out.println("--------------------------------------------------------------------------");
		int[] returnArray = new int[3];
		System.out.println("Your dog had a tiring but happy walk!");
		walkCounter++;
		feedCounter = 0;
		treatCounter = 0;
		returnArray[0] = walkCounter;
		returnArray[1] = feedCounter;
		returnArray[2] = treatCounter;
		return returnArray;
	}
	
	/**
	 * Player gives treat to dog.
	 * @param treatCounter number of treats given
	 * @param numTreat number of treats available
	 * @return 1+treatCounter, 1-numTreat
	 */
	public int[] giveTreat(int treatCounter, int numTreat) {
		System.out.println("--------------------------------------------------------------------------");
		int[] returnArray = new int[2];
		if (numTreat <= 0) {
			System.out.println("You have no treats for your dog!");
			returnArray[0] = treatCounter;
			returnArray[1] = numTreat;
			return returnArray;		
		}
		System.out.println("Your dog enjoyed a nice treat!");
		treatCounter++;
		numTreat--;
		returnArray[0] = treatCounter;
		returnArray[1] = numTreat;
		return returnArray;		
	}
	
	/**
	 * Player takes dog to compete in agility course
	 * @param money amount of money available
	 * @param agilityAbility indicates ability of competing
	 * @param feedCounter number of times dog was fed
	 * @param treatCounter number of times treat was given
	 * @return money+25, agilityAbility = 0, feedCounter = 0, treatCounter = 0
	 */
	public double[] agilityCourse(double money, int agilityAbility, int feedCounter, int treatCounter) {
		System.out.println("--------------------------------------------------------------------------");
		double[] returnArray = new double[4];
		if (agilityAbility < 6) {
			System.out.println("Sorry! You can't compete in an agility trial yet!");
			returnArray[0] = money;
			returnArray[1] = agilityAbility;
			returnArray[2] = feedCounter;
			returnArray[3] = treatCounter;
			return returnArray;
		}
		System.out.println("Congrats! Your dog took place in an agility trial! You won $25!");
		money += 25;
		agilityAbility = 0;
		feedCounter = 0;
		treatCounter = 0;
		returnArray[0] = money;
		returnArray[1] = agilityAbility;
		returnArray[2] = feedCounter;
		returnArray[3] = treatCounter;
		return returnArray;		
	}
	
	/**
	 * Player has to take dog to vet!
	 * @param money amount of money available
	 * @param feedCounter number of times dog was fed
	 * @param napCounter number of times dog napped
	 * @param walkCounter number of times dog was walked
	 * @param treatCounter number of times treat was given
	 * @return money-35, 0 = feedCounter, 0 = napCounter, 0 = walkCounter, 0 = treatCounter
	 */
	public double[] vetVisit(double money, int feedCounter, int napCounter, int walkCounter, int treatCounter) {
		System.out.println("--------------------------------------------------------------------------");
		double[] returnArray = new double[5];
		System.out.println("Uh-oh, your dog had to go to the vet. Try to be more careful next time!");
		System.out.println("This visit cost you $35.");
		if (money - 35 <= 0) {
			System.out.println("You have no more money!");
			returnArray[0] = 0.0;
			returnArray[1] = feedCounter;
			returnArray[2] = napCounter;
			returnArray[3] = walkCounter;
			returnArray[4] = treatCounter;
		}
		money -= 35;
		feedCounter = 0;
		napCounter = 0;
		walkCounter = 0;
		treatCounter = 0;
		returnArray[0] = money;
		returnArray[1] = feedCounter;
		returnArray[2] = napCounter;
		returnArray[3] = walkCounter;
		returnArray[4] = treatCounter;
		return returnArray;
	}
	
	/**
	 * Player chooses what to do next with the dog.
	 * @param agilityAbility indicates ability to participate in an agility trial
	 * @return item selection
	 */
	public int selectActivity(int agilityAbility, Scanner input) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Please choose an activity by typing a number:");
		System.out.println("1. Play with your dog.");
		System.out.println("2. Feed your dog.");
		System.out.println("3. Let your dog take a nap.");
		System.out.println("4. Take your dog on a walk.");
		System.out.println("5. Give your dog a treat.");
		System.out.println("6. Go to the store.");
		System.out.println("7. Display stats.");
		System.out.println("8. End the game.");
		if (agilityAbility >= 6) {
			System.out.println("9. Compete in agility trial.");
		}
		System.out.println("Type a number: ");
		int selection = input.nextInt();
		while (selection < 1 || selection > 9) {
			System.out.println("Please choose an available activity from the list.");
			selection = input.nextInt();
		}
		return selection;
	}
}

