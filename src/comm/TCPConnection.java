package comm;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import app.Application;

public class TCPConnection extends Thread {
	private Application app;

	private ServerSocket server;
	private Socket socket;
	private int puerto;

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	@Override
	public void run() {
		app = new Application();
		try {
			while (true) {
				server = new ServerSocket(puerto);
				System.out.println("Esperando un cliente");
				socket = server.accept();
				System.out.println("Cliente conectado");
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				BufferedReader breader = new BufferedReader(new InputStreamReader(is));
				BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(os));

				String msg = breader.readLine();// con esto leo el msg que me envian

				// ejemplo
				if (msg.equalsIgnoreCase("whattimeisit")) {
					bwriter.write(app.whatTime() + "\n");
					bwriter.flush();
				} else if (msg.equalsIgnoreCase("remoteIpconfig")) {
					bwriter.write(app.ipConfig() + "\n");
					bwriter.flush();
				} else if (msg.equalsIgnoreCase("rtt")) {

				} else if (msg.equalsIgnoreCase("speed")) {

				} else if (msg.equalsIgnoreCase("interface")) {
					bwriter.write("Esta es la interfaz: " + app.getInterfaces() + "\n");
					bwriter.flush();
				} else {
					System.out.println("Eso no existe Pana, digite bien!!!");
				}
				server.close();
			}

		} catch (IOException ex) {

		}
	}
}
