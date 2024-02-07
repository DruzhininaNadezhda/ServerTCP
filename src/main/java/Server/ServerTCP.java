package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTCP {
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(22222)) {
            while (true) {
                Socket socket = serverSocket.accept();
                InputStreamReader readerIn = new InputStreamReader(socket.getInputStream()); // Входной поток
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
                char[] buffer = new char[1024];
                StringBuilder sb = new StringBuilder();
                for (int i; (i = readerIn.read(buffer, 0, buffer.length)) > 0; ) { //получение и запись сообщения
                    sb.append(buffer, 0, i);
                    System.out.println(sb);
                }
                socket.shutdownInput();

                System.out.println(socket.getInetAddress() + "" + socket.getPort());
                String answer = "Доставлено сообщение:" + sb+ "\n" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime());;
                OutputStreamWriter writerOut = new OutputStreamWriter(socket.getOutputStream()); //Выходной поток
                writerOut.write(answer); //запись сообщения в поток
                writerOut.flush(); // очистка буфера
                socket.shutdownOutput(); // закрывается выходной поток
            }
        } catch (IOException ioe) {
        }
    }
}

