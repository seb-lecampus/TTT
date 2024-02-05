
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) {
        try {

            Socket socket = null;
            BufferedReader reader;

            socket = new Socket("172.22.114.100", 5005);
            System.out.println("Connecté");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String line = "";

            while (!line.equals("over")) {

                try (reader) {

                    try {

                        line = reader.readLine();
                        // out.writeUTF(line);
                        System.out.println(line);
                        
                        writer.println(new Scanner(System.in).nextInt());

                    } catch (Exception e) {

                        System.out.println("premier catch");
                        System.out.println(e);
                    }

                } catch (Exception ex) {
                    System.out.println("second catch");
                    System.out.println(ex);
                }

            }
        }catch (Exception e){
            System.out.println(e);

        }
    }
}

