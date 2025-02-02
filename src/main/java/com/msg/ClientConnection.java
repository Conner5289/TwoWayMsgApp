package com.msg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientConnection {
	private Socket clientSocket;

	public void clientTcpConnetctin(String ip, int port) {
		try {
			clientSocket = new Socket(ip, port);
			System.out.println("Client Socket connection on \nIp: " + ip + "\nPort: " + port);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bad Client Socket");
		}
	}

	public String clientUdpConnection() {
		final String BOARDCAST_IP = "255.255.255.255";
		final int UdpPort = 5292;

		DatagramSocket udpSocket = null;
		InetAddress boardCastIp = null;

		IpAdderss loaclIp = new IpAdderss();

		try {
			udpSocket = new DatagramSocket(UdpPort, loaclIp.getLocalInet());
			boardCastIp = InetAddress.getByName(BOARDCAST_IP);
			udpSocket.setBroadcast(true);
			udpSocket.setSoTimeout(3000); // Timeout of 5 seconds

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udp socket");
		}

		String sendMsg = loaclIp.getLocalIp();
		DatagramPacket udpPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), boardCastIp, UdpPort - 1);

		try {
			udpSocket.send(udpPacket);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udpPacket send");
		}

		byte[] buffer = new byte[1024];
		DatagramPacket udpResponse = new DatagramPacket(buffer, buffer.length);

		try {
			udpSocket.receive(udpResponse);
			String remoteIp = udpResponse.getAddress().getHostAddress();
			return remoteIp;

		} catch (SocketTimeoutException t) {
			System.out.println("No server on online, making server");
			return null;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bad receive");
			return null;
		}

	}
}
