package de.lalex.tutorial.emails;

public class TestSend {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		SendEmail send = new SendEmail("hauke.schroeder@online.de", "TEST", "Hallo hier ist dein Maxi :) habe diese E-Mail über einen Java-Code versendet :D");
	}
	
}
