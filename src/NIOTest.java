import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

	public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("src/nio.txt","rw");
            FileChannel fileChannel = aFile.getChannel();
            //分配空间
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //写入数据到Buffer
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
 
            while(bytesRead != -1)
            {
            	//
                buf.flip();
                while(buf.hasRemaining())
                {
                	//从Buffer中读取数据
                    System.out.print((char)buf.get());
                }
                //
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
