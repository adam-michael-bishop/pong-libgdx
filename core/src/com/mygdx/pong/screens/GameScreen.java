package com.mygdx.pong.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.pong.Pong;
import com.mygdx.pong.entities.Player;
import com.mygdx.pong.ui.UIText;

public class GameScreen implements Screen {
    private final Pong game;
    private final Player player1 = new Player("P1");
    private final Player player2 = new Player("P2");
    private final UIText p1ScoreDisplay;
    private final UIText p2ScoreDisplay;

    public GameScreen(final Pong game) {
        this.game = game;
        p1ScoreDisplay = new UIText(12, game.fontGenerator);
        p2ScoreDisplay = new UIText(12, game.fontGenerator);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        p1ScoreDisplay.setText(player1.getName() + ": " + player1.getScore());
        p2ScoreDisplay.setText(player2.getName() + ": " + player2.getScore());

        game.batch.begin();
        p1ScoreDisplay.getFont().draw(game.batch, p1ScoreDisplay.getLayout(), game.viewportWidth * 0.05f, game.viewportHeight * 0.95f);
        p2ScoreDisplay.getFont().draw(game.batch, p2ScoreDisplay.getLayout(), (game.viewportWidth * 0.95f) - p2ScoreDisplay.getLayout().width, game.viewportHeight * 0.95f);
        game.fontGenerator.generateFont(new FreeTypeFontParameter()).draw(game.batch, "Gameplay goes here", 150, 150);
        game.batch.end();
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
        p1ScoreDisplay.getFont().dispose();
        p2ScoreDisplay.getFont().dispose();
    }
}
