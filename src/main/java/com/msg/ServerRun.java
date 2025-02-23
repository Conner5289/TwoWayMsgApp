package com.msg;

public class ServerRun implements Runnable {
	private int port;
	private String ip;

	public ServerRun(int port, String ip) {
		this.port = port;
		this.ip = ip;

	}

	@Override
	public void run() {
		ServerConnection server = new ServerConnection();
		server.tcpServerConnection(port, ip);

	}

}
