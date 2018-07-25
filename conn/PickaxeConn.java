package com.minermonitor.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.minermonitor.model.Pickaxe;

public class PickaxeConn {
	private static final Logger LOGGER = Logger.getLogger(PickaxeConn.class.getName());
	public Pickaxe conn (String wallet) {
		Pickaxe pickaxe = null;
		 try {
			 	LOGGER.info("Do Get API Message from pickaxe.pro ...");
			  	URL url = new URL("https://pickaxe.pro/api/wallet?address="+wallet);
				HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("user-agent", "");

				if (conn.getResponseCode() != HttpsURLConnection.HTTP_OK) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
				
				String output;
				String jsonString = "";
				while ((output = br.readLine()) != null) {
					jsonString += output;
				}
				
				JSONObject obj = new JSONObject(jsonString);
				// mapping
				pickaxe = new Pickaxe(obj.getString("currency"),obj.getDouble("unsold"),obj.getDouble("balance"),obj.getDouble("unpaid"),obj.getDouble("paid24h"),obj.getDouble("total"));
				conn.disconnect();
				LOGGER.info("Get API Message from pickaxe.pro Success");
				
			  } catch (MalformedURLException e) {
				 LOGGER.warning("Get API Message from pickaxe.pro Error");
				e.printStackTrace();

			  } catch (IOException e) {
				  LOGGER.warning("Get API Message from pickaxe.pro Error");
				e.printStackTrace();

			  }
		return pickaxe;
	}
}
