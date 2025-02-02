package com.msg;

public class ClientRun implements Runnable {
	private int port;
	private String ip;

	public ClientRun(int port, String ip) {

		this.port = port;
		this.ip = ip;

	}

	public void run() {
		ClientConnection client = new ClientConnection();
		client.clientTcpConnetctin(ip, port);
	}

}
