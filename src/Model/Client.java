package Model;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable
{
	private static String ip;
	private Socket socket;
	private static int port;

	public void clientMode()
	{
		System.out.println("Client Mode!");
		Client.port = Controller.UserDataController.getPort();
		Client.ip = Controller.UserDataController.getIP();
	}

	@Override
	public void run()
	{
		try
		{
			new Client().clientMode();
			socket = new Socket(ip, port);
			if (socket != null)
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println(br.readLine());
				socket.close();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
