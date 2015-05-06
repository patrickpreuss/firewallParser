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
import java.util.Arrays;

/**
 * Retrieves the Digital Life production Firewall metrics
 * 
 * @author Zachary Norris <zn924a@att.com><znorris@gmail.com>
 */
public class FirewallUpdater {
  static final String url = "https://elmdashboard.web.att.com/cgi-bin/reports/diglife.php?q=metrics";

  public static void main(String[] args) throws Exception {
    // Grab url https://elmdashboard.web.att.com/cgi-bin/reports/diglife.php?q=metrics
    // parse data into array of arrays
    // place into DB?
    
    // Create UrlParser Object
    UrlParser Parser = new UrlParser(url);

    DsvParser dsv = new DsvParser(Parser.getUrlSource(), "|");
    System.out.println(Arrays.deepToString(dsv.setUpMyArray()));
  }
}
