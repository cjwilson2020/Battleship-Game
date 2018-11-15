import java.util.Scanner;
import java.util.Random;

public class Battleship {

    /**
     * This method converts a String representing a base (or radix) 26 number into a decimal (or 
     * base 10) number. The String representation of the base 26 number uses the letters of the 
     * Latin alphabet to represent the 26 digits. That is, A represents 0, B represents 1, C 
     * represents 2, ..., Y represents 24,  and Z represents 25.
     *
     * A couple of examples:
     * BAAA = 1 * 26^3 + 0 * 26^2 + 0 * 26^1 + 0 * 26^0 = 17576
     * ZERTY = 25 * 26^4 + 4 * 26^3 + 17 * 26^2 + 19 * 26^1 + 24 * 26^0 = 11506714
     *
     * For this method:
     *   - use Math.pow to calculate the powers of 26.
     *   - don't assume that the input is in any particular case; use toUpperCase().
     *   - don't check that the input is only 'A' to 'Z'.
     *   - calculate the value of each digit relative to 'A'.
     *   - start from either the first or last character, and calculate the exponent based on the
     *     index of each character.
     *
     * @param coord The coordinate value in base 26 as described above. 
     * @return The numeric representation of the coordinate.
     */
    public static int coordAlphaToNum(String coord) {
        coord = coord.toUpperCase().trim();
        int digDistance;
        int numVal = 0;
        for(int m = 0; m < coord.length(); m++){

            digDistance = (int)coord.charAt(m) - 65;
            numVal = numVal + (digDistance * (int)Math.pow(26.0, (double)coord.length() - m -1)); 
        }


        return numVal; 
    }

    /**
     * This method converts an int value into a base (or radix) 26 number, where the digits are 
     * represented by the 26 letters of the Latin alphabet. That is, A represents 0, B represents 1,
     * C represents 2, ..., Y represents 24,  and Z represents 25. 
     * A couple of examples: 17576 is BAAA, 11506714 is ZERTY.
     *
     * The algorithm to convert an int to a String representing these base 26 numbers is as follows:
     * - Initialize res to the input integer
     * - The next digit is determined by calculating the remainder of res with respect to 26
     * - Convert this next digit to a letter based on 'A'
     * - Set res to the integer division of res and 26
     * - Repeat until res is 0
     *
     * @param coord The integer value to covert into an alpha coordinate.
     * @return The alpha coordinate in base 26 as described above. If coord is negative, an empty 
     *         string is returned.
     */
    public static String coordNumToAlpha(int coord) {
        int res = coord;
        int n = res;
        String alpha = "";
        do{
            n = 65 + ( res % 26);
            alpha = (char)n + alpha;
            res = res / 26;

        } while (res != 0);

        return alpha;
    }

    /**
     * Prompts the user for an integer value, displaying the following:
     *     "Enter the valName (min to max): "
     * Note: There should not be a new line terminating the prompt. valName should contain the 
     * contents of the String referenced by the parameter valName. min and max should be the values 
     * passed in the respective parameters.
     *
     * After prompting the user, the method will read an int from the console and consume an entire
     * line of input. If the value read is between min and max (inclusive), that value is returned.
     * Otherwise, "Invalid value." terminated by a new line is output and the user is prompted 
     * again. 
     *
     * @param sc The Scanner instance to read from System.in.
     * @param valName The name of the value for which the user is prompted.
     * @param min The minimum acceptable int value (inclusive).
     * @param min The maximum acceptable int value (inclusive).
     * @return Returns the value read from the user.
     */
    public static int promptInt(Scanner sc, String valName, int min, int max) {
        int userInt = 0;
        boolean valid = false;
        String input = "";
        do{
            System.out.print("Enter the " + valName + " (" + min + " to " + max + "): ");
           
            input = sc.next();
            
            input = input.replaceAll("[\\D]", "" );
            
            if (input.equals("")){
                System.out.println("Invalid value.");
            }else{
                userInt = Integer.parseInt(input);     



                if((userInt >= min) && (userInt <= max)){
                    valid = true;
                } else {
                    System.out.println("Invalid value.");
                }
            }

        } while (!valid);

        return userInt;
    }

