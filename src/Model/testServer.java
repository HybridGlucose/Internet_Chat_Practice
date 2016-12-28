package Model;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class testServer
{
	static final int PORT = 9999;
	static boolean runFlag = true;
	static int count = 0;
	public static void main(String[] args)
	{
			try
			{
				ServerSocketChannel serverChannel = ServerSocketChannel.open();
				serverChannel.configureBlocking(false);
				serverChannel.socket().bind(new InetSocketAddress(PORT));
				while (runFlag)
				{
					SocketChannel socketChannel = serverChannel.accept();
					if (socketChannel != null)
					{
						System.out.println("Server Say Fuck You " + count);
						ByteBuffer writeBuffer = ByteBuffer.allocate(4096);
						String date = "幹の " + count;
						writeBuffer.put(date.getBytes(Charset.forName("UTF-8")));
						writeBuffer.flip();
						while(writeBuffer.hasRemaining())
						{
							socketChannel.write(writeBuffer);
							System.out.println("Send");
						}
						writeBuffer.clear();
						count = count +1 ;
						socketChannel.close();
					}
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
	}
}
