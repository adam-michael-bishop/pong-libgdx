package com.mygdx.pong.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import lombok.*;

@Getter
@Setter
public class UIText {
    @Setter(AccessLevel.NONE)
    private String text;
    private final FreeTypeFontGenerator generator;
    private final FreeTypeFontParameter parameter = new FreeTypeFontParameter();
    private BitmapFont font;
    private GlyphLayout layout;

    public UIText(String text, int fontSize, FreeTypeFontGenerator generator) {
        this.generator = generator;
        this.text = text;
        parameter.size = fontSize;
        font = generator.generateFont(parameter);
        layout = new GlyphLayout(font, text);
    }

    public UIText(int fontSize, FreeTypeFontGenerator generator) {
        this.generator = generator;
        parameter.size = fontSize;
        font = generator.generateFont(parameter);
        layout = new GlyphLayout();
    }

    public BitmapFont generateBitmapFont() {
        font = generator.generateFont(parameter);
        return font;
    }

    public GlyphLayout generateGlyphLayout() {
        layout = new GlyphLayout(font, text);
        return layout;
    }

    public void setText(String text) {
        this.text = text;
        layout.setText(font, text);
    }
}
