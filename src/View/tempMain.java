package View;

import Model.Client;
import Model.Server;

import java.util.Scanner;

public class tempMain
{
	public static void main(String args[])
	{
		System.out.println("Please select a mode:\n1.Server Mode.\n2.Client Mode.");
		if (new Scanner(System.in).nextInt() == 1)
		{
			new Server().run();
		} else
		{
			new Client().run();
		}
	}
}
