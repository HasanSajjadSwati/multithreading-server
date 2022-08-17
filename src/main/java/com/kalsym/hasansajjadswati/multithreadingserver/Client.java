/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kalsym.hasansajjadswati.multithreadingserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author hasan
 */
public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 8081);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Send Request To Server:");
        Scanner scanner = new Scanner(System.in);
        String inputToServer = null;

        while (!"exit".equalsIgnoreCase(inputToServer)) {
            inputToServer = scanner.nextLine();
            WaitingMessage message = new WaitingMessage();
            out.println(inputToServer);
            Thread thread = new Thread(message);
            thread.start();

            if (inputToServer.equalsIgnoreCase("exit")) {
                System.out.println(in.readLine());
            } else {
                System.out.println(in.readLine() + " Waited = " + message.getCounter() + " Seconds!");
                System.out.println("Send Request To Server:");
            }
            message.resetCounter();
            thread.stop();
        }
        scanner.close();
    }

}
