package tongxin;

import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket s =new Socket("192.168.2.105",8080);
        System.out.println("客户端启动");
        OutputStream os= s.getOutputStream();
        DataOutputStream ss = new DataOutputStream(os);
        ss.writeUTF("你好，兄弟");

        InputStream inputStream = s.getInputStream();
        DataInputStream as = new DataInputStream(inputStream);
        System.out.println(as.readUTF());

        as.close();
        inputStream.close();
        ss.close();
        os.close();
        s.close();

    }
}
