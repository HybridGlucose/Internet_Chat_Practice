package Model;

import java.io.*;
import java.net.Socket;

import View.ChatController;

public class Client implements Runnable
{
	private static String ip;
	private Socket socket;
	private static int port;

	public void clientMode()
	{
		Client.port = UserData.getPort();
		Client.ip = UserData.getIP();
	}

	@Override
	public void run()
	{
		new Client().clientMode();
		try
		{
			socket = new Socket(ip, port);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (br.readLine() != "exit")
			{
				ChatController.printGetMessage(br.readLine());
			}
			socket.close();
			Thread thread = Thread.currentThread();
			thread.stop();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
