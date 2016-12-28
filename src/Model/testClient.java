package Model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class testClient
{
	static final int PORT = 9999;
	static boolean runFlag = true;
	public static void main(String[] args)
	{
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		while (runFlag)
		{
			try
			{
				SocketChannel clientChannel = SocketChannel.open();
				clientChannel.connect(new InetSocketAddress("127.0.0.1",PORT));
				if(clientChannel!= null)
				{
					System.out.println("Start Read Buffer.");
					while (clientChannel.read(buffer) > 0)
					{
					}
					buffer.flip();
					System.out.println(Charset.forName("UTF-8").decode(buffer));
					runFlag = false;
					clientChannel.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
