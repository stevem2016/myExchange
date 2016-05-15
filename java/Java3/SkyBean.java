package edu.acc.java;

import java.io.Serializable;

public class SkyBean implements Serializable {
	
	CLOUDS morningSky;
	CLOUDS noonSky;
	CLOUDS eveningSky;
	
	public SkyBean() {
	this.morningSky = CLOUDS.NIMBUS;
	this.noonSky = CLOUDS.STRATUS;
	this.eveningSky = CLOUDS.MAMMATUS;
	}

	public CLOUDS getMorningSky() {
		return morningSky;
	}
	public void setMorningSky(CLOUDS morningSky) {
		this.morningSky = morningSky;
	}
	public CLOUDS getNoonSky() {
		return noonSky;
	}
	public void setNoonSky(CLOUDS noonSky) {
		this.noonSky = noonSky;
	}
	public CLOUDS getEveningSky() {
		return eveningSky;
	}
	public void setEveningSky(CLOUDS eveningSky) {
		this.eveningSky = eveningSky;
	}

}