    /**
     * Prompts the user for an String value, displaying the following:
     *     "Enter the valName (min to max): "
     * Note: There should not be a new line terminating the prompt. valName should contain the 
     * contents of the String referenced by the parameter valName. min and max should be the values 
     * passed in the respective parameters.
     *
     * After prompting the user, the method will read an entire line of input, trimming any trailing 
     * or leading whitespace. If the value read is (lexicographically ignoring case) between min and
     * max (inclusive), that value is returned. Otherwise, "Invalid value." terminated by a new line 
     * is output and the user is prompted again. 
     *
     * @param sc The Scanner instance to read from System.in.
     * @param valName The name of the value for which the user is prompted.
     * @param min The minimum acceptable String value (inclusive).
     * @param min The maximum acceptable String value (inclusive).
     * @return Returns the value read from the user.
     */
    public static String promptStr(Scanner sc, String valName, String min, String max) {
        String userStr = "";
        boolean valid = false;

        do{

            System.out.print("Enter the " + valName + " (" + min + " to " + max + "): ");
            userStr = sc.next();
            userStr = userStr.trim().toLowerCase();
            if((userStr.charAt(0) >= min.toLowerCase().charAt(0)) && (userStr.charAt(0) <= max.toLowerCase().charAt(0))){
                valid = true;
            } else {
                System.out.println("Invalid value.");
            }
        } while (!valid);

        return userStr;
    }

    /**
     * Prompts the user for an char value. The prompt displayed is the contents of the String 
     * referenced by the prompt parameter. 
     * Note: There should not be a new line terminating the prompt. 
     *
     * After prompting the user, the method will read an entire line of input and return the first
     * non-whitespace character in lower case.
     *
     * @param sc The Scanner instance to read from System.in
     * @param prompt The user prompt.
     * @return Returns the first non-whitespace character (in lower case) read from the user. If 
     *         there are no non-whitespace characters read, the null character is returned.
     */
    public static char promptChar(Scanner sc, String prompt) {
        String userCh = "n";
        boolean valid = false;
        do{
            System.out.print(prompt);
            if(sc.hasNext()){
                userCh = sc.next().toLowerCase();
                valid = true;
            }

        } while(!valid); 
        //System.out.println(userCh);
        return userCh.charAt(0);
    }

    /**
     * Initializes a game board so that all the entries are Config.WATER_CHAR.
     *
     * @param board The game board to initialize.
     */
    public static void initBoard(char board[][]) {

        for (int y = 0; y < board.length; ++y){

            for(int x = 0; x < board[0].length; ++x){
                board[y][x] = Config.WATER_CHAR;            
            }
        }

    }

