package com.msg;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerConnection {
	private ServerSocket newSocket;

	public ServerConnection() {

		IpAdderss ipAdd = new IpAdderss();

		try {
			newSocket = new ServerSocket(5289);
			System.out.println("Socket open on \n" + "Ip:" + ipAdd.getLocalIp() + "\nPort: 500");

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Bad Socket open");
			System.exit(1);
		}
	}
}
