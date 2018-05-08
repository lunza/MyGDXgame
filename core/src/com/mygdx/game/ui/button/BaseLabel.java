package com.mygdx.game.ui.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.MyGdxGame;

public class BaseLabel extends Label {



	private BitmapFont bitmapFont;

	
	
	
	public BaseLabel(CharSequence text, LabelStyle style,float x,float y,float width,float height) {
		super(text, style);
		
		 
		
		this.setBounds(x, y, width, height);
		this.setFontScale(0.8f);
		 
		// TODO Auto-generated constructor stub
		 
		 
	}

}
