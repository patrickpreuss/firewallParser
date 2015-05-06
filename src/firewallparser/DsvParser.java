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
  
  // constructor
  /**
   * 
   * @param Data      the string data that needs parsing.
   * @param Character the character used as the delimiter.
   */
  public DsvParser(String Data, String Character){
      parseData = Data;
      delimeter = Character;
  }
  // methods

  public String[][] setUpMyArray(){
    myArray = new String[33][9];
    Scanner scanIn;
    int rowCount = 0;
    int Row = 0;
    int colCount = 0;
    int Col = 0;

    System.out.println("\n ****** Setup Array ******"); // Debug

    try{
      
      // setup a scanner
      scanIn = new Scanner(parseData);
      
      while (scanIn.hasNextLine()){
        // split the inputline into an array at the char
          String[] tempArray = scanIn.nextLine().split("\\|");
        // copy the content of the inArray to the myArray
        for (colCount = 0; colCount < tempArray.length; colCount++){
            myArray[rowCount][colCount] = tempArray[colCount];
        }
        // Increment the row in the array
        rowCount++;
      }
    
    } catch (Exception e){
        System.out.println(e); // Debug
      }

    return myArray;
  }
}
