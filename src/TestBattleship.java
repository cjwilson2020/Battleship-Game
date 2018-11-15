/**
 * This file contains testing methods for the Battleship project. These methods are intended to 
 * provide an example of a way to incrementally test your code, and to provide example method calls
 * for the Battleship methods
 *
 * Toward these objectives, the expectation is that part of the grade for the Battleship project is 
 * to write some tests and write header comments summarizing the tests that have been written. 
 * Specific places are noted with FIXME but add any other comments you feel would be useful.
 */

import java.util.Random;
import java.util.Scanner;

/**
 * This class contains a few methods for testing methods in the Battleship
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 * 
 * @author Marc Renault
 * @author FIXME add your name here when you add test
 *
 */
public class TestBattleship {

    /**
     * This is the main method that runs the various tests. Uncomment the tests when
     * you are ready for them to run.
     * 
     * @param args (unused)
     */
    public static void main(String[] args) {
        // Milestone 1
        //        char x = '�';
        //        char w = '�';
        //        System.out.println((int)x);
        //        System.out.println((int)w);
        testCoordAlphaToNum();
        testCoordNumToAlpha();
        // Milestone 2
         testCheckWater();
         testPlaceShip();
         
         testPrintBoard();
        // Milestone 3
        //  testTakeShot();
        //  testCheckLost();
         
         testRand();
    }

    private static void testCoordAlphaToNum() {
        int numTests = 6;
        int passed = numTests;
        int res;
        if((res = Battleship.coordAlphaToNum("BAAA")) != 17576) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"BAAA\") != 17576, but " + res);
            passed--;
        }
        if((res = Battleship.coordAlphaToNum("ZERTY")) != 11506714) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"ZERTY\") != 11506714, but " + res);
            passed--;
        }
        if((res = Battleship.coordAlphaToNum("zerty")) != 11506714) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"zerty\") != 11506714, but " + res);
            passed--;
        }
        if((res = Battleship.coordAlphaToNum("&é\"")) != -14747) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"&é\\\"\") != -14747, but " + res);
            passed--;
        }
        if((res = Battleship.coordAlphaToNum("circle")) != 27718994) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"circle\") != 27718994, but " + res);
            passed--;
        }
        if((res = Battleship.coordAlphaToNum("CIRCLE")) != 27718994) {
            System.out.println("FAILED: Battleship.coordAlphaToNum(\"CIRCLE\") != 27718994, but " + res);
            passed--;
        }
        System.out.println("testCoordAlphatoNum: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testCoordNumToAlpha() {
        //FIXME
        int numTests = 3;
        int passed = numTests;
        String res;
       
        
        if(!(res = Battleship.coordNumToAlpha(17576)).contentEquals("BAAA")) {
            System.out.println("FAILED: Battleship.coordNumToAlpha(\"17576\") != BAAA, but " + res);
            passed--;
        }
        if(!(res = Battleship.coordNumToAlpha(11506714)).contentEquals("ZERTY")) {
            System.out.println("FAILED: Battleship.coordNumToAlpha(\"11506714\") != ZERTY, but " + res);
            passed--;
        }
        if(!(res = Battleship.coordNumToAlpha(27718994)).contentEquals("CIRCLE")) {
            System.out.println("FAILED: Battleship.coordNumToAlpha(\"27718994\") != CIRCLE, but " + res);
            passed--;
        }
        System.out.println("testCoordNumToAlpha: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testCheckWater() {
        //FIXME
        int numTests = 5;
        int passed = numTests;
        int res;
        //Scanner scr = new Scanner(System.in);
        char [][] board = new char[12][8];
        Battleship.initBoard(board);
                                   
        if((res = Battleship.checkWater(board, 6, 5, 1, false)) != 1){
            System.out.println("FAILED: Battleship.checkWater(board, 6, 5, 1, false)) != 1, but " + res);
            passed--;
        }
        if((res = Battleship.checkWater(board, 3, 4, 11, false)) != -2){
            System.out.println("FAILED: Battleship.checkWater(board, 3, 4, 11, false)) != -2, but " + res);
            passed--;
        }
        if((res = Battleship.checkWater(board, 2, 7, 3, true)) != 1){
            System.out.println("FAILED: Battleship.checkWater(board, 2, 7, 3, true) != 1, but " + res);
            passed--;
        }
        if((res = Battleship.checkWater(board, 6, 11, 5, true)) != -2){
            System.out.println("FAILED: Battleship.checkWater(board, 6, 11, 5, true)) != -2, but " + res);
            passed--;
        }
        if((res = Battleship.checkWater(board, 4, 3, 2, false)) != 1){
            System.out.println("FAILED: Battleship.checkWater(board, 4, 3, 2, false)) != 1, but " + res);
            passed--;
        }      
        
        System.out.println("testCheckWater: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testPlaceShip() {
        //FIXME
        int numTests = 5;
        int passed = numTests;
        boolean res;
        //Scanner scr = new Scanner(System.in);
        char [][] board = new char[3][3];
        Battleship.initBoard(board);
                                   
        if((res = Battleship.placeShip(board, 0, 0, 3, false, 5)) != true){
            System.out.println("FAILED: Battleship.placeShip(board, 0, 0, 3, false, 5)) != true, but " + res);
            passed--;
        }
        if((res = Battleship.placeShip(board, 0, 0, 3, true, 3)) != true){
            System.out.println("FAILED: Battleship.placeShip(board, 0, 0, 3, true, 3)) != true, but " + res);
            passed--;
        }
        if((res = Battleship.placeShip(board, 2, 2, 1, true, 9)) != true){
            System.out.println("FAILED: Battleship.placeShip(board, 2, 2, 1, true, 9)) != true, but " + res);
            passed--;
        }
        if((res = Battleship.placeShip(board, 0, 0, 4, true, 4)) != false){
            System.out.println("FAILED: Battleship.placeShip(board, 0, 0, 4, true, 2)) != false, but " + res);
            passed--;
        }
        if((res = Battleship.placeShip(board, 0, 1, 2, false, 8)) != true){
            System.out.println("FAILED: Battleship.placeShip(board, 0, 1, 2, false, 8)) != true, but " + res);
            passed--;
        }      
        
        System.out.println("testPlaceShip: Passed " + passed + " of " + numTests + " tests.");
    }

    private static void testPrintBoard(){
        char [][] board = new char[4][3];
        Battleship.initBoard(board);
        
        Battleship.printBoard(board, "Yes");
    }
    
    private static void testTakeShot() {
        System.out.println("When board is");
        
        char [][] board = new char[4][4];
        
     //   Battleship.addShip(Scanner sc = new Scanner("45"), board, boardOpp, id, rand);
        
        
        
        
        Battleship.takeShot(board, 2, 0);
    }

    private static void testCheckLost() {
        //FIXME
        char [][] board = new char [4][4];
        System.out.println(Battleship.checkLost(board));
    }


    private static void testRand() {
        Random rand = new Random(Config.SEED);
        
        for (int x = 0; x < 30; x++){
            
            System.out.println(rand.nextInt(9));
        }
    }

}


