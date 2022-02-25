package app;

import java.math.BigInteger;
import java.net.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.*;

import comm.TCPConnection;

public class Application {

	private TCPConnection connection;

	public Application() {
		connection = new TCPConnection();
		connection.setPuerto(6000);
	}

	public void init() {
		connection.start();
	}

	public String ipConfig() {
		String myAddress = "";
		try {
			myAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return myAddress;

	}

	public String whatTime() {

		Timestamp ts = Timestamp.from(ZonedDateTime.now().toInstant());

		// Instant instant = ts.toInstant();

		String fecha = ts.toString();

		return fecha;

	}

	public String RTT(String msg) {

		if (msg.length() == 1024) {

			return msg;
		} else {
			return "El Mensaje no cumple con los 1024 bytes requeridos";
		}

	}

	public String speed(String msg) {

		if (msg.length() == 8192) {

			return msg;
		} else {
			return "El Mensaje no cumple con los 8192 bytes requeridos";
		}

	}

	public String getInterfaces() {

		String MAC = "";
		Enumeration<NetworkInterface> interfaces;
		try {
			interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface netN = interfaces.nextElement();

				if (netN.isUp()) {
					if (netN.getHardwareAddress() != null) {
						MAC = netN.getName() + " Con dirección MAC: "
								+ new BigInteger(1, netN.getHardwareAddress()).toString(16);
					}

				}

			}

		} catch (SocketException e) {
			e.printStackTrace();
		}

		return MAC;

	}

}
