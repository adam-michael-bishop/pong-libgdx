package com.mygdx.pong.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.pong.Pong;
import com.mygdx.pong.ui.UIText;

public class MainMenuScreen implements Screen {
    private final Pong game;
    private final OrthographicCamera camera;
    private final float viewportWidth;
    private final float viewportHeight;
    final UIText title;
    final UIText subtitle;

    public MainMenuScreen(final Pong game) {
        this.game = game;
        this.viewportWidth = game.viewportWidth;
        this.viewportHeight = game.viewportHeight;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.viewportWidth, game.viewportHeight);
        title = new UIText("PONG", 20, game.fontGenerator);
        subtitle = new UIText("press any key to start", 12, game.fontGenerator);
        // or for non final texts: getLayout().setText(font, text);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0, 0,1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        float titleX = (viewportWidth - title.getLayout().width) / 2;
        float titleY = (viewportHeight + title.getLayout().height) / 1.5f;
        float messageX = (viewportWidth - subtitle.getLayout().width) / 2;
        float messageY = titleY - 50;

        game.batch.begin();
        title.getFont().draw(game.batch, title.getLayout(), titleX, titleY);
        subtitle.getFont().draw(game.batch, subtitle.getLayout(), messageX, messageY);
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
        title.getFont().dispose();
        subtitle.getFont().dispose();
    }
}
