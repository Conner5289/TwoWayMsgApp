package com.msg;

public class ThreadConnection implements Runnable {

	private int port;
	private String ip;
	private boolean isServer;

	public ThreadConnection(int port, String ip, Boolean isServer) {

		this.port = port;
		this.ip = ip;
		this.isServer = isServer;

	}

	@Override
	public void run() {

		if (isServer) {

			ServerConnection server = new ServerConnection();
			server.tcpServerConnection(ip, port);
		} else {
			ClientConnection client = new ClientConnection();
			client.clientTcpConnetctin(ip, port);
		}

	}

}
