package com.msg;

public class App {
	public static void main(String[] args) {
		ClientConnection client = new ClientConnection();
		ServerConnection server = new ServerConnection();

		// udp conntecion to find Ip
		String remoteIp = client.clientUdpConnection(); // sees if there is a server, if non returns null
		System.out.println(remoteIp + "not if");

		if (remoteIp == null) {
			System.out.println("Going to the if");
			remoteIp = server.updConnection(); // Makes a server, returns remoteIp with connection
			System.out.println(remoteIp + " is if");
			server.tcpConnection();
		}

		// Tcp conntections, where the real meassing take place

		server.tcpConnection();
		client.clientTcpConnetctin(remoteIp);

	}

}
