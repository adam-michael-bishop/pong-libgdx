package com.mygdx.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.pong.screens.MainMenuScreen;

public class Pong extends Game {
	public SpriteBatch batch;
	public FreeTypeFontGenerator fontGenerator;
	public final float viewportWidth = 800;
	public final float viewportHeight = 480;
	
	@Override
	public void create () {
		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P-Regular.ttf"));
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fontGenerator.dispose();
	}
}
