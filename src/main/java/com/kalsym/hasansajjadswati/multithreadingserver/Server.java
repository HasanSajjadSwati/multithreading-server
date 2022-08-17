/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kalsym.hasansajjadswati.multithreadingserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hasan
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;

        try {
            server = new ServerSocket(8081);
            server.setReuseAddress(true);
            while (true) {
                System.out.println("Server Started!");
                Socket client = server.accept();
                System.out.println("New Client Connected!");
                ClientHandler clientSocket = new ClientHandler(client);

                Thread thread = new Thread(clientSocket);
                thread.start();

            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }

    }
}
