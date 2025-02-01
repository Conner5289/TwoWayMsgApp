package com.msg;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerConnection implements Runnable {
	private ServerSocket serverConnetion;

	public void run() {
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

}
