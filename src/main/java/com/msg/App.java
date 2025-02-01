package com.msg;

public class App {
	public static void main(String[] args) {
		ClientConnection client = new ClientConnection();
		ServerConnection server = new ServerConnection();

		// udp conntecion to find Ip
		String remoteIp = client.clientUdpConnection(); // sees if there is a server, if non returns null

		if (remoteIp == null) {
			remoteIp = server.updConnection(); // Makes a server, returns remoteIp with connection
		}

		// Tcp conntections, where the real meassing take place

		server.tcpConnection();
		client.clientTcpConnetctin(remoteIp);

	}

}
