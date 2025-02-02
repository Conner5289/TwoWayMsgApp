package com.msg;

public class App {
	public static void main(String[] args) {
		ClientConnection client = new ClientConnection();
		ServerConnection server = new ServerConnection();

		int serverPort = 5289;
		int clientPort = 5288;

		// udp conntecion to find Ip
		String remoteIp = client.clientUdpConnection(); // sees if there is a server, if non returns null

		if (remoteIp == null) {
			remoteIp = server.updConnection(); // Makes a server, returns remoteIp with connection

			serverPort = 5288;
			clientPort = 5289;

		}

		server.tcpConnection(serverPort);
		client.clientTcpConnetctin(remoteIp, clientPort);

	}

}
