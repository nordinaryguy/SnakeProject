package com.snake.main;

import com.snake.model.SnakeEngine;
import com.snake.vue.AuthenticationView;
import com.snake.vue.StartView;

public class EntryPoint {

	public static void main(String[] args) {
		StartView sv = new StartView();
		SnakeEngine se = new SnakeEngine();
		AuthenticationView av = new AuthenticationView(se);
	}

}
