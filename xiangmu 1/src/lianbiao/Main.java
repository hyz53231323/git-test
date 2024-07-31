package lianbiao;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("output.txt"))){
            outputStream.write("lbwnb".getBytes());
            outputStream.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
