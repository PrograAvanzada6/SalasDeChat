package Chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public Cliente() {
		this.correr();
	}

	public void correr() {
		try {
			Socket socket = new Socket("localHost", 10000);
			
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			String msj = entrada.readUTF();
			System.out.println(msj);
			Scanner escaner = new Scanner (System.in);
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			salida.writeUTF(escaner.nextLine());
			msj = entrada.readUTF();
			System.out.println(msj);
			
			new ClienteLectura(socket).start();
			new ClienteEscritura(socket).start();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new Cliente();

	}
}
