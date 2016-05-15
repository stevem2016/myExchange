package edu.acc.java;

import java.io.Serializable;

public class WeatherBean implements Serializable {
	private final static long serialVersionUID = 1L;

	private String morningWeather;
	private String noonWeather;
	private String eveningWeather;

	public WeatherBean() {
		morningWeather = "unknown";
		noonWeather = "unknown";
		eveningWeather = "unknown";
	}
	public String getMorningWeather() {
		return morningWeather;
	}
	public void setMorningWeather(String morningWeather) {
		this.morningWeather = morningWeather;
	}
	public String getNoonWeather() {
		return noonWeather;
	}
	public void setNoonWeather(String noonWeather) {
		this.noonWeather = noonWeather;
	}
	public String getEveningWeather() {
		return eveningWeather;
	}
	public void setEveningWeather(String eveningWeather) {
		this.eveningWeather = eveningWeather;
	}
}
