package com.mygdx.game.actor.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ui.button.BaseButton;

public class Carol extends BaseButton{
	

	private MyGdxGame mainGame;
	
	private TextureRegion playerFullImageUnselect;
	
	private TextureRegion playerFullImageSelected;
	
	private ButtonStyle style;
	
	private Carol(TextureRegion upTextureRegion, TextureRegion downTextureRegion, float x, float y, String buttonName,
			MyGdxGame mainGame) {
		super(upTextureRegion, downTextureRegion, x, y, buttonName, mainGame);
		// TODO Auto-generated constructor stub
	}

	
	
	public BaseButton getCarol() {
		
		
		
		return new Carol(playerFullImageUnselect, playerFullImageSelected, 0, 0, "Carol", mainGame);
	}

}
