package ejercicio.pkg4;

public class Ejercicio4 {

    public static void GuessingGame() {
        int answer = (int) Math.floor((Math.random() * 100) + 1);
        int guess = 0;
        int numGuesses = 1;

        while ((numGuesses > 7) || (answer == guess)) {

            System.out.println("Guess a number: " + guess);
            if (guess < answer) {
                System.out.println("Higher" + "\n");
            } else if (guess > answer) {
                System.out.println("Lower" + "\n");
            } else {
                System.out.println("You win" + "\n");
            }
            numGuesses = numGuesses + 1;
            if (numGuesses < 7) {
                System.out.println("You loser" + "\n");
            }

        }

    }

    public static void main(String[] args) {
        String playagain = "y";
        while ("y".equals(playagain)) {
            GuessingGame();
            System.out.println("Wold you like to play another game (y/n): " + playagain);
        }

    }

}
