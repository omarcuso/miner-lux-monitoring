package com.minermonitor.conn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.minermonitor.config.Configuration;


public class LineConn {
	
	private static final Logger LOGGER = Logger.getLogger(LineConn.class.getName());
	private static final Configuration conf = new Configuration();
	public void sendNotify(String message) {
		try {
		
		LOGGER.info("Sending Notify Message ...");
		String token = conf.getLineToken();
		URL url = new URL("https://notify-api.line.me/api/notify");
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.addRequestProperty("Authorization", "Bearer "+token);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setConnectTimeout(5000);
		LOGGER.info("Line Message");
		LOGGER.info(message);
		String parameterString = new String("message=" + message);
		PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
		printWriter.print(parameterString);
		printWriter.close();


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
		
		if (obj.getInt("status") != HttpsURLConnection.HTTP_OK || !obj.getString("message").equalsIgnoreCase("ok")) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
        conn.disconnect();
        
		}catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}
}
