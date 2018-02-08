package cn.ksb.minitxt.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;


public abstract class BaseServers<T extends Serializable> implements Servers<T> {
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private T data;
	
	@Override
	public void init(Socket socket, ObjectInputStream in,
			ObjectOutputStream out, T data) {
		this.socket= socket;
		this.in = in;
		this.out = out;
		this.data = data;
	}
	
	abstract protected void excuted() throws IOException;
	
	@Override
	public void run() {
		try {
			excuted();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				destory();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void destory() throws IOException {
		in.close();
		out.close();
		socket.close();
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
