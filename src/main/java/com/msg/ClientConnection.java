package com.msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientConnection {
	private Socket serverSocket;

	public void clientTcpConnetctin(String ip, int port) {

		IpAdderss loaclIp = new IpAdderss();

		System.out.println("This is the ip and port that the client class is getting " + ip + " " + port);
		try {

			serverSocket = new Socket(ip, port);
			System.out.println("Client Socket connection");

			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(serverSocket.getInputStream())); // Server
																													// response
			PrintWriter output = new PrintWriter(serverSocket.getOutputStream(), true);

			// Send messages to the server
			String message;
			while ((message = input.readLine()) != null) {
				output.println(message); // Send message to the server
				System.out.println(loaclIp.getLocalIp() + ": " + serverInput.readLine()); // Read server's response
			}

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
			udpSocket.close();
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
