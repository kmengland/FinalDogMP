import java.util.Scanner;

public class DogWorld {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Actions DogAction = new Actions(); //accesses the other class
		
		int feedCounter = 0;
		int playCounter = 0;
		int agilityAbility = 0;
		int walkCounter = 0;
		int treatCounter = 0;
		int napCounter = 0;
		
		int numFood = 0;
		int numTreat = 0;
		
		double money = 50.00;
		//double foodPrice = 1.50;   IN OTHER CLASS
		//double treatPrice = .50;   IN OTHER CLASS
		//double vetVisit = 30.00;   IN OTHER CLASS
		//double agilityWin = 25.00; IN OTHER CLASS
		
		
		System.out.println("Welcome to the game **It's a Dog's World!**");
		System.out.println("Here, you will take care of a new dog. But first you need a name! What would you like to name your new dog?");
		String name = input.nextLine(); //name the dog
		System.out.println("Perfect! You are now the proud owner of " + name + ".");
		System.out.println("You are responsible for feeding, walking, playing with, and taking care of your dog.");
		System.out.println("Here are the rules:");
		System.out.println("--You will start out with $50.00. You will use this money to buy things for your dog.");
		System.out.println("--Actions with your dog include feeding, playing, walking, sleeping, and agility trials.");
		System.out.println("--You can only begin agility trials once you have played with " + name + " 6 times.");
		System.out.println("--You earn money by competing in agility trials!");
		System.out.println("--You have to use your money to purchase food and treats for your dog.");
		System.out.println("--Careful! You may have to use your money to pay for veterinarian bills!");
		System.out.println("--You cannot feed your dog more than two times in a row.");
		System.out.println("--Your dog cannot nap more than two times in a row.");
		System.out.println("--Your dog cannot play more than two times in a row.");
		System.out.println("--You cannot walk your dog more than two times in a row.");
		System.out.println("--You cannot give your dog more than 3 treats at a time.");
		System.out.println("--If any of the above actions are done, you will have to go to the vet and be charged accordingly.");
		System.out.println("The game will end when you have reached $0.00. Good luck!\n");
		System.out.println("You will start off with going to the store to purchase items for " + name + ".");
		System.out.println("This is what you have so far:\n");
		DogAction.DisplayStats(numFood, numTreat, money);
		System.out.println("Now, to the store...");
		double[] accessArrayShop = DogAction.shopping(numFood, numTreat, money, input);
		numFood = (int)accessArrayShop[0];
		numTreat = (int)accessArrayShop[1];
		money = accessArrayShop[2];
		
