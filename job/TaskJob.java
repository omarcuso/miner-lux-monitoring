package com.minermonitor.job;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.minermonitor.config.Configuration;
import com.minermonitor.conn.BxConn;
import com.minermonitor.conn.CryptopiaConn;
import com.minermonitor.conn.LineConn;
import com.minermonitor.conn.LuxcoreConn;
import com.minermonitor.conn.PickaxeConn;
import com.minermonitor.model.Bx;
import com.minermonitor.model.Coin;
import com.minermonitor.model.Cryptopia;
import com.minermonitor.model.LuxCore;
import com.minermonitor.model.Pickaxe;

public class TaskJob {

	private Bx bx;
	private Pickaxe pickaxe;
	private Cryptopia cryptopia;
	private LuxCore luxCore;
	
	private static final Logger LOGGER = Logger.getLogger(TaskJob.class.getName());
	private static DecimalFormat df2 = new DecimalFormat(".##");
	private static final Configuration conf = new Configuration();
	
	public static void main(String[] args) {
		
		TaskJob t = new TaskJob();
			
			t.init();
			t.process();
	}
	
	
	
	private void init() {
		LOGGER.info("Do Init ...");
		
		String wallet = conf.getLuxWallet();
		BxConn bxConn = new BxConn();
		PickaxeConn pickaxeConn = new PickaxeConn();
		CryptopiaConn cryptopiaConn = new CryptopiaConn();
		LuxcoreConn luxCore = new LuxcoreConn();
		
		setBx(bxConn.conn(Coin.BTC));
		setPickaxe(pickaxeConn.conn(wallet));
		setCryptopia(cryptopiaConn.conn(Coin.LUX));
		setLuxCore(luxCore.conn());

		LOGGER.info("Init Done ...");
	}
	private void process() {
		LOGGER.info("Do Process ...");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date = sdf.format(new Date());
		String content = "\n";
		content += "==============================\n";
		content += Coin.BTC+" : "+df2.format(getBx().getLastPrice())+" Bath \n";
		content += Coin.BTC+" Change : "+df2.format(getBx().getChange())+" Percent\n";
		content += Coin.LUX+" : "+df2.format(getBx().getLastPrice()*getCryptopia().getLastPrice())+ " Bath \n";
		content += Coin.LUX+" Change : "+df2.format((getCryptopia().getChange()))+" Percent\n";
		content += "==============================\n";
		content += "Now you have "+Coin.LUX+" at Wallet : "+df2.format(getLuxCore().getBalance())+" "+Coin.LUX+"\n";
		content += "Unpaid "+Coin.LUX+" at Wallet : "+df2.format(getPickaxe().getUnpaid())+" "+Coin.LUX+"\n";
		content += "Total "+Coin.LUX+" : "+df2.format(getPickaxe().getUnpaid()+(getLuxCore().getBalance()))+" "+Coin.LUX+"\n";
		content += "Convert to Bath : "+df2.format(((getPickaxe().getUnpaid()+(getLuxCore().getBalance()))*getCryptopia().getLastPrice())*getBx().getLastPrice())+ " Bath \n";
		content += "==============================\n";
		content += "Report Created at "+date;
		
		LineConn lineConn = new LineConn();
		lineConn.sendNotify(content);
		
		LOGGER.info("Process Done ...");
	}
	
	
	private Bx getBx() {
		return bx;
	}
	
	private void setBx(Bx bx) {
		this.bx = bx;
	}

	public Pickaxe getPickaxe() {
		return pickaxe;
	}

	public void setPickaxe(Pickaxe pickaxe) {
		this.pickaxe = pickaxe;
	}


	public Cryptopia getCryptopia() {
		return cryptopia;
	}


	public void setCryptopia(Cryptopia cryptopia) {
		this.cryptopia = cryptopia;
	}
	
	public LuxCore getLuxCore() {
		return luxCore;
	}
	public void setLuxCore(LuxCore luxCore) {
		this.luxCore = luxCore;
	}
	
	
	
	
	
	

}
