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

		ServerRun tcpServer = new ServerRun(serverPort, remoteIp);
		ClientRun tcpClient = new ClientRun(clientPort, remoteIp);

		Thread threadServer = new Thread(tcpServer);
		Thread threadClient = new Thread(tcpClient);

		threadServer.start();
		threadClient.start();

	}

}
