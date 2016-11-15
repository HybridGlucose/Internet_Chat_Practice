package Model;

import View.ChatController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
	private ServerSocket server_socket;
	private Socket comm_socket;
	public static int time = 999999;

	public int serverMode()
	{
		return UserData.getPort();
	}

	@Override
	public void run()
	{
		try
		{
			server_socket = new ServerSocket(serverMode());
			comm_socket = server_socket.accept();
			server_socket.close();
			PrintWriter socket_pw = new PrintWriter(comm_socket.getOutputStream());
			socket_pw.println("dsda");
			socket_pw.flush();
			do
			{
				Thread serverThread = Thread.currentThread();
				serverThread.wait(time);
				time = 999999;
				socket_pw.println(ChatController.sendMessage());
				socket_pw.flush();
			}while(ChatController.sendMessage() != "exit");
			comm_socket.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
