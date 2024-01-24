import java.util.Scanner;


public class tictactoe{
    static Scanner scanner = new Scanner(System.in); //initalize scanner to get usr input
    public static int chooseMode(){
        System.out.println("\nWelcome to Conj's TicTacToe!\n\nEnter 1 to play against the computer!\nEnter 2 to play against your friend!");
        int choice = scanner.nextInt();
        return choice;
    }

    
    public static void main(String[] args){
        boolean gamePlaying = true;
        Board gameBoard = new Board();

        Player player1 = new Player('X', 1); // 2 players in tictactoe
        Player player2 = new Player('O', 2);

        int moveCount = 0;
        int move = 0;

        
        int choice = chooseMode();
        gameBoard.printBoard(gameBoard);
        if(choice == 1)
        {
        while(gamePlaying){ //game loop

            
            move = gameBoard.getMove(player1); //get move, place it then check if player1 won
            gameBoard.placeMove(move, gameBoard, player1);
            gameBoard.printBoard(gameBoard);
            gamePlaying = gameBoard.checkWin(gameBoard, player1);
            if(!gamePlaying)
            {
                System.out.println("Congratulations!");
                break;
            }
            moveCount++;

            if(moveCount == 9) //check for tie
            {
                System.out.println("Tie! Game Over!");
                gamePlaying = false;
                break;
            }
            
            int aiMove = 0;
            aiMove = gameBoard.smartMove(gameBoard, player2);
            if(aiMove == 0)
            {
                gameBoard.placeRandMove(gameBoard, player2);
            }
            else gameBoard.placeMove(aiMove, gameBoard, player2);
            gameBoard.printBoard(gameBoard);
            gamePlaying = gameBoard.checkWin(gameBoard, player2);
            if(!gamePlaying)
            {
                System.out.println("Congratualtions!");
                break;
            }
            moveCount++;
            
            if(moveCount == 9) //check for tie
            {
                System.out.println("Tie! Game Over!");
                gamePlaying = false;
                break;
            }


        }
    }
    else if(choice == 2)
    {
        while(gamePlaying){ //game loop

            
            move = gameBoard.getMove(player1); //get move, place it then check if player1 won
            gameBoard.placeMove(move, gameBoard, player1);
            gameBoard.printBoard(gameBoard);
            gamePlaying = gameBoard.checkWin(gameBoard, player1);
            if(!gamePlaying)
            {
                System.out.println("Congratulations!");
                break;
            }
            moveCount++;

            if(moveCount == 9) //check for tie
            {
                System.out.println("Tie! Game Over!");
                gamePlaying = false;
                break;
            }

            move = gameBoard.getMove(player2); //get move, place it then check if player1 won
            gameBoard.placeMove(move, gameBoard, player2);
            gameBoard.printBoard(gameBoard);
            gamePlaying = gameBoard.checkWin(gameBoard, player2);
            if(!gamePlaying)
            {
                System.out.println("Congratualtions!");
                break;
            }
            moveCount++;
            
            if(moveCount == 9) //check for tie
            {
                System.out.println("Tie! Game Over!");
                gamePlaying = false;
                break;
            }

        }
        
        
    }
    else System.out.println("You didn't enter a valid value!");
    scanner.close();
}
    

    
}