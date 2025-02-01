package com.msg;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAdderss {

	public String getLocalIp() {

		InetAddress localHost = null;
		String localIp = null;

		try {
			localHost = InetAddress.getLocalHost();
			localIp = localHost.getHostAddress();

		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(1);
		}

		return localIp;
	}

}
