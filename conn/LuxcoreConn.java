package com.minermonitor.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.minermonitor.config.Configuration;
import com.minermonitor.model.LuxCore;


public class LuxcoreConn {
	private static final Logger LOGGER = Logger.getLogger(LuxcoreConn.class.getName());
	private static final Configuration conf = new Configuration();
	public LuxCore conn() {
		LuxCore luxCore = null;
		try {
		 	LOGGER.info("Do Get Web Content from explorer.luxcore.io");
		 	String wallet = conf.getLuxWallet();
			URL url = new URL("https://explorer.luxcore.io/address/"+wallet);	  	
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			conn.setRequestProperty("user-agent", "");

			if (conn.getResponseCode() != HttpsURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			
			String output;
			String htmlString = "";
			while ((output = br.readLine()) != null) {
				htmlString += output;
			}
		//	System.out.println(jsonString);
			int beginIndex = htmlString.indexOf("<table class=\"table table-bordered table-striped summary-table table-responsive\">");
			int endIndex = htmlString.indexOf("</table>", beginIndex);
			 String table = htmlString.substring(beginIndex, endIndex);
			 Document doc = Jsoup.parse(table);
			 Elements td_tags = doc.select("td");
			 String[] data = new String[3];
			 int index = 0;
			 for (Element td : td_tags) {
				 data[index] = td.text();
				 index++;
			}
			
			// mapping
			 luxCore = new LuxCore(Double.parseDouble(data[0]),Double.parseDouble(data[1]),Double.parseDouble(data[2]));
			conn.disconnect();
			LOGGER.info("Get Web Content from explorer.luxcore.io Success");
		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return luxCore;
	}
}