    /**
     * Prints the game boards as viewed by the user. This method is used to print the 
     * game boards as the user is placing their ships and during the game play. 
     *
     * Some notes on the display:
     *   - Each column printed will have a width of Config.MAX_COL_WIDTH.
     *   - Each row is followed by an empty line.
     *   - The values in the headers and cells are to be right justified.
     *
     * @param board The board to print.
     * @param caption The board caption.
     */
    public static void printBoard(char board[][], String caption) {
        System.out.println(caption);
        for (int i = 0; i < 1; i++){ //y- axis
            System.out.print(" " + " " + " "); // labels y-axis
            for (int j = 0; j < board[0].length; j++){ //x-axis
                System.out.print(" " + " " +  ((char)(j + 65)));

            }
            System.out.println();

        }

        for (int y = 0; y < board.length; y++){ //y- axis
            System.out.print(" " + " " + y); // labels y-axis
            for (int x = 0; x < board[0].length; x++){ //x-axis
                System.out.print(" " + " " + board[y][x]);

            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * Determines if a sequence of cells of length len in a game board is clear or not. This is used
     * to determine if a ship will fit on a given game board. The x and y coordinates passed in as 
     * parameters represent the top-left cell of the ship when considering the grid.
     * 
     * @param board The game board to search.
     * @param xcoord The x-coordinate of the top-left cell of the ship.
     * @param ycoord The y-coordinate of the top-left cell of the ship.
     * @param len The length of the ship.
     * @param dir true if the ship will be vertical, otherwise horizontal
     * @return 1 if the cells to be occupied by the ship are all Config.WATER_CHAR, 
     *         -1 if the cells to be occupied are not Config.WATER_CHAR, and
     *         -2 if the ship would go out-of-bounds of the board.
     */
    public static int checkWater(char board[][], int xcoord, int ycoord, int len, boolean dir) {
        //FIXME

        /*The ship starts at (ycoord, xcoord) , 
         * If dir == true, the ship is vertical
         *  look from ycoord to (ycoord + len)
         *  
         */

        if (dir ==  true){ //ship is vertical
            for(int y = ycoord; y < ycoord + len; y++){ //Check for water starting at [y,x] to [y+len, x] 
                if ((y >= 0) && (y < board.length)){
                    if(board[y][xcoord] != Config.WATER_CHAR){ //checks to see if cell contains water
                        return -1; 

                    } 
                } else {
                    return -2;

                }
            }
        } else {
            for(int x = xcoord; x < xcoord + len; x++){ //Check for water starting at [y,x] to [y+len, x] 
                if ((x >= 0) && (x < board[0].length)){
                    if(board[ycoord][x] != Config.WATER_CHAR){ //checks to see if cell contains water
                        return -1; 

                    } 
                } else {
                    return -2;

                }
            }
        }

        return 1;

    }

    /**
     * Checks the cells of the game board to determine if all the ships have been sunk.
     *
     * @param board The game board to check.
     * @return true if all the ships have been sunk, false otherwise.
     */
    public static boolean checkLost(char board[][]) {
        boolean shipsGone = false;




        for (int y = 0; y < board.length; y++){
            for (int x = 0; x < board[0].length; x++){
                if (checkWater(board, x, y, 1, true) == -1){
                    if (board[y][x] != Config.HIT_CHAR){
                        shipsGone = false;
                        return shipsGone;
                    } else {
                        shipsGone = true;

                    }

                }

            }

        }

        return shipsGone;
    }

    /**
     * Places a ship into a game board. The coordinate passed in the parameters xcoord and ycoord
     * represent the top-left coordinate of the ship. The ship is represented on the game board by
     * the Character representation of the ship id. (For this method, you can assume that the id
     * parameter will only be values 1 through 9.)
     *
     * @param board The game board to search.
     * @param xcoord The x-coordinate of the top-left cell of the ship.
     * @param ycoord The y-coordinate of the top-left cell of the ship.
     * @param len The length of the ship.
     * @param dir true if the ship will be vertical, otherwise horizontal.
     * @param id The ship id, assumed to be 1 to 9.
     * @return false if the ship goes out-of-bounds of the board, true otherwise.
     */
    public static boolean placeShip(char board[][], int xcoord,
        int ycoord, int len, boolean dir, int id) {

        char ship = (char)(id + 48);

        if (dir ==  true){ //ship is vertical
            for(int y = ycoord; y < ycoord + len; y++){ //Check for water starting at [y,x] to [y+len, x] 
                if ((y >= 0) && (y < board.length)){ //IF INBOUNDS
                    if(board[y][xcoord] == Config.WATER_CHAR){ //checks to see if cell contains water,

                        board[y][xcoord] = ship; 
                    }

                } else { //if out of bounds
                    return false;

                }
            }
        } else { //HORIZONTAL
            for(int x = xcoord; x < xcoord + len; x++){ //Check for water starting at [y,x] to [y+len, x] 
                if ((x >= 0) && (x < board[0].length)){ //IF INBOUNDS
                    if(board[ycoord][x] == Config.WATER_CHAR){ //checks to see if cell contains water
                        board[ycoord][x] = ship;
                    }

                } else { //if out of bounds
                    return false;

                }
            }
        }
        return true;
    }

    /**
     * Randomly attempts to place a ship into a game board. The random process is as follows:
     *   1 - Pick a random boolean, using rand. True represents vertical, false horizontal.
     *   2 - Pick a random integer, using rand, for the x-coordinate of the top-left cell of the 
     *       ship. The number of integers to choose from should be calculated based on the width of
     *       the board and length of the ship such that the placement of the ship won't be 
     *       out-of-bounds.
     *   3 - Pick a random integer, using rand, for the y-coordinate of the top-left cell of the 
     *       ship. The number of integers to choose from should be calculated based on the height of
     *       the board and length of the ship such that the placement of the ship won't be 
     *       out-of-bounds.
     *   4 - Verify that this random location can fit the ship without intersecting another ship 
     *       (checkWater method). If so, place the ship with the placeShip method.
     *
     * It is possible for the configuration of a board to be such that a ship of a given length may
     * not fit. So, the random process will be attempted at most Config.RAND_SHIP_TRIES times.
     * 
     * @param board The game board to search.
     * @param len The length of the ship.
     * @param id The ship id, assumed to be 1 to 9..
     * @param rand The Random object.
     * @return true if the ship is placed successfully, false otherwise.
     */
    public static boolean placeRandomShip(char board[][], int len, int id, Random rand) {
        for (int i = 0; i < Config.RAND_SHIP_TRIES; i++){
            
            //rand.setSeed(Config.SEED);
            boolean dir = rand.nextBoolean(); //random direction
            int xcoord = rand.nextInt(board[0].length) ; //random xcoord
            int ycoord = rand.nextInt(board.length); //random y coord
            
            int res = checkWater(board, xcoord, ycoord, len, dir); // check if cell is available

            if(res == 1){
                placeShip(board, xcoord, ycoord, len, dir, id);
                return true;
            }

        }
        return false;
    }

    /**
     * This method interacts with the user to place a ship on the game board of the human player and
     * the computer opponent. The process is as follows:
     *   1 - Print the user primary board, using the printBoard.
     *   2 - Using the promptChar method, prompt the user with "Vertical or horizontal? (v/h) ".
     *       A response of v is interpreted as vertical. Anything else is assumed to be horizontal.
     *   3 - Using the promptInt method, prompt the user for an integer representing the 
     *       "ship length", where the minimum ship length is Config.MIN_SHIP_LEN and the maximum 
     *       ship length is width or height of the game board, depending on the input of the user 
     *       from step 1.
     *   4 - Using the promptStr method, prompt the user for the "x-coord". The maximum value
     *       should be calculated based on the width of the board and the length of the ship. You 
     *       will need to use the coordAlphaToNum and coordNumToAlpha methods to covert between int
     *       and String values of coordinates.
     *   5 - Using the promptInt method, prompt the user for the "y-coord". The maximum value
     *       should be calculated based on the width of the board and the length of the ship.
     *   6 - Check if there is space on the board to place the ship. 
     *     6a - If so:
     *             - Place the ship on the board using placeShip. 
     *             - Then, call placeRandomShip to place the opponents ships of the same length.
     *             - If placeRandomShip fails, print out the error message (terminated by a new 
     *               line): "Unable to place opponent ship: id", where id is the ship id, and 
     *               return false.
     *     6b - If not:
     *             - Using promptChar, prompt the user with "No room for ship. Try again? (y/n): "
     *             - If the user enters a 'y', restart the process at Step 1. 
     *             - Otherwise, return false.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param boardPrime The human player board.
     * @param boardOpp The opponent board.
     * @param id The ship id, assumed to be 1 to 9.
     * @param rand The Random object.
     * @return true if ship placed successfully by player and computer opponent, false otherwise.
     */
    public static boolean addShip(Scanner sc, char boardPrime[][], char boardOpp[][], int id,
        Random rand) {


        char again = ' ';
        boolean quit = false;
        do{
            printBoard(boardPrime, "My Ships:");
            char dir = promptChar(sc, "Vertical or horizontal? (v/h): "); //get dir of ship
            boolean dirx; 
            if (dir == 'v'){
                dirx = true;
            }else{
                dirx = false;
            }

            int maxDirLen = 0;//get max length of ship depending on direction 
            if (dirx == true){
                maxDirLen = boardPrime.length;

            } else{
                maxDirLen = boardPrime[0].length;

            }
            //Get length of ship from user
            int len = promptInt(sc, "ship length", Config.MIN_SHIP_LEN, maxDirLen);
            String xcoord = "A";
            int ycoord = 0;

            if (dirx == true){
                xcoord = promptStr(sc, "x-coord", coordNumToAlpha(0), coordNumToAlpha(boardPrime[0].length - 1));
                ycoord = promptInt(sc, "y-coord", 0, (boardPrime.length - len) );
            } else {
                xcoord = promptStr(sc, "x-coord", coordNumToAlpha(0), coordNumToAlpha(boardPrime[0].length - len));
                ycoord = promptInt(sc, "y-coord", 0, (boardPrime.length - 1) );   
            }

            int res = checkWater(boardPrime, coordAlphaToNum(xcoord), ycoord, len, dirx);
            //boolean placed = ;
            if (res == 1){ //the target cell is water
                placeShip(boardPrime, coordAlphaToNum(xcoord), ycoord, len, dirx, id  );
                
                boolean placed = placeRandomShip(boardOpp, len, rand.nextInt(9) + 1, rand);
                if(placed == true){
                    return true;
                }else{
                    System.out.println("Unable to place opponent ship: " + id);
                }
            }else {
                again = promptChar(sc, "No room for ship. Try again? (y/n): ");
                if (again == 'y'){

                }else{
                    quit = true;
                }


            }
        }while(!quit);


        return false;
    }

    /**
     * Checks the state of a targeted cell on the game board. This method does not change the 
     * contents of the game board.
     *
     * @return  3 if the cell was previously targeted.
     *          2 if the shot would be a miss.
     *          1 if the shot would be a hit.
     *         -1 if the shot is out-of-bounds.
     */
    public static int takeShot(char[][] board, int x, int y) {
        int shot = checkWater(board, x, y, 1, true );

        if (shot == 1){
            return 2;

        } else if(shot == -1){
            if (board[y][x] == Config.MISS_CHAR){
                return 3;

            }else{
                return 1;

            }

        } else if(shot == -2){
            return -1;

        }

        return 0;
    }

    /**
     * Interacts with the user to take a shot. The procedure is as follows:
     *   1 - Using the promptStr method, prompt the user for the "x-coord shot". The maximum value
     *       should be based on the width of the board. You will need to use the coordAlphaToNum 
     *       and coordNumToAlpha methods to covert between int and String values of coordinates.
     *   2 - Using the promptInt method, prompt the user for the "y-coord shot". The maximum value
     *       should be calculated based on the width of the board.
     *   3 - Check the shot, using the takeShot method. If it returns:
     *        -1: Print out an error message "Coordinates out-of-bounds!", terminated by a new line.
     *         3: Print out an error message "Shot location previously targeted!", terminated by a
     *            new line.
     *         1 or 2: Update the cells in board and boardTrack with Config.HIT_CHAR or 
     *                 Config.MISS_CHAR accordingly.
     *   This process should repeat until the takeShot method returns 1 or 2.
     *
     * @param sc The Scanner instance to read from System.in.
     * @param board The computer opponent board (containing the ship placements).
     * @param boardTrack The human player tracking board.
     */
    public static void shootPlayer(Scanner sc, char[][] board, char[][] boardTrack) {
        //FIXME
        int x = 0;

        int y = 0;

        int hit = 0;

        do {
            x =  coordAlphaToNum( promptStr(sc, "x-coord shot", coordNumToAlpha(0), coordNumToAlpha(board[0].length - 1)));

            y = promptInt(sc, "y-coord shot", 0, board.length - 1);

            hit = takeShot(board, x, y );

            if ( hit == -1){
                System.out.println("Coordinates out-of-bounds!");

            } else if (hit == 3){
                System.out.println("Shot location previously targeted!");

            }

        } while( (hit == -1) || (hit == -3));

        if (hit == 1){
            boardTrack[y][x] = Config.HIT_CHAR;
            board[y][x] = Config.HIT_CHAR;

        } else if (hit == 2){
            boardTrack[y][x] = Config.MISS_CHAR;
            board[y][x] = Config.MISS_CHAR;
        }

    }






    /**
     * Takes a random shot on the game board. The random process works as follows:
     *   1 - Pick a random valid x-coordinate
     *   2 - Pick a random valid y-coordinate
     *   3 - Check the shot, using the takeShot method. 
     *   This process should repeat until the takeShot method returns 1 or 2, then update the cells
     *   in board with Config.HIT_CHAR or Config.MISS_CHAR accordingly.
     *
     * Note: Unlike the placeRandomShip method, this method continues until it is successful. This
     * may seem risky, but in this case the random process will terminate (find an untargeted cell)
     * fairly quickly. For more details, see the appendix of the Big Program 1 subject.
     *
     * @param rand The Random object.
     * @param board The human player game board.
     */
    public static void shootComputer(Random rand, char[][] board) {
        //FIXME
        int x = 0;

        int y = 0;

        int hit = 0;

        do {
            x =  rand.nextInt(board[0].length - 1);

            y = rand.nextInt(board.length);

            hit = takeShot(board, x, y );

        } while( (hit == -1) || (hit == -3));

        if (hit == 1){
            board[y][x] = Config.HIT_CHAR;

        } else if (hit == 2){
            board[y][x] = Config.MISS_CHAR;

        }



    }

    /**
     * This is the main method for the Battleship game. It consists of the main game and play again
     * loops with calls to the various supporting methods. When the program launches (prior to the 
     * play again loop), a message of "Welcome to Battleship!", terminated by a newline, is 
     * displayed. After the play again loop terminates, a message of "Thanks for playing!", 
     * terminated by a newline, is displayed.
     *
     * The Scanner object to read from System.in and the Random object with a seed of Config.SEED 
     * will be created in the main method and used as arguments for the supporting methods as 
     * required.
     *
     * Also, the main method will require 3 game boards to track the play:
     * - One for tracking the ship placement of the user and the shots of the computer, called the
     *   primary board with a caption of "My Ship". 
     * - One for displaying the shots (hits and misses) taken by the user, called the tracking board
     *   with a caption of "My Shots"; and one for tracking the ship placement of the computer and 
     *   the shots of the user. 
     * - The last board is never displayed, but is the primary board for the computer and is used to
     *   determine when a hit or a miss occurs and when all the ships of the computer have been 
     *   sunk. 
     * Notes:
     *   - The size of the game boards are determined by the user input.  
     *   - The game boards are 2d arrays that are to be viewed as row-major order. This means that 
     *     the first dimension represents the y-coordinate of the game board (the rows) and the 
     *     second dimension represents the x-coordinate (the columns).
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        //FIXME
        //Make sure code looks professional before submitting for Milestone 3
        //Comments and Style
        
        
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random(Config.SEED);

        char userChar = 'y';

        //Title
        System.out.println("Welcome to Battleship!");
        do{
            //get dimensions for game board(s) 
            int y = promptInt(scnr, "board height", Config.MIN_HEIGHT, Config.MAX_HEIGHT);
            int x = promptInt(scnr, "board width", Config.MIN_WIDTH, Config.MAX_WIDTH);
            System.out.println();

            //Creates 3 game boards
            char [][] userBoard = new char[y][x]; //my ships
            char [][] scoreKeeperBoard = new char[y][x]; //my hit or misses
            char [][] compBoard = new char[y][x]; //never showed, but is where the computer's ships are

            //fills each with water
            initBoard(userBoard); // my ships
            initBoard(scoreKeeperBoard); //my hit or misses
            initBoard(compBoard); //never showed, but is where computer's ships are

            //Gets number of ships
            int numShips = promptInt(scnr, "number of ships", Config.MIN_SHIPS, Config.MAX_SHIPS);

            for(int n = 0; n < numShips; n++){
                int id = n + 1;
                addShip(scnr, userBoard, compBoard, id, rand );
                //  printBoard(userBoard, "My ships:");

            }

            boolean winner = false;

            do{
                printBoard(userBoard, "My Ships:");

                printBoard(scoreKeeperBoard, "My Shots:");

                shootPlayer(scnr, compBoard, scoreKeeperBoard);

                if (checkLost(compBoard) == true){
                    System.out.println("Congratulations, you sunk all the computer's ships!");

                    printBoard(userBoard, "My Ships:");

                    printBoard(scoreKeeperBoard, "My Shots:");

                    winner = true;
                } else{
                    shootComputer(rand, userBoard); 
                    if(checkLost(userBoard) == true){
                        System.out.println("Oh no!, The computer sunk all your ships!");

                        winner = true;
                    }

                }



            } while(!winner);

            //End of program
            userChar = promptChar(scnr, "Would you like to play again? (y/n): ");
        } while((userChar == 'y') || (userChar == 'Y'));


        System.out.println("Thanks for playing!");
        scnr.close();
    }
}


