package com.msg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

import sun.util.logging.resources.logging;

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

		IpAdderss loaclIp = new IpAdderss();
		DatagramSocket udpSocket = null;
		byte[] buffer = new byte[1024];
		final int PORT = 5291;

		try {
			udpSocket = new DatagramSocket(5291);

			System.out.println("Waiting for connection");
			DatagramPacket udpPacket = new DatagramPacket(buffer, buffer.length);

			udpSocket.receive(udpPacket);
			InetAddress remoteIp = udpPacket.getAddress();

			System.out.println("Connection made");

			String sendMsg = loaclIp.getLocalIp();
			DatagramPacket udpSendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), remoteIp,
					PORT);

			try {
				udpSocket.send(udpSendPacket);
				System.out.println("Sent ip back to 2nd pc");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Bad udpPacket send");
			}

			String remoteAddress = remoteIp.getHostAddress();
			return remoteAddress;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udp server socket");
			return null;
		}

	}

}
