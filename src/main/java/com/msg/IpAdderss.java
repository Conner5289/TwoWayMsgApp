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
		}

		return localIp;
	}

	public InetAddress getLocalInet() {
		InetAddress localHost = null;

		try {
			localHost = InetAddress.getLocalHost();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localHost;

	}

}
