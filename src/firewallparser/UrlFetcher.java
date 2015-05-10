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
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import org.apache.commons.io.IOUtils; // Used but not imported

/**
 *<h1> Parse Digital Life Firewall URL</h1>
 * Returns an array of strings. Each element is a line from the firewall
 * metrics web site. The URL should return in the format below. Where 
 * each new firewall has 3 lines:
 * <p>
 * Host Name|Domain|Current Value|Current Timestamp|Max Value|Max Timestamp|Metric Type|Data Type|Index Name| <p>
 * gaalxbm12a-diglife_1|Bastion|2|2015-05-05 03:25:48|100|2012-08-23 00:00:00|Checkpoint_Firewall-Cpu|Cpu|| <p>
 * gaalxbm12a-diglife_1|Bastion|35|2015-05-05 03:25:48|35|2015-05-05 03:25:48|CheckPoint_Firewall-Memory|Memory|| <p>
 * gaalxbm12a-diglife_1|Bastion|465548|2015-05-05 03:25:48|691297|2015-03-29 06:00:57|CheckPoint_Firewall-Sessions|Sessions|| <p>
 * 
 * @author Zachary Norris <zn924a@att.com><znorris@gmail.com>
 */
public class UrlFetcher {

  // attributes or fields
  private final String inputUrl;
  // constructors
  /**
   * @param   url an absolute URL that returns the current firewall metrics.
   */
  public UrlFetcher (String url) {
    inputUrl = url;
  }

  // methods
  /**
   * Returns an the web page source code as a string.
   * @return      a string of the web page source.
   */
  public String getUrlSource() throws Exception {
    URL oracle = new URL(inputUrl);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
    return org.apache.commons.io.IOUtils.toString(in);
  }
}
