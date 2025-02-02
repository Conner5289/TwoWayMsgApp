package com.msg;

public class App {
	public static void main(String[] args) {
		int port = 5289;

		ClientConnection udpClient = new ClientConnection();
		ServerConnection udpServer = new ServerConnection();

		ServerRun server = new ServerRun(port);

		String remoteIp = udpClient.clientUdpConnection();

		if (remoteIp == null) {
			remoteIp = udpServer.updConnection();
			server.run();
		} else {
			ClientRun clientRun = new ClientRun(port, remoteIp);
			clientRun.run();
		}

	}

}
