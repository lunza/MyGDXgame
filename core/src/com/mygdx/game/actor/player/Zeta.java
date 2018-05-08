package com.mygdx.game.actor.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.ui.button.BaseButton;

public class Zeta extends BaseButton {

	private MyGdxGame mainGame;

	private TextureRegion playerFullImageUnselect;

	private TextureRegion playerFullImageSelected;

	private ButtonStyle style;

	private Zeta(TextureRegion upTextureRegion, TextureRegion downTextureRegion, float x, float y, String buttonName,
			MyGdxGame mainGame) {
		super(upTextureRegion, downTextureRegion, x, y, buttonName, mainGame);
		// TODO Auto-generated constructor stub
	}

	public BaseButton getZeta() {

		return new Zeta(playerFullImageUnselect, playerFullImageSelected, 0, 0, "Zeta", mainGame);
	}

}
