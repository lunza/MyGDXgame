package com.mygdx.game.ui.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.res.Res;

public class BaseButton extends Button{
    
	 private MyGdxGame mainGame;
    
    private ButtonStyle buttonStyle;

	public BaseButton(TextureRegion upTextureRegion, TextureRegion downTextureRegion,
			float x,float y,String buttonName, MyGdxGame mainGame) {
		super();
		setSize(upTextureRegion.getRegionWidth(), downTextureRegion.getRegionHeight());
		this.setPosition(x, y);
		
		this.buttonStyle = new ButtonStyle();
		buttonStyle.up = new TextureRegionDrawable(downTextureRegion);
		buttonStyle.down = new TextureRegionDrawable(downTextureRegion);
		buttonStyle.over = new TextureRegionDrawable(upTextureRegion);
		
		this.setStyle(buttonStyle);
        
	
	}

	public BaseButton() {
		// TODO Auto-generated constructor stub
	}

	public MyGdxGame getMainGame() {
		return mainGame;
	}

	public void setMainGame(MyGdxGame mainGame) {
		this.mainGame = mainGame;
	}
    
	
}