		while (money > 0.0) {
		int selection = DogAction.selectActivity(agilityAbility, input);
		
		switch (selection) {
		case 1: 
			int[] accessArrayPlay = DogAction.playTime(playCounter, feedCounter, napCounter, treatCounter, agilityAbility);
			playCounter = accessArrayPlay[0];
			feedCounter = accessArrayPlay[1];
			napCounter = accessArrayPlay[2];
			treatCounter = accessArrayPlay[3];
			agilityAbility = accessArrayPlay[4];
			if (playCounter >= 2) {
				System.out.println("Your dog is getting tired! Please feed or walk " + name);
			}
			if (playCounter >= 3) {
				System.out.println("Your dog got too tired. You now have to take them to the vet.");
				double[] accessPlayVet = DogAction.vetVisit(money, feedCounter, napCounter, walkCounter, treatCounter);
				money = accessPlayVet[0];
				feedCounter = (int) accessPlayVet[1];
				napCounter = (int) accessPlayVet[2];
				walkCounter = (int) accessPlayVet[3];
				treatCounter = (int) accessPlayVet[4];
			}
			break;
		case 2: 
			int[] accessArrayFeed = DogAction.giveFood(feedCounter, playCounter, walkCounter, numFood);
			feedCounter = accessArrayFeed[0];
			playCounter = accessArrayFeed[1];
			walkCounter = accessArrayFeed[2];
			numFood = accessArrayFeed[3];
			if (feedCounter >= 2) {
				System.out.println("Your dog is stuffed! Please walk or play with your dog or let them take a nap.");
			}
			if (feedCounter >= 3) {
				System.out.println("Your dog ate way too much. You now have to take them to the vet.");
				double[] accessFeedVet = DogAction.vetVisit(money, feedCounter, napCounter, walkCounter, treatCounter);
				money = accessFeedVet[0];
				feedCounter = (int) accessFeedVet[1];
				napCounter = (int) accessFeedVet[2];
				walkCounter = (int) accessFeedVet[3];
				treatCounter = (int) accessFeedVet[4];
			}
			break;
		case 3: 
			int[] accessArrayNap = DogAction.napTime(napCounter, feedCounter, walkCounter, playCounter);
			napCounter = accessArrayNap[0];
			feedCounter = accessArrayNap[1];
			walkCounter = accessArrayNap[2];
			playCounter = accessArrayNap[3];
			if (napCounter >= 2) {
				System.out.println("Your dog cannot sleep that much! Please feed, walk or play with your dog.");
			}
			if (napCounter >= 3) {
				System.out.println("Your dog slept too much. You now have to take them to the vet.");
				double[] accessNapVet = DogAction.vetVisit(money, feedCounter, napCounter, walkCounter, treatCounter);
				money = accessNapVet[0];
				if (money == 0.0) {
					System.exit(0);
				}
				feedCounter = (int) accessNapVet[1];
				napCounter = (int) accessNapVet[2];
				walkCounter = (int) accessNapVet[3];
				treatCounter = (int) accessNapVet[4];
			}
			break;
		case 4: 
			int[] accessArrayWalk = DogAction.goWalk(walkCounter, feedCounter, treatCounter);
			walkCounter = accessArrayWalk[0];
			feedCounter = accessArrayWalk[1];
			treatCounter = accessArrayWalk[2];
			if (walkCounter >= 2) {
				System.out.println("Your dog is getting very tired. Please feed or give your dog a treat or let them nap.");
			}
			if (walkCounter >= 3) {
				System.out.println("Your dog got too tired out. You now have to take them to the vet.");
				double[] accessWalkVet = DogAction.vetVisit(money, feedCounter, napCounter, walkCounter, treatCounter);
				money = accessWalkVet[0];
				if (money == 0.0) {
					System.exit(0);
				}
				feedCounter = (int) accessWalkVet[1];
				napCounter = (int) accessWalkVet[2];
				walkCounter = (int) accessWalkVet[3];
				treatCounter = (int) accessWalkVet[4];				
			}
			break;
		case 5: 
			int[] accessArrayTreat = DogAction.giveTreat(treatCounter, numTreat);
			treatCounter = accessArrayTreat[0];
			numTreat = accessArrayTreat[1];
			if (treatCounter >= 3) {
				System.out.println("Your dog is getting full on treats. Please play with or walk your dog.");
			}
			if (treatCounter >= 4) {
				System.out.println("Your dog got too full! You now have to take them to the vet.");
				double[] accessTreatVet = DogAction.vetVisit(money, feedCounter, napCounter, walkCounter, treatCounter);
				money = accessTreatVet[0];
				if (money == 0.0) {
					System.exit(0);
				}
				feedCounter = (int) accessTreatVet[1];
				napCounter = (int) accessTreatVet[2];
				walkCounter = (int) accessTreatVet[3];
				treatCounter = (int) accessTreatVet[4];
			}
			break;
		case 6: 
			double[] accessArrayShop2 = DogAction.shopping(numFood, numTreat, money, input);
			numFood = (int) accessArrayShop2[0];
			numTreat = (int) accessArrayShop2[1];
			money = accessArrayShop2[2];
			break;
		case 7: 
			DogAction.DisplayStats(numFood, numTreat, money);
			break;
		case 8: 
			System.exit(0);
			break;
		case 9: 
			double[] accessArrayAgility = DogAction.agilityCourse(money, agilityAbility, feedCounter, treatCounter);
			money = accessArrayAgility[0];
			agilityAbility = (int) accessArrayAgility[1];
			feedCounter = (int) accessArrayAgility[2];
			treatCounter = (int) accessArrayAgility[3];
			break;
		}
		}
		input.close();
	}
}

