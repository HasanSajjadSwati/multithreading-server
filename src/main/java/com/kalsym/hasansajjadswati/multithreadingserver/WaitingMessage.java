/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kalsym.hasansajjadswati.multithreadingserver;

/**
 *
 * @author hasan
 */
public class WaitingMessage implements Runnable {

    private static int counter = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                counter++;
                System.out.println("I am waiting for response from server!");
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }
    }

    public int getCounter() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }
}
