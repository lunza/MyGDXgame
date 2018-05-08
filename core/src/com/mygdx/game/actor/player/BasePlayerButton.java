package com.mygdx.game.actor.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.actor.BaseActor;
import com.mygdx.game.ui.button.BaseButton;

public class BasePlayerButton extends BaseButton{
	
	private String name;
	
	private TextureRegion playerFullImageUnselect;
	
	private TextureRegion playerFullImageSelected;
	
	private ButtonStyle style;
	
	public BasePlayerButton(TextureRegion upTextureRegion, TextureRegion downTextureRegion, float x, float y,
			String buttonName, MyGdxGame mainGame) {
		super(upTextureRegion, downTextureRegion, x, y, buttonName, mainGame);
		// TODO Auto-generated constructor stub
	}

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
