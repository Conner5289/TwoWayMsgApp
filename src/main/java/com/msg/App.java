package com.msg;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		ServerConnection server = new ServerConnection();

		Scanner scnr = new Scanner(System.in);
		String clientIp = scnr.next();

		ClientConnection client = new ClientConnection(clientIp);

	}
}
