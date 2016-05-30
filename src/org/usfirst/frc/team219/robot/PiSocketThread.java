package org.usfirst.frc.team219.robot;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PiSocketThread implements Runnable {
	
	protected int serverPort = 4444; //default port = 4444
	protected ServerSocket server = null;
	protected boolean isStopped = false;
	protected Thread runningThread = null;
	
	
	/**
	 * Establishes the port to run a server on
	 * @param port 
	 */
	public PiSocketThread(int port){
		this.serverPort = port;
	}
	
	/**
	 * Starts a new thread which accepts a client to the server
	 */
	public void run(){
		synchronized(this){
			this.runningThread = Thread.currentThread();
		}
		openServerSocket();
		while(!isStopped()){
			Socket clientSocket = null;
			try {
				clientSocket = this.server.accept();
			} catch(IOException e){
				if(isStopped()){
					System.out.println("Server Stopped");
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			new Thread(/*new Client()*/).start();
		}
		System.out.println("Server Stopped.");
	}

	/**
	 * Synchronized thread method to get whether the server is stopped
	 * or not
	 * @return - true/false depending on whether or not the server is stopped
	 */
	private synchronized boolean isStopped() {
		return isStopped;
	}
	
	/**
	 * Synchronized thread method to stop the server
	 */
	public synchronized void stop(){
		isStopped = true;
		try {
			this.server.close();
		} catch(IOException e){
			throw new RuntimeException("Error closing server", e);
		}
	}

	/**
	 * Opens a server socket on the designated port
	 */
	private void openServerSocket() {
		try{
			this.server = new ServerSocket(serverPort);
		} catch(IOException e){
			throw new RuntimeException("Cannot open port 4444", e);
		}
	}

	

// 	PiSocketThread server = new PiSocketThread(9000);
//	new Thread(server).start();
//	
//	try {
//	    Thread.sleep(20 * 1000);
//	} catch (InterruptedException e) {
//	    e.printStackTrace();
//	}

}


