package edu.eci.arsw.primefinder;

import javax.swing.*;
import java.io.*;
import java.util.Timer.*;

public class Main  {

	public static void main(String[] args) {
		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000);
        PrimeFinderThread pft2=new PrimeFinderThread(10000001, 20000000);
        PrimeFinderThread pft3=new PrimeFinderThread(20000001, 30000000);

        pft.start();
		pft2.start();
        pft3.start();

        Timer stopThread = new Timer(5000, e -> {
                pft.pauseThread();
                pft2.pauseThread();
                pft3.pauseThread();
        });
        stopThread.setRepeats(false);
        stopThread.start();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pft.resumeThread();
        pft2.resumeThread();
        pft3.resumeThread();

    }
	
}
