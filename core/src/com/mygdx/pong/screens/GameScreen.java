package com.mygdx.pong.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.pong.Pong;
import com.mygdx.pong.entities.Player;

public class GameScreen implements Screen {
    private final Pong game;
    private final Player player1 = new Player("P1");
    private final Player player2 = new Player("P2");
    private final GlyphLayout p1ScoreLayout = new GlyphLayout();
    private final GlyphLayout p2ScoreLayout = new GlyphLayout();
    private final BitmapFont scoreFont;
    public GameScreen(final Pong game) {
        this.game = game;
        scoreFont = game.fontMedium;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        p1ScoreLayout.setText(scoreFont, player1.getName() + ": " + player1.getScore());
        p2ScoreLayout.setText(scoreFont, player2.getName() + ": " + player2.getScore());

        game.batch.begin();
        scoreFont.draw(game.batch, p1ScoreLayout, game.viewportWidth * 0.05f, game.viewportHeight * 0.95f);
        scoreFont.draw(game.batch, p2ScoreLayout, (game.viewportWidth * 0.95f) - p2ScoreLayout.width, game.viewportHeight * 0.95f);
        game.fontLarge.draw(game.batch, "Gameplay goes here", 150, 150);
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

    }
}
