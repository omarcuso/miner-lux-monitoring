package com.minermonitor.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.minermonitor.model.Coin;
import com.minermonitor.model.Cryptopia;

public class CryptopiaConn {
	private static final Logger LOGGER = Logger.getLogger(CryptopiaConn.class.getName());
	public Cryptopia conn (Coin coin) {
		Cryptopia cryptopia = null;
		 try {
			 	LOGGER.info("Do Get API Message from cryptopia.co.nz ...");
			  	URL url = new URL("https://www.cryptopia.co.nz/api/GetMarket/"+coin.toString()+"_BTC");
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
				JSONObject obj = new JSONObject(jsonString).getJSONObject("Data");
				// mapping
				cryptopia = new Cryptopia(obj.getString("Label"),obj.getDouble("AskPrice"), obj.getDouble("BidPrice"),
						obj.getDouble("Low"), obj.getDouble("High"), obj.getDouble("Volume"), obj.getDouble("LastPrice"),
						obj.getDouble("BuyVolume"), obj.getDouble("SellVolume"), obj.getDouble("Change"), obj.getDouble("Open"),
						obj.getDouble("Close"), obj.getDouble("BaseVolume"), obj.getDouble("BuyBaseVolume"), obj.getDouble("SellBaseVolume"));conn.disconnect();
				LOGGER.info("Get API Message from cryptopia.co.nz Success");
				
			  } catch (MalformedURLException e) {
				 LOGGER.warning("Get API Message from cryptopia.co.nz Error");
				e.printStackTrace();

			  } catch (IOException e) {
				  LOGGER.warning("Get API Message from cryptopia.co.nz Error");
				e.printStackTrace();

			  }
		return cryptopia;
	}
}
