package com.mia2b.world;

import java.util.ArrayList;

public class KeysPressed {
	private static volatile ArrayList<Integer> keysPressed = new ArrayList<Integer>();

	public static ArrayList<Integer> getKeysPressed() {
		return keysPressed;
	}
	private static void addNewKey(int key){
		KeysPressed.keysPressed.add(key);
	}
	
	public static void addKey(int key) {
		if(!contains(key)){
			addNewKey(key);
		}
	}

	public static void removeKey(int key) {
		KeysPressed.keysPressed.remove(Integer.valueOf(key));
	}
	public static boolean contains( int key){
		for(int i: KeysPressed.keysPressed){
			if(i == key){
				return true;
			}
		}
		return false;
	}
}
