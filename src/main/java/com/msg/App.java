package com.msg;

public class App {
	public static void main(String[] args) {

		ClientConnection client = new ClientConnection();

		System.out.println(client.clientUdpConnection());

	}
}
