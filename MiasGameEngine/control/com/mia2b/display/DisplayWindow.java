package com.mia2b.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class DisplayWindow {
	
	
	private static JFrame frame;
	private static Canvas canvas;
	
	public static void startDisplay(){
		frame = jFrameWindow("Starting");
		setCanvas(windowCanvas("Hai",frame));
	}
	
	public static JFrame jFrameWindow(String windowName) {
		JFrame f = new JFrame(windowName);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setMinimumSize(new Dimension(1, 1));
		f.setPreferredSize(new Dimension(1280,720));
		f.pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
		f.setVisible(true);
		return f;
	}
	
	public static Canvas windowCanvas(String canvasName, JFrame f){
		Canvas c = new Canvas();
		c.setName(canvasName);
		c.setMinimumSize(f.getMinimumSize());
		c.setPreferredSize(f.getSize());
		c.setBackground(Color.decode("#17181A"));
		f.add(c);
		return c;
	}
	
	public static JFrame getFrame(){
		return frame;
	}
	
	public static void setFrameName(String name){
		frame.setTitle(name);
	}
	
	public static Canvas getCanvas() {
		return canvas;
	}

	public static void setCanvas(Canvas canvas) {
		DisplayWindow.canvas = canvas;
	}
	
}

