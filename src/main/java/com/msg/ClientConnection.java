package com.msg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection {
	private Socket clientSocket;

	public void clientTcpConnetctin(String ip) {
		final int PORT = 5290;

		try {
			clientSocket = new Socket(ip, PORT);
			System.out.println("Client Socket connection on \nIp: " + ip + "\nPort: " + PORT);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bad Client Socket");
		}
	}

	public String clientUdpConnection() {
		final String BOARDCAST_IP = "192.168.1.255";
		final int PORT = 5291;

		DatagramSocket udpSocket = null;
		InetAddress boardCastIp = null;

		IpAdderss loaclIp = new IpAdderss();

		try {
			udpSocket = new DatagramSocket();
			boardCastIp = InetAddress.getByName(BOARDCAST_IP);
			udpSocket.setBroadcast(true);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udp socket");
		}

		String sendMsg = loaclIp.getLocalIp();
		DatagramPacket udpPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), boardCastIp, PORT);

		try {

			udpSocket.send(udpPacket);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udpPacket send");
		}

		return "Done";
	}

}
