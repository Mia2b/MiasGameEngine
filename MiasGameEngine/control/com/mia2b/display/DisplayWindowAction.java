package com.mia2b.display;
import javax.swing.*;

import com.mia2b.beta.Camera;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
@SuppressWarnings("serial")
public class DisplayWindowAction extends JPanel{
JLabel display;
JFrame frame;
public DisplayWindowAction(JFrame frame){
        display = new JLabel("---");
        this.frame = frame;

        frame.addComponentListener(new FrameListen());
        add(display);
    }

    private class FrameListen implements ComponentListener{
        public void componentHidden(ComponentEvent arg0) {
        }
        public void componentMoved(ComponentEvent arg0) {   
        }
        public void componentResized(ComponentEvent arg0) {
//        	private static int bufferWidth = DisplayWindow.getFrame().getWidth()/2;
//        	private static int bufferHeight = DisplayWindow.getFrame().getHeight()/2;
        	Camera.setBufferWidth(DisplayWindow.getFrame().getWidth()/2);
        	Camera.setBufferHeight(DisplayWindow.getFrame().getHeight()/2);
        }
        public void componentShown(ComponentEvent arg0) {

        }
    }
}