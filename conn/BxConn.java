package com.minermonitor.conn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.minermonitor.model.Bx;
import com.minermonitor.model.Coin;
import com.minermonitor.model.Spread;

public class BxConn {
	private static final Logger LOGGER = Logger.getLogger(BxConn.class.getName());
	public Bx conn (Coin coin) {
		Bx bx = null;
		 try {
			 	LOGGER.info("Do Get API Message from bx.in.th");
				URL url = new URL("https://bx.in.th/api/");	  	
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
				JSONObject obj = new JSONObject(jsonString).getJSONObject(String.valueOf(coin.id()));
				
				// mapping
				bx = new Bx();
				bx.setLastPrice(obj.getDouble("last_price"));
				bx.setVolume24hours(obj.getDouble("volume_24hours"));
				bx.setChange(obj.getDouble("change"));
				bx.setPrimaryCurrency(obj.getString("primary_currency"));
				bx.setSecondaryCurrency(obj.getString("secondary_currency"));
				JSONObject asks = obj.getJSONObject("orderbook").getJSONObject("asks");
				JSONObject bids = obj.getJSONObject("orderbook").getJSONObject("bids");
				bx.setAsks(new Spread(asks.getDouble("volume"), asks.getLong("total"), asks.getDouble("highbid")));
				bx.setBids(new Spread(bids.getDouble("volume"), bids.getLong("total"), bids.getDouble("highbid")));
				conn.disconnect();
				LOGGER.info("Get API Message from bx.in.th Success");
			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
		return bx;
	}
}
