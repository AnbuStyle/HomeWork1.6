package ru.geekbrains;

import java.io.IOException;
import java.net.Socket;

public class Chat {

    public static void main(String[] args) {
        new Chat();
    }

    public Chat() {
        try {
            int SERVER_PORT = 6543;
            String SERVER_ADDR = "localhost";
            Socket sock = new Socket(SERVER_ADDR, SERVER_PORT);
            new Client(sock, "Клиент");
            while(true){
                if(sock.isClosed()){
                    break;
                }
            }
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}