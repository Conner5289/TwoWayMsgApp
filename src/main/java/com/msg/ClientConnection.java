package com.msg;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection implements Runnable {
	private Socket clientSocket;

	public void run() {

		Scanner scnr = new Scanner(System.in);
		String ip = scnr.next();

		final int PORT = 5289;

		try {
			clientSocket = new Socket(ip, PORT);
			System.out.println("Client Socket connection on \nIp: " + ip + "\nPort: " + PORT);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Bad Client Socket");
		}
	}

}
