package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.text.html.HTMLDocument.Iterator;

public class AtencionAlCliente extends Thread {
	
	private Socket clienteSocket;
	private Sala sala;
	private DataOutputStream salida;
	private DataInputStream entrada;

	public AtencionAlCliente(Socket socket, Sala sala) {
		this.clienteSocket = socket;
		this.sala = sala;
	}

	public void run() {
		try {
			entrada = new DataInputStream(this.clienteSocket.getInputStream());
			while (true) {
				String msj = entrada.readUTF();
				java.util.Iterator<Socket> it = sala.socketsClientes.iterator();
				while (it.hasNext()) {
					Socket aux = it.next();
					if(this.clienteSocket != aux){
						salida = new DataOutputStream(aux.getOutputStream());
						salida.writeUTF(msj);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
