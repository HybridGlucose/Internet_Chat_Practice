package View;

import Model.Client;

import java.util.Scanner;

public class tempMain
{
	public static void main(String args[])
	{
		System.out.println("Please select a mode:\n1.Server Mode.\n2.Client Mode.");
		if (new Scanner(System.in).nextInt() == 1)
		{
			new Model.server().run();
		} else
		{
			new Client().run();
		}
	}
}
