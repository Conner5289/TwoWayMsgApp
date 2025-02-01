package com.msg;

public class App {
	public static void main(String[] args) {
		ClientConnection client = new ClientConnection();
		ServerConnection server = new ServerConnection();

		String remoteIp = client.clientUdpConnection(); // sees if there is a server, if non returns null

		if (remoteIp == null) {
			System.out.println(server.updConnection()); // Makes a server
		}

	}
}
