package Main;
//CLIENT_CLIENT

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Socket client = new Socket("localhost", 6666);
            System.out.println("server reached");
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader_from_server = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String user_input_1;
            while (true) {

                ///////////////////////////////////
                System.out.println("write a String");
                user_input_1 = reader.readLine();
                writer.println(user_input_1);
                /////////////////////////////////////
                System.out.println("answer:");
                System.out.println(reader_from_server.readLine());
            }
            //client.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
