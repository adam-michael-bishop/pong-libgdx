package com.mygdx.pong;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.pong.screens.MainMenuScreen;

public class Pong extends Game {
	public SpriteBatch batch;
	public BitmapFont fontSmall;
	public BitmapFont fontMedium;
	public BitmapFont fontLarge;
	private FreeTypeFontGenerator generator;
	public final float viewportWidth = 800;
	public final float viewportHeight = 480;
	
	@Override
	public void create () {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/PressStart2P-Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 12;
		fontSmall = generator.generateFont(parameter);
		parameter.size = 16;
		fontMedium = generator.generateFont(parameter);
		parameter.size = 24;
		fontLarge = generator.generateFont(parameter);

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
		fontSmall.dispose();
		generator.dispose();
	}
}
