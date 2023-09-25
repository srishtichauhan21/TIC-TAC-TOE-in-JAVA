import java.util.Scanner;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ttt{
    public static void main(String[] args) {

        System.out.println("WELCOME TO THE TIC-TAC-TOE GAME 😁!");

        String[][] board = new String[3][3];

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = "_";
            }
        }

        // Display the frame for the first time 

        JFrame frame = new JFrame();
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int count1 = i%3;
            int count2 = i/3;
            JButton B = new JButton(board[count2][count1]);   
            switch(i){
                case 0: B.setBounds(0, 0, 50, 50); break;
                case 1: B.setBounds(60, 0, 50, 50); break;
                case 2: B.setBounds(120, 0, 50, 50); break;
                case 3: B.setBounds(0, 60, 50, 50); break;
                case 4: B.setBounds(60, 60, 50, 50); break;
                case 5: B.setBounds(120, 60, 50, 50); break;
                case 6: B.setBounds(0, 120, 50, 50); break;   
                case 7: B.setBounds(60, 120, 50, 50); break;
                case 8: B.setBounds(120, 120, 50, 50); break;
            }
            buttons.add(B);
            frame.add(B);
        }

        frame.setLayout(null);
        frame.setSize(180, 200);
        frame.setVisible(true);

        System.out.println();

        System.out.println("The board positions are as follows: ");

        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");

        System.out.println();

        System.out.println("Do you want to play?");
        System.out.println("Enter 'y' to continue, anything else to not play.");

        Scanner sc = new Scanner(System.in);
        String playChoice = sc.nextLine();

        String choice1 = "", choice2 = "";

        if (playChoice.equals("y")){
            System.out.println("Player 1 choose 'X' or 'O'");

            choice1 = sc.nextLine();
            if (choice1.equals("X")){
                choice2 = "O";
            } else if (choice1.equals("O")){
                choice2 = "X";
            }

            System.out.println("Player 1 : " + choice1);
            System.out.println("Player 2 : " + choice2);
            
            while(true){
                int count = 0;
                boolean nextGamePlay = false;
                while (true){
                    if (count%2 == 0){
                        System.out.println("It is Player 1's turn!");
                        userChoice(board, choice1, frame, buttons);
                        if (winCheck(board, choice1)){
                            System.out.println("Player 1 WINS 🥳!");
                            System.out.println("Do you want to play another game? 'y' to continue");
                            String playAgain = sc.nextLine();
                            if (playAgain.equals("y")){
                                nextGamePlay = true;
                            }
                            break;
                        }
                    }
                    else{
                        System.out.println("It is Player 2's turn!");
                        userChoice(board, choice2, frame, buttons);
                        winCheck(board, choice2);
                        if (winCheck(board, choice2)){
                            System.out.println("Player 2 WINS 🥳!");
                            System.out.println("Do you want to play another game? 'y' to continue");
                            String playAgain = sc.nextLine();
                            if (playAgain.equals("y")){
                                nextGamePlay = true;
                            }
                            break;
                        }
                    }     
                    count += 1;
                    if (count == 9){
                        System.out.println("DRAW!");
                        System.out.println("Do you want to play another game? 'y' to continue");
                        String playAgain = sc.nextLine();
                        if (playAgain.equals("y")){
                            nextGamePlay = true;
                        }
                        break;
                    }
                }
                if (nextGamePlay == false){
                    System.out.println("GAME OVER!");
                    break;
                } 
                else{
                    for (int i = 0; i < board.length; i++){
                        for (int j = 0; j < board.length; j++){
                            board[i][j] = "_";
                        }
                    }
                }
            }

        } else{
            System.out.println("Okay! Hope to see you again!");
        }
    }

    // METHOD 1 - PRINTS THE TIC-TAC-TOE BOARD

    static void printBoard(String[][] board, JFrame frame, ArrayList<JButton> buttons){
        for (int i = 0; i < 9; i++) {
            int count1 = i%3;
            int count2 = i/3;
            JButton B = buttons.get(i);
            B.setText(board[count2][count1]);
        }
        frame.invalidate();
        frame.validate();
    }

    // METHOD 2 - TAKES IN USER INPUT OF POSITION OF PLACING 'X' OR 'O' AND THEN ASSIGNS IT TO THE PLACE IF THE PLACE IS AVAILABLE

    static void userChoice(String [][] board, String choice, JFrame frame, ArrayList<JButton> buttons){

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a no. between 1 to 9");

        // System.out.println("1 2 3");
        // System.out.println("4 5 6");
        // System.out.println("7 8 9");

        int spotChoice = sc.nextInt();

        String x = "";

        switch(spotChoice){
            case 1: x = board[0][0]; break;
            case 2: x = board[0][1]; break;
            case 3: x = board[0][2]; break;
            case 4: x = board[1][0]; break;
            case 5: x = board[1][1]; break;
            case 6: x = board[1][2]; break;
            case 7: x = board[2][0]; break;
            case 8: x = board[2][1]; break;
            case 9: x = board[2][2]; break;
            default: System.out.println("Invalid choice! Choose again!"); userChoice(board, choice, frame, buttons);
        }

        if (x.equals("_")){
            x = choice;
            switch(spotChoice){
                case 1: board[0][0] = x; break;
                case 2: board[0][1] = x; break;
                case 3: board[0][2] = x; break;
                case 4: board[1][0] = x; break;
                case 5: board[1][1] = x; break;
                case 6: board[1][2] = x; break;
                case 7: board[2][0] = x; break;
                case 8: board[2][1] = x; break;
                case 9: board[2][2] = x; break;
            }
            printBoard(board, frame, buttons);
        } else{
            System.out.println("Spot is filled! Choose again!");
            userChoice(board, choice, frame, buttons);
        }
    }

    // METHOD 3 - CHECKS IF THERE IS A WINNER AND ENDS GAME

    static Boolean winCheck(String board[][], String choice){
        if (board[0][0].equals(choice) && board[0][1].equals(choice) && board[0][2].equals(choice)){
            return true;
        } else if (board[1][0].equals(choice) && board[1][1].equals(choice) && board[1][2].equals(choice)){
            return true;
        } else if (board[2][0].equals(choice) && board[2][1].equals(choice) && board[2][2].equals(choice)){
            return true;
        } else if (board[0][0].equals(choice) && board[1][0].equals(choice) && board[2][0].equals(choice)){
            return true;
        } else if (board[0][1].equals(choice) && board[1][1].equals(choice) && board[2][1].equals(choice)){
            return true;
        } else if (board[0][2].equals(choice) && board[1][2].equals(choice) && board[2][2].equals(choice)){
            return true;
        } else if (board[0][0].equals(choice) && board[1][1].equals(choice) && board[2][2].equals(choice)){
            return true;
        } else if (board[0][2].equals(choice) && board[1][1].equals(choice) && board[2][0].equals(choice)){
            return true;
        } 
        return false;
    }

    // METHOD 4 - CHECKS IF THERE IS A DRAW AND ENDS THE GAME

    static Boolean drawCheck(String board[][]){
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (!board[i][j].equals("_")){
                    count++;
                }
            }
        }

        if (count == 9){
            return true;
        } else {
            return false;
        }
    }

}