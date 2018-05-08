package com.mygdx.game.actor.group.welcome;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.actor.BaseActor;
import com.mygdx.game.actor.group.BaseGroup;
import com.mygdx.game.ui.button.BaseLabel;


public class BottomGroup extends BaseGroup{
	
	public BaseLabel label;
	private BitmapFont bitmapFont;
	
	private LabelStyle style;

	public BottomGroup(MyGdxGame mainGame) {
		super(mainGame);
		bitmapFont = new BitmapFont(Gdx.files.internal("fonts/bitmapfont.fnt"));
		style = new Label.LabelStyle();
		style.font = bitmapFont;
		style.fontColor = new Color(1, 1, 1, 1);
		init();
		label.setZIndex(10);
		
		
	}

	private void init() {
		// TODO Auto-generated method stub
		float x = (getMainGame().getWorldWidth()-150) / 2;
		float y = (getMainGame().getWorldHeight()) / 2;
		
		setSize(getMainGame().getWorldWidth(), getMainGame().getWorldHeight());
		
		label = new BaseLabel("PRESS ENTER", style, x, y, 0, 0);
		label.setFontScale(1.0f);
		addActor(label);
		
		labelShowAction();
		
	}

	private void labelShowAction() {
		// TODO Auto-generated method stub
		label.getColor().a = 0.0F;
		Action action1 = Actions.alpha(0.0F, 5.0F);
		label.addAction(action1);
		
		 SequenceAction sequence2 = Actions.sequence(
    			 Actions.alpha(0.0F, 1.0F),
                 Actions.alpha(1.0F, 1.0F)
         );
		 RepeatAction repeatAction2 = Actions.forever(sequence2);
		 
		 label.addAction(repeatAction2);
	}

}
