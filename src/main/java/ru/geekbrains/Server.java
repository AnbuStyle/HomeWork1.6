package ru.geekbrains;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        ServerSocket serv = null;
        Socket sock;
        try {
            serv = new ServerSocket(6543);
            System.out.println("Сервер запущен, ожидаем подключения...");
            sock = serv.accept();
            System.out.println("Клиент подключился");
            new Client(sock, "Сервер");
            while(true){
                if(sock.isClosed()){
                    break;
                }
            }
            serv.close();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        } finally {
            try {
                assert serv != null;
                serv.close();
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}