import java.util.Scanner;
import java.util.Random;

public class Board {
        public char[][] board;
         static Scanner scanner = new Scanner(System.in); //initalize scanner to get usr input
         
        public Board() {
            this.board = new char[][]{ //define the board
                {'1','|', '2','|', '3'},
                {'-','-','-','-','-'},
                {'4','|', '5','|', '6'},
                {'-','-','-','-','-'},
                {'7','|', '8','|', '9'}
            };
        }
    
        public void printBoard(Board gameBoard){ //method to print the board
            System.out.println();
            for(char[] row : board)
            {
                for(char cell : row)
                {
                    System.out.print(cell);
                }
                System.out.println();
            }
            System.out.println();
            }
        
            public void checkLocation(Board gameBoard, Player player){ //runs if user tries to place a move where a move has already been plaved
                System.out.println("Someone already entered a move there!");
                int newMove = getMove(player); //prompt the user for a new move
                placeMove(newMove, gameBoard, player); 
        }
            public  void placeMove(int move, Board gameBoard, Player player){ //takes the user input of move and puts it in the correct position and chekcs to see if it is an avialable move

                switch(move){
                    case 1:
                        if(gameBoard.board[0][0] == 'X' || gameBoard.board[0][0] == 'O')
                        {
                            checkLocation(gameBoard, player);
                        }
                        else gameBoard.board[0][0] = player.symbol;
                        break;
                    case 2:
                        if(gameBoard.board[0][2] == 'X' || gameBoard.board[0][2] == 'O')
                        {
                            checkLocation(gameBoard, player);
                        }
                        else gameBoard.board[0][2] = player.symbol;
                        break;
                    case 3:
                        if(gameBoard.board[0][4] == 'X' || gameBoard.board[0][4] == 'O')
                        {
                            checkLocation(gameBoard, player);
                        }
                        else gameBoard.board[0][4] = player.symbol;
                        break;
                    case 4:
                        if(gameBoard.board[2][0] == 'X' || gameBoard.board[2][0] == 'O')
                        {
                            checkLocation(gameBoard, player);
                        }
                        else gameBoard.board[2][0] = player.symbol;
                        break;
                    case 5:
                        if(gameBoard.board[2][2] == 'X' || gameBoard.board[2][2] == 'O')
                        {
                            checkLocation(gameBoard, player); 
                        }
                        else gameBoard.board[2][2] = player.symbol;
                        break;
                    case 6:
                        if(gameBoard.board[2][4] == 'X' || gameBoard.board[2][4] == 'O')
                        {
                            checkLocation(gameBoard, player);
                        }
                        else gameBoard.board[2][4] = player.symbol;
                        break;
                    case 7:
                        if(gameBoard.board[4][0] == 'X' || gameBoard.board[4][0] == 'O')
                        {
                            checkLocation(gameBoard,  player);
                        }
                        else gameBoard.board[4][0] = player.symbol;
                        break;
                    case 8:
                        if(gameBoard.board[4][2] == 'X' || gameBoard.board[4][2] == 'O')
                        {
                            checkLocation(gameBoard,player);
                        }
                        else gameBoard.board[4][2] = player.symbol;
                        break;
                    case 9:
                        if(gameBoard.board[4][4] == 'X' || gameBoard.board[4][4] == 'O')
                        {
                            checkLocation(gameBoard, player);
                        }
                        else gameBoard.board[4][4] = player.symbol;
                        break;
                    default:
                        System.out.println("Invalid Move! You entered a move outside of the range!"); //if move doesnt match any case, it is outside of the range
                        int newMove = getMove(player); //prompt player for a new move
                        placeMove(newMove, gameBoard, player);
                }
            }
    


        public int getMove(Player player){ //gets user input to get users move
        
            System.out.println("Enter a move for Player "+player.playerNumber+" (" +player.symbol+"'s) (integer 1-9): ");
            int move = scanner.nextInt();
            return move;
        }    
        public  boolean checkVertical(char[] array){ //checks to see if three in a row vertically
            if(array[0] == array[3] && array[3] == array[6])
            {
                return false; //false means the game is over
            }
            if(array[1] == array[4] && array[4] == array[7])
            {
                return false;
            }
            if(array[2] == array[5] && array[5] == array[8])
            {
                return false;
            }
            return true; //true if none of the vertical lines are the same
        }
    
        public boolean checkHorizontal(char[] array){ //same as vertical but horizontal
            if(array[0] == array[1] && array[1] == array[2])
            {
                return false;
            }
            if(array[3] == array[4] && array[4] == array[5])
            {
                return false;
            }
            if(array[6] == array[7] && array[7] == array[8])
            {
                return false;
            }
            return true;
        }
    
         public boolean checkDiagonal(char[] array){ //same as previous, but diagonal
            if(array[0] == array[4] && array[4] == array[8])
            {
                return false;
            }
            if(array[2] == array[4] && array[4] == array[6])
            {
                return false;
            }
            return true;
        }
    
       
    
        public boolean checkWin(Board gameBoard, Player player){ //puts elements from board into an array to check if a player has won
            char[] array = new char[9];
            int p = 0;
            int j = 0;
            for(int i = 0; i<5;i++)
            {
                j=0;
                while(j<5)
                {
                    array[p] = gameBoard.board[i][j];
                    j = j+2;
                    p++;
                }
                i++;
            }
            boolean gamePlaying = true;
            gamePlaying = checkHorizontal(array); //check each possible way someone could win
            if(!gamePlaying)
            {
                System.out.println("Game Over! Player "+player.playerNumber+" won!");
                return false;
            }
            gamePlaying = checkVertical(array);
            if(!gamePlaying)
            {
                System.out.println("Game Over! Player "+player.playerNumber+" won!");
                return false;
            }
            gamePlaying = checkDiagonal(array);
            if(!gamePlaying)
            {
                System.out.println("Game Over! Player "+player.playerNumber+" won!");
                return false;
            }
            return true;
    
        }


