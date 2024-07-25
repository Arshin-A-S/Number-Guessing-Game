//GUESS THE NUMBER 
//Maximum Attempts: 5
//Maximum Rounds: 3
import java.util.Scanner;
import java.util.Random;

class Task2{
    private static final int minNum = 1;
    private static final int maxNum = 100;
    private static final int maxAttempts = 10;
    private static final int maxRounds = 3;
    static Scanner in = new Scanner(System.in);
    private int totalScore=0;
    public static void main(String[] args){
        while(true){
            menu();
        }
        
    }

    private static void menu(){
    
        System.out.println("1. START");
        System.out.println("2. EXIT");
        System.out.print("Enter your choice: ");
        int ch = in.nextInt();
        switch(ch){ 
            case 1:
                game();
                break;
            case 2:
                System.out.println("QUITTING...\n\n");
                System.exit(1);
                break;
            default:
                System.out.println("WRONG CHOICE!!! ENTER THE CORRECT CHOICE");
                break;
        }
        
    }

    private static void game(){
        int totalScore=0;
        for(int round=1; round<=maxRounds; round++){
            System.out.println("ROUND "+round);
            boolean flag = true;
            int attempts = maxAttempts;
            int guess;
            int randomNum = generate(); // Generate random number at the start of each round
            while(flag && (attempts > 0)){
                System.out.println();
                System.out.println("Attempts Remaining: "+attempts);
                System.out.print("Enter your guess: ");
                guess = in.nextInt();
                int score;
                if(randomNum == guess){
                    System.out.println("YOUR GUESS IS CORRECT!!");
                    score = calcScore(attempts, 0);
                    System.out.println("Score: "+score);
                    totalScore += score;
                    System.out.println("Total Score: "+totalScore);
                    break;
                } else if(Math.abs(randomNum - guess) <= 3){
                    System.out.println("YOUR GUESS IS ALMOST CORRECT!!");
                    score = calcScore(attempts, 1);
                    System.out.println("Score: "+score);
                    totalScore += score;
                    System.out.println("Total Score: "+totalScore);
                } else if(guess < randomNum){
                    System.out.println("YOUR GUESS IS WRONG!! THE NUMBER YOU GUESSED IS TOO LOW");
                    score = 0;
                    System.out.println("Score: "+score);
                    System.out.println("Total Score: "+totalScore);
                } else if(guess > randomNum){
                    System.out.println("YOUR GUESS IS WRONG!! THE NUMBER YOU GUESSED IS TOO HIGH");
                    score = 0;
                    System.out.println("Score: "+score);
                    System.out.println("Total Score: "+totalScore);
                }
                attempts--;
                if(attempts == 0){
                    System.out.println("All attempts failed");
                    System.out.println("The number was: "+ randomNum);
                }
            }
        }
        
        restartMenu();
    }

    private static int calcScore(int attempts, int near){
        if (near == 0) {
            return attempts * 5; // Full points if the guess is correct
        } else if (near == 1) {
            return attempts * 3; // Partial points if the guess is almost correct
        } else {
            return 0; // No points for incorrect guesses
        }
    }
    
    private static int generate(){ 
        Random rand = new Random();
        return rand.nextInt(maxNum) + minNum; 
    }

    private static void restartMenu(){
        
        System.out.println("1. RESTART");
        System.out.println("2. EXIT");
        System.out.print("Enter your choice: ");
        int ch = in.nextInt();
        switch(ch){ 
            case 1:
                game();
                break;
            case 2:
                System.out.println("QUITTING...\n\n");
                System.exit(1);
                break;
            default:
                System.out.println("WRONG CHOICE!!! ENTER THE CORRECT CHOICE");
                break;
        }
        
    }
}