package com.msg;

import java.io.IOException;
import java.net.Socket;

public class ClientConnection {

	public ClientConnection(String ip) {
		final int PORT = 5289;

		try {
			Socket clientSocket = new Socket(ip, PORT);
			System.out.println("Client Socket connection on \nIp: " + ip + "\nPort: " + PORT);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bad Client Socket");
		}

	}

}