        public int randMoveCheck(int move, Board gameBoard, Player player){ //takes the user input of move and puts it in the correct position and chekcs to see if it is an avialable move

        switch(move){
            case 1:
                if(gameBoard.board[0][0] == 'X' || gameBoard.board[0][0] == 'O')
                {
                    return 1;
                }
                else 
                {
                    gameBoard.board[0][0] = player.symbol;
                    return 0;
                }
                
            case 2:
                if(gameBoard.board[0][2] == 'X' || gameBoard.board[0][2] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[0][2] = player.symbol; return 0;
                
            case 3:
                if(gameBoard.board[0][4] == 'X' || gameBoard.board[0][4] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[0][4] = player.symbol; return 0;
                
            case 4:
                if(gameBoard.board[2][0] == 'X' || gameBoard.board[2][0] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[2][0] = player.symbol; return 0;
                
            case 5:
                if(gameBoard.board[2][2] == 'X' || gameBoard.board[2][2] == 'O')
                {
                    return 1; 
                }
                else gameBoard.board[2][2] = player.symbol; return 0;
                
            case 6:
                if(gameBoard.board[2][4] == 'X' || gameBoard.board[2][4] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[2][4] = player.symbol; return 0;
                
            case 7:
                if(gameBoard.board[4][0] == 'X' || gameBoard.board[4][0] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[4][0] = player.symbol; return 0;
                
            case 8:
                if(gameBoard.board[4][2] == 'X' || gameBoard.board[4][2] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[4][2] = player.symbol; return 0;
                
            case 9:
                if(gameBoard.board[4][4] == 'X' || gameBoard.board[4][4] == 'O')
                {
                    return 1;
                }
                else gameBoard.board[4][4] = player.symbol; return 0;
                
            default:
                return 1;

        }
    }


    public void placeRandMove(Board gameBoard, Player player)
    {
        int[] cornerArray = new int[4];
        int i = 0;
        Random random = new Random();
        int check = 1;
        if(gameBoard.board[0][0] != 'X' && gameBoard.board[0][0] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[0][0]);
            i++;
        }
        if(gameBoard.board[0][4] != 'X' && gameBoard.board[0][4] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[0][4]);
            i++;
        }
        if(gameBoard.board[4][0] != 'X' && gameBoard.board[4][0] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[4][0]);
            i++;
        }
        if(gameBoard.board[4][4] != 'X' && gameBoard.board[4][4] != 'O')
        {
            cornerArray[i] = Character.getNumericValue(gameBoard.board[4][4]);
            i++;
        }
        if(i>0)
        {
        int index = random.nextInt((i - 0) + 0) + 0;
        check = randMoveCheck(cornerArray[index], gameBoard, player);
        }
        if(i == 0)
        {
        while(check == 1)
        {
            int move =  random.nextInt((9 - 1) + 1) + 1;
            check = randMoveCheck(move, gameBoard, player);
            
        }
    }
    }

    public int checkWinCurrent(char current[], Player player)
    {
        char p = player.symbol;
        if(current[0] == current[1] && p == current[0])
        {
            if(current[2] != 'X' && current[2] != 'O')
            {
                int temp = Character.getNumericValue(current[2]);
                //System.out.println("smart move 1 "+temp);
                return temp;
            }
        }

        if(current[1] == current[2] && p == current[1])
        {
            if(current[0] != 'X' && current[0] != 'O')
            {
                int temp = Character.getNumericValue(current[0]);
                //System.out.println("smart move 2 "+temp);
                return temp;
            }
        }

        if(current[0] == current[2] && p == current[0])
        {
            if(current[1] != 'X' && current[1] != 'O')
            {
                int temp = Character.getNumericValue(current[1]);
                //System.out.println("smart move 3 "+temp);
                return temp;
            }
        }

        return 0;
    }

     public int checkCurrent(char current[])
    {
        if(current[0] == current[1])
        {
            if(current[2] != 'X' && current[2] != 'O')
            {
                int temp = Character.getNumericValue(current[2]);
                //System.out.println("smart move 1 "+temp);
                return temp;
            }
        }

        if(current[1] == current[2])
        {
            if(current[0] != 'X' && current[0] != 'O')
            {
                int temp = Character.getNumericValue(current[0]);
                //System.out.println("smart move 2 "+temp);
                return temp;
            }
        }

        if(current[0] == current[2])
        {
            if(current[1] != 'X' && current[1] != 'O')
            {
                int temp = Character.getNumericValue(current[1]);
                //System.out.println("smart move 3 "+temp);
                return temp;
            }
        }

        return 0;
    }

    public int smartMove(Board gameBoard, Player player)
    {
        if(gameBoard.board[2][2] != 'X' && gameBoard.board[2][2] != 'O')
        {
            return 5;
        }
        char array[] = new char[3];
        int count = 0;
        int temp = 0;
        for(int i = 0; i<5; i++) //horizontal
        {
            count = 0;
            for(int j = 0; j<5; j++)
            {
                //System.out.println(board[i][j]);
                array[count] = gameBoard.board[i][j];
                count++;
                j++;
            }
            temp = checkWinCurrent(array, player);
            if(temp!=0)
            {
                //System.out.println("here 1");
                return temp;
            }
            temp = checkCurrent(array);
            if(temp!=0)
            {
                //System.out.println("here 1");
                return temp;
            }
            //System.out.println("bro "+temp);
            i++;
            //System.out.println();
        }


        for(int i = 0; i<5; i++) //vertical
        {
            count = 0;
            for(int j = 0; j<5; j++)
            {
                //System.out.println(board[j][i]);
                array[count] = gameBoard.board[j][i];
                count++;
                j++;
            }
            temp = checkWinCurrent(array, player);
            if(temp!=0)
            {
                //System.out.println("here 1");
                return temp;
            }
            temp = checkCurrent(array);
            if(temp!=0)
            {
                //System.out.println("here 2");
                return temp;
            }
            //System.out.println("bro "+temp);
            i++;
            //System.out.println();
        }


        count = 0;
        for(int i = 0; i<5; i++) //diagonal
        {
            
            int j = i;
            //System.out.println(board[i][j]);
            array[count] = gameBoard.board[i][j];
            count++;
            i++;
        }
        temp = checkWinCurrent(array, player);
            if(temp!=0)
            {
                //System.out.println("here 1");
                return temp;
            }
        temp = checkCurrent(array);
        if(temp!=0)
            {
                //System.out.println("here 3");
                return temp;
            }
        //System.out.println("bro "+temp);

        //System.out.println();

        int j = 4;
        count = 0;
        for(int i = 0; i<5; i++) //diagonal
        {
            
            //System.out.println(board[j][i]);
            array[count] = gameBoard.board[j][i];
            count++;
            i++;
            j-=2;
        }
        temp = checkWinCurrent(array, player);
            if(temp!=0)
            {
                //System.out.println("here 1");
                return temp;
            }
        temp = checkCurrent(array);
        if(temp!=0)
            {
                //System.out.println("here 4");
                return temp;
            }
        //System.out.println("bro "+temp);

        return temp;
    }

    public void closeScanner()
        {
            scanner.close();    //close the scanner
        }
        
    
        // Other methods as needed
    
    
}
