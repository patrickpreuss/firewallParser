/*
 * The MIT License
 *
 * Copyright 2015 Zachary Norris <zn924a@att.com><znorris@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package firewallparser;

import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Takes in a string, where the string contains delimiter-separated values. 
 * Returns a two dimensional array, where each line is an array and each of 
 * the delimited values is an element of that array.
 * @author Zachary Norris <zn924a@att.com><znorris@gmail.com>
 */
public class DsvParser {
    
  // attributes or fields
  private final String parseData;
  private final String delimeter; 
  static String[][] myArray;
  int col = 0;
  int row = 0;
  
// constructor
  /**
   * 
   * @param Data      the string data that needs parsing.
   * @param Character the character used as the delimiter.
   */
  public DsvParser(String Data, String Character){
      parseData = Data;
      delimeter = Character;
      
      try{
        Scanner myScanner = new Scanner(parseData);
        /* Count the number of delimiters in the first line. This will give us 
         * the number of columns the array needs. Then count all the rows that
         * aren't empty and make that the number of rows the array needs.
         */
        
        String line = myScanner.nextLine();
        col += new StringTokenizer(line, "|").countTokens();

        while (myScanner.hasNextLine()){
          if (myScanner.nextLine().matches(".*(ga|tx).*")){
            row++;
            //System.out.println(myScanner)
          }
        }
        myScanner.close();

      } catch(Exception e){
        System.out.println(e); // Debug
      }
      //System.out.println("Col" + col); // Debug
      //System.out.println("Row" + row); // Debug
  
  }
  // methods

  public String[][] setUpMyArray(){
    myArray = new String[row][col];
    Scanner scanIn;
    int rowCount = 0;
    int colCount = 0;

    System.out.println("\n ****** Setup Array ******"); // Debug

    try{
      
      // setup a scanner
      scanIn = new Scanner(parseData);
      
      while (scanIn.hasNextLine()){
        // split the inputline into an array at the char
        String[] tempArray = scanIn.nextLine().split("\\|");
        // Copy this tempArray into myArray if the first element is a GA or TX
        // hostname.
        if (tempArray[0].matches(".*(ga|tx).*")){
          for (colCount = 0; colCount < tempArray.length; colCount++){
            myArray[rowCount][colCount] = tempArray[colCount];
          }
          // Increment the row in the array
          rowCount++;
        }
      }
    scanIn.close();
    } catch (Exception e){
        //System.out.println(e); // Debug
      }

    return myArray;
  }
}
