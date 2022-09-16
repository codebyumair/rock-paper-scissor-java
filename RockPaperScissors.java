import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;

        int playerInput, computerInput;

        char ch;
        String yesNo;

        do {
            int playerScore = 0, computerScore = 0;

            try {
                while (playerScore < 3 && computerScore < 3) {
                    System.out.println("\n=======[ GAME START ]=======");
                    System.out.println("0  -  Rock");
                    System.out.println("1  -  Paper");
                    System.out.println("2  -  Scissors");
                    System.out.println("==============================");
                    System.out.print("Enter your choice: ");
                    playerInput = sc.nextInt();


                    // generating numbers between 0 - 1
                    Random rd = new Random();
                    computerInput = rd.nextInt(3);

                    if (playerInput == computerInput) {
                        System.out.println("\n[ Gamer Draw ]");
                    }
                    /*
                     * Checking player choice against all possible condition
                     *  1 - playerInput == 0[Rock] && computerInput 2[Scissors] -- Player win
                     *  2 - playerInput == 1[Paper] && computerInput 0[Rock] -- Player win
                     *  3 - playerInput == 2[Scissor] && computerInput 1[Paper] -- Player win
                     */
                    else if (playerInput == 0 && computerInput == 2 || playerInput == 1 && computerInput == 0 || playerInput == 2 && computerInput == 1) {
                        System.out.println("\n[ You win ]");
                        playerScore++; // increamenting player score
                    }
                    // checking invalid choice like if player enter other number than 0 - 2
                    else if (playerInput < 0 || playerInput > 2) {
                        System.out.println("\nPlease enter choice between [0 - 2]");
                    } else {
                        System.out.println("\n[ Computer win ]");
                        computerScore++; // increamenting computer score
                    }

                    if (playerInput == 0 || playerInput <= 2) {
                        // printing computer choice
                        if (computerInput == 0) {
                            System.out.println("\n[ Computer chooses: ROCK ]");
                        } else if (computerInput == 1) {
                            System.out.println("\n[ Computer chooses: PAPER ]");
                        } else if (computerInput == 2) {
                            System.out.println("\n[ Computer chooses: SCISSOR ]");
                        }

                        // printing scores
                        System.out.println("[ Player score : " + playerScore + " ]");
                        System.out.println("[ Computer score : " + computerScore + " ]");

                        // printing final result
                        if (playerScore == 3) {
                            System.out.println("[ Final : You win : " + playerScore + " ]");
                        } else if (computerScore == 3) {
                            System.out.println("[ Final : Computer win : " + computerScore + " ]");
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("\nPlease enter numbers only [0 - 2]");
                sc.next();
            }
            System.out.println("\nDo you want to play again? [Y/N]");
            yesNo = sc.next();
            yesNo = yesNo.toUpperCase();
            ch = yesNo.charAt(0);

            if (ch == 'Y' && Character.isWhitespace(ch) != true) {
                playAgain = true;
            } else if (ch == 'N') {
                playAgain = false;
            }
        } while (playAgain);
        System.out.println("=======[ GAME END ]=======");
    }
}