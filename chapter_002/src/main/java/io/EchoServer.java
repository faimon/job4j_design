package io;

import log.UsageLog4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isStart = true;
            while (isStart) {
                Socket socket = server.accept();
                try (OutputStream toClient = socket.getOutputStream();
                     BufferedReader fromClient = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    do {
                        str = fromClient.readLine();
                        if (str.contains("Hello")) {
                            toClient.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            toClient.write("Hello".getBytes());
                        } else if (str.contains("Exit")) {
                            isStart = false;
                            break;
                        } else if (str.contains("msg=")) {
                            String out = str.split(" ")[1].split("=")[1];
                            toClient.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            toClient.write(out.getBytes());
                        }
                        System.out.println(str);
                    } while (!str.isEmpty());
                }
            }
        } catch (IOException e) {
            LOG.error("IOException", e);
        }
    }
}
