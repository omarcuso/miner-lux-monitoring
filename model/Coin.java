package com.minermonitor.model;


	public enum Coin {
		BTC(1),
		ETH(2),
		LUX(3);
	private int id;
	
	 	Coin(int id) {
		this.id = id;
	 	}
		public int id() {
			return id;
		}
	
	}

