package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
	private ServerSocket server_socket;
	private Socket comm_socket;

	public int serverMode()
	{
		System.out.println("Server Mode Start!");
		return UserData.getPort();
	}

	@Override
	public void run()
	{
		try
		{
			server_socket = new ServerSocket(serverMode());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			System.out.println("Waiting for connection...");
			comm_socket = server_socket.accept();
			System.out.println("Connect success!");
			server_socket.close();
			PrintWriter socket_pw = new PrintWriter(comm_socket.getOutputStream());
			socket_pw.println("Fuck you.");
			socket_pw.flush();
			comm_socket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		Thread thread = Thread.currentThread();
		thread.stop();
	}
}
