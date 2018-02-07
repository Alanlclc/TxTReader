package cn.ksb.minitxt.clientutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import cn.ksb.minitxt.common.entity.DataTransfer;

@SuppressWarnings("unchecked")
public class DefaultCommunicatorImp1<T extends Serializable,S extends Serializable> implements Communicator {
	
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public DataTransfer<S> conmunicate(DataTransfer<T> input) throws IOException,ClassNotFoundException {
		out.writeObject(input); 
		return ((DataTransfer<S>) in.readObject());
	}

	@Override
	public void destory() throws IOException {
		// TODO Auto-generated method stub
		in.close();
		out.close();
		socket.close();
	}

	@Override
	public void init(String host, int port) throws UnknownHostException,
			IOException {
		socket = new Socket(host,port);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	@Override
	public DataTransfer conmunicate1(DataTransfer input) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
