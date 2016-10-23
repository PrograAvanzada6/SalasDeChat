package Chat;

import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sala {
	List <Socket> socketsClientes = new LinkedList<Socket> ();
	
	public void agregar(Socket socket){
		socketsClientes.add(socket);
	}
}
