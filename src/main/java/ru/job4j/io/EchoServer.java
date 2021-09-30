package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    var str = in.readLine();
                    if (str.contains("/?msg=Bye")) {
                        server.close();
                    } else if (str.contains("?msg=Hello")) {
                        out.write("Hello\r\n".getBytes());
                    } else {
                        out.write("What'\r\n".getBytes());
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            LOG.error("Error ", e);
        }
    }
}