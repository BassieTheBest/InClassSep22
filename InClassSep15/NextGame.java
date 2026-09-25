import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class NextGame {
	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();
	private int[] guessArray = new int[5];
	private int[] rand = {1,2,3,4,5};
	private Boolean win = false;
	private Boolean surrender = false;
	private int turns = 1;
	private String wordTurn = "";
	private File highScore = new File("HighScore.txt");
	private String user;
	
	public void userInput() {
		int index1;
		System.out.printf("== Turn %d == Number Sequence: ", turns);
		for (index1 = 0; index1<5; index1++) {
			guessArray[index1] = scanner.nextInt();
			if (guessArray[index1] == 0) {
				surrender = true;
			}
		}
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
	}
	
	public void compareThings() {
		int correctCount = 0;
		int index;
		
		for(index = 0; index < 5; index++) {
			if (rand[index] == guessArray[index]) {
				correctCount++;
			}
			if (correctCount == 5) {
				win = true;
			}
		}
		System.out.println("You got " + correctCount + " guesses Right");
	}
	
	public void repeat() {
		
		while (!surrender && !win) {
			turns++;
			userInput();
			compareThings();
			
		}
	}
	
	public void titleCard() {
		System.out.println("Game: Who's Next");
		System.out.printf("Objective: Identify the Sequence of 5 numbers "
				+ "between 1 and 5 using the fewest turns. If you wish \nto quit "
				+ "guessing and give up, enter a ZERO for one of your guesses"
				+ " and the game will display the \nsolution and quit.");
		System.out.println("Good Luck!!!");
		
		
	}
	
	public void GameOver() {
		System.out.printf("\nGame Number Sequences \n---------------------\n| %d | %d | %d | %d | %d |\n---------------------\n", rand[0], rand[1], rand[2], rand[3], rand[4]);
	}
	
	public void readHighScore() {
		try {
			Scanner HSScan = new Scanner(highScore);
			while (HSScan.hasNextLine()) {
				String line = HSScan.nextLine();
	            System.out.println(line);
			}
			HSScan.close();
		}
		catch (FileNotFoundException nf) {
			System.out.print("Loser");
		}
	}
	
	public void setHighScore() {
		try {
			FileWriter newHS = new FileWriter(highScore, true);
			user = scanner.nextLine();
			newHS.write(wordTurn);
			newHS.write(" - ");
			newHS.write(user + "\n");
			
			newHS.close();
		}
		catch (IOException MU) {
			System.out.println("Messed Up");
		}
		
	}
	
	public void actuallyPlaying() {
		titleCard();
		randomNumber();
		userInput();
		compareThings();
		repeat();
		GameOver();
		if (win = true) {
			setHighScore();
			readHighScore();
		}
		turns = 1;
	}
}
