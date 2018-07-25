package com.minermonitor.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	Properties prop = null;
	private String luxWallet;
	private String lineToken;
	
	public Configuration() {
		Properties prop = new Properties();
		try {
			InputStream  input = getClass().getResourceAsStream("config.properties");
			prop.load(input);
			setLuxWallet(prop.getProperty("luxWallet"));
			setLineToken(prop.getProperty("lineToken"));
		
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getLuxWallet() {
		return luxWallet;
	}

	public void setLuxWallet(String luxWallet) {
		this.luxWallet = luxWallet;
	}

	public String getLineToken() {
		return lineToken;
	}

	public void setLineToken(String lineToken) {
		this.lineToken = lineToken;
	}
	

}
