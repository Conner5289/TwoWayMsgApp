package com.msg;

public class App {
	public static void main(String[] args) {
		int clientPort = 5289;
		int serverPort = 5290;

		ClientConnection udpClient = new ClientConnection();
		ServerConnection udpServer = new ServerConnection();

		String remoteIp = udpClient.clientUdpConnection();

		if (remoteIp == null) {
			remoteIp = udpServer.updServerConnection();
			clientPort = 5290;
			serverPort = 5289;
		}

		ThreadConnection tcpServer = new ThreadConnection(serverPort, remoteIp, true);
		ThreadConnection tcpClient = new ThreadConnection(clientPort, remoteIp, false);

		Thread threadServer = new Thread(tcpServer);
		Thread threadClient = new Thread(tcpClient);

		threadServer.start();
		threadClient.start();

	}

}
