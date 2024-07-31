package tongxin;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSever {
    public static void main(String[] args) throws IOException {
        System.out.println("尝试创建");
        ServerSocket sa = new ServerSocket(8080);
        System.out.println("服务器端启动");
        Socket accept = sa.accept();

        InputStream s1 = accept.getInputStream();
        DataInputStream s2 = new DataInputStream(s1);
        String a =s2.readUTF();
        System.out.println(a);

        OutputStream outputStream = accept.getOutputStream();
        DataOutputStream ss = new DataOutputStream(outputStream);
        ss.writeUTF("你也好");

        ss.close();
        outputStream.close();
        s2.close();
        s1.close();
        accept.close();
        sa.close();
    }
}
