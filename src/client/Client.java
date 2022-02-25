package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import app.Application;

public class Client {
	public static void main(String[] args) {

		try {
			while (true) {
				Socket socket = new Socket("127.0.0.1", 6000);
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(os));
				BufferedReader breader = new BufferedReader(new InputStreamReader(is));

				showMenu();

				Scanner scanner = new Scanner(System.in);

				String line = scanner.nextLine();
				bwriter.write(line+"\n");
				bwriter.flush();
				String msg="";

				if (line.equalsIgnoreCase("RTT")) {
					//line = scanner.nextLine() + "\n"; mandar mensaje de 1024
				bwriter.write(line+"\n");
				bwriter.flush();
					msg = breader.readLine(); //Recibir mensaje de 1024
					System.out.println(msg);

				}else if(line.equalsIgnoreCase("speed")){
					msg = breader.readLine();
					System.out.println(msg);
				} else {
					msg = breader.readLine();
					System.out.println(msg);
				}

			}

		} catch (

		IOException ex) {
			ex.printStackTrace();
		}

	}

	public static void showMenu() {
		System.out.println(
				"Escriba: ");
		System.out
				.println("'remoteipconfig' si desea conocer la red IP actual a la que se encuentra conectado ");
		System.out.println("'interface' para conocer desde donde el servidor se comunica con usted");
		System.out.println("'whattimeIsIt' cono el fin de saber la hora de su sistema");
		System.out.println("'RTT' para enviar un mensaje de 1024 bytes y mostrar su mensaje en consola ");
		System.out.println("'speed' para determinar la velocidade transmisión de un mensaje de 8192 bytes");

	}

}
