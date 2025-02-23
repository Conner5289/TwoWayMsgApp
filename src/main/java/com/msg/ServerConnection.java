package com.msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection {
	private ServerSocket serverConnetion;

	public void tcpServerConnection(int port, String ip) {
		IpAdderss ipAdd = new IpAdderss();
		try {
			serverConnetion = new ServerSocket(port);
			System.out.println("Server open on \n" + "Ip:" + ipAdd.getLocalIp() + "\nPort: " + port);

			System.out.println("Waiting for other PC");
			Socket clientSocket = serverConnetion.accept();
			System.out.println("Pc connected");

			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

			// Read and send messages in a loop
			String messageFromClient;
			while ((messageFromClient = input.readLine()) != null) {
				System.out.println(ip + ": " + messageFromClient);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Bad Socket open");
			System.exit(1);
		}

	}

	public String updServerConnection() {
		IpAdderss loaclIp = new IpAdderss();
		DatagramSocket udpServerSocket = null;
		byte[] buffer = new byte[1024];
		final int UdpPort = 5291;

		try {
			udpServerSocket = new DatagramSocket(UdpPort);

			System.out.println("Waiting for connection");
			DatagramPacket udpPacket = new DatagramPacket(buffer, buffer.length);

			udpServerSocket.receive(udpPacket);
			InetAddress remoteIp = udpPacket.getAddress();

			String sendMsg = loaclIp.getLocalIp();
			DatagramPacket udpSendPacket = new DatagramPacket(sendMsg.getBytes(), sendMsg.length(), remoteIp,
					UdpPort + 1);

			try {
				udpServerSocket.send(udpSendPacket);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Bad udpPacket send");
			}

			String remoteIpAddress = remoteIp.getHostAddress();
			udpServerSocket.close();
			return remoteIpAddress;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bad udp server socket");
			return null;
		}

	}

}
