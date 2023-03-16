package com.mygdx.pong.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.pong.Pong;

public class MainMenuScreen implements Screen {
    private final Pong game;
    private final OrthographicCamera camera;
    private final float viewportWidth;
    private final float viewportHeight;
    final String titleText = "PONG";
    final String messageText = "press any key to start";
    final GlyphLayout titleLayout;
    final GlyphLayout messageLayout;

    public MainMenuScreen(final Pong game) {
        this.game = game;
        this.viewportWidth = game.viewportWidth;
        this.viewportHeight = game.viewportHeight;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.viewportWidth, game.viewportHeight);
        titleLayout = new GlyphLayout(game.fontLarge, titleText);
        messageLayout = new GlyphLayout(game.fontMedium, messageText);
        // or for non final texts: layout.setText(font, text);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0, 0,1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        float titleX = (viewportWidth - titleLayout.width) / 2;
        float titleY = (viewportHeight + titleLayout.height) / 1.5f;
        float messageX = (viewportWidth - messageLayout.width) / 2;
        float messageY = titleY - 50;

        game.batch.begin();
        game.fontLarge.draw(game.batch, titleLayout, titleX, titleY);
        game.fontMedium.draw(game.batch, messageLayout, messageX, messageY);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
