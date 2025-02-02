package com.msg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientConnection {
	private Socket clientSocket;

	public void clientTcpConnetctin(String ip) {
		int TcpPort = 5289;

		try {
			clientSocket = new Socket(ip, TcpPort);
			System.out.println("Client Socket connection on \nIp: " + ip + "\nPort: " + TcpPort);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bad Client Socket");
		}
	}

	public String clientUdpConnection() {
		final String BOARDCAST_IP = "192.168.1.255";
		final int UdpPort = 5291;

		DatagramSocket udpSocket = null;
		InetAddress boardCastIp = null;

		IpAdderss loaclIp = new IpAdderss();

		try {
			udpSocket = new DatagramSocket(UdpPort);
			boardCastIp = InetAddress.getByName(BOARDCAST_IP);
			udpSocket.setBroadcast(true);
			udpSocket.setSoTimeout(3000); // Timeout of 5 seconds

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udp socket");
		}

		String sendMsg = loaclIp.getLocalIp();
		DatagramPacket udpPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), boardCastIp, UdpPort);

		try {
			udpSocket.send(udpPacket);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udpPacket send");
		}

		byte[] buffer = new byte[1024];
		DatagramPacket udpResponse = new DatagramPacket(buffer, buffer.length);

		try {

			System.out.println("Getting Ip of other Pc");
			udpSocket.receive(udpResponse);
			System.out.println("got pass the recive block in clinet class");
			String remoteIp = udpResponse.getAddress().getHostAddress();
			System.out.println(remoteIp + "This is the remoteIp for client class");
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
