package com.msg;

public class App {
	public static void main(String[] args) {
		ClientConnection client = new ClientConnection();
		ServerConnection server = new ServerConnection();

		String remoteIp = client.clientUdpConnection();

		if (remoteIp == null) {
			System.out.println(server.updConnection());
		}

	}
}
