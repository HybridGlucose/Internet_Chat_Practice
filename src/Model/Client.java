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
		System.out.println("Client Mode!\nPlease input IP:");
		Scanner scn = new Scanner(System.in);
		Client.ip = scn.next();
		System.out.println("Please input port:");
		Client.port = scn.nextInt();
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
