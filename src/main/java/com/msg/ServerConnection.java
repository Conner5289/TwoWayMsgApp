package com.msg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerConnection {
	private ServerSocket serverConnetion;

	public void tcpConnection(int port) {
		IpAdderss ipAdd = new IpAdderss();
		try {
			serverConnetion = new ServerSocket();
			System.out.println("Server open on \n" + "Ip:" + ipAdd.getLocalIp() + "\nPort: " + port);

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
		final int UdpPort = 5291;

		try {
			udpSocket = new DatagramSocket(UdpPort);

			System.out.println("Waiting for connection");
			DatagramPacket udpPacket = new DatagramPacket(buffer, buffer.length);

			udpSocket.receive(udpPacket);
			InetAddress remoteIp = udpPacket.getAddress();

			String sendMsg = loaclIp.getLocalIp();
			DatagramPacket udpSendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), remoteIp,
					UdpPort + 1);

			try {
				udpSocket.send(udpSendPacket);
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
