package com.msg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class ServerConnection {
	private ServerSocket serverConnetion;

	public void tcpConnection() {
		IpAdderss ipAdd = new IpAdderss();
		final int PORT = 5289;

		try {
			serverConnetion = new ServerSocket(PORT);
			System.out.println("Server open on \n" + "Ip:" + ipAdd.getLocalIp() + "\nPort: " + PORT);

			System.out.println("Waiting for other PC");
			serverConnetion.accept();

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Bad Socket open");
			System.exit(1);
		}

	}

	public String updConnection() {

		DatagramSocket udpSocket = null;
		byte[] buffer = new byte[1024];

		try {
			udpSocket = new DatagramSocket(5291);
			System.out.println("Waiting for connection");

			DatagramPacket udpPacket = new DatagramPacket(buffer, buffer.length);

			udpSocket.receive(udpPacket);
			System.out.println("Connection made");
			String remoteIp = udpPacket.getAddress().getHostAddress();
			return remoteIp;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udp server socket");
			return null;
		}

	}

}
