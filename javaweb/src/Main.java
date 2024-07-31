import java.io.*;

public class Main {
public static void main(String[] args) {

            try (BufferedReader reader = new BufferedReader(new  FileReader("test.txt"));
            ){
                while (( reader.readLine()) != null) {
                    System.out.println(reader.readLine());
                }




        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
}

}
