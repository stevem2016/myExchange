package edu.acc.java;

import java.io.Serializable;

public class RegionBean implements Serializable {
	private final static long serialVersionUID = 1L;
	
	private WeatherBean eastCoast;
	private WeatherBean westCoast;
	private WeatherBean realCoast;
	
	public RegionBean() {
		this.eastCoast = new WeatherBean();
		this.eastCoast.setMorningWeather("rainy");
		this.eastCoast.setNoonWeather("drizzle after 2pm ");
		this.eastCoast.setEveningWeather("ice rain");

		this.westCoast = new WeatherBean();
		this.westCoast.setMorningWeather("flooding");
		this.westCoast.setNoonWeather("tornadoes");
		this.westCoast.setEveningWeather("tornadoes likely");

		this.realCoast = new WeatherBean();
		this.realCoast.setMorningWeather("rain clearing by 11AM");
		this.realCoast.setNoonWeather("sunny");
		this.realCoast.setEveningWeather("partly cloudy, and cooler");
	}
	
	public WeatherBean getEastCoast() {
		return eastCoast;
	}

	public void setEastCoast(WeatherBean eastCoast) {
		this.eastCoast = eastCoast;
	}

	public WeatherBean getWestCoast() {
		return westCoast;
	}

	public void setWestCoast(WeatherBean westCoast) {
		this.westCoast = westCoast;
	}

	public WeatherBean getRealCoast() {
		return realCoast;
	}

	public void setRealCoast(WeatherBean realCoast) {
		this.realCoast = realCoast;
	}

}
