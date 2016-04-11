package com.mia2b.gameControl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mia2b.world.KeysPressed;

public class KeyInput extends KeyAdapter {
	
	public void keyPressed(KeyEvent e) {
		KeysPressed.addKey(e.getKeyCode());
	}
	public void keyReleased(KeyEvent e){
		KeysPressed.removeKey(e.getKeyCode());
	}
	public void keyTyped(KeyEvent e) {
	
	}
}
