package com.msg;

public class ServerRun implements Runnable {
	private int port;

	public ServerRun(int port) {
		this.port = port;

	}

	public void run() {
		ServerConnection server = new ServerConnection();
		server.tcpConnection(port);

	}

}
