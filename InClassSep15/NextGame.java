import java.util.Random;
import java.util.Scanner;

public class NextGame {
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	int[] guessArray = new int[5];
	int[] rand = {1,2,3,4,5};
	
	public void userInput() {
		int index1;
		for (index1 = 0; index1<5; index1++) {
			guessArray[index1] = scanner.nextInt();
		}
		
		for (int index : guessArray) {
			System.out.print(index + " ");
		}
		System.out.println();
	}
	
	public void randomNumber() {
		int index1;
		int randomNum;
		int temp;
		for (index1 = rand.length - 1; index1 > 0; index1--) {
			randomNum = random.nextInt(index1 + 1);
			
			temp = rand[index1];
			rand[index1] = rand[randomNum];
			rand[randomNum] = temp;
			
			
		}
		for (int index : rand) {
			System.out.print(index + " ");
		}
	}
	
	public void 
}
