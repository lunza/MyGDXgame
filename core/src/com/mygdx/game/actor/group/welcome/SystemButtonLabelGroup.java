package com.mygdx.game.actor.group.welcome;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.group.BaseGroup;
import com.mygdx.game.res.Res;
import com.mygdx.game.ui.button.BaseLabel;

public class SystemButtonLabelGroup extends BaseGroup {

	private MyGdxGame mainGame;
	private BitmapFont bitmapFont;
	
	private LabelStyle style;

	private BaseLabel label1;
	private BaseLabel label2;
	private BaseLabel label3;

	public SystemButtonLabelGroup(MyGdxGame mainGame) {
		super(mainGame);
		bitmapFont = new BitmapFont(Gdx.files.internal("fonts/bitmapfont.fnt"));
		style = new Label.LabelStyle();
		style.font = bitmapFont;
		style.fontColor = new Color(1, 1, 1, 0.7f);
		
		// TODO Auto-generated constructor stub
		initButtonLabel();
		label1.setZIndex(9);
		label2.setZIndex(9);
		label3.setZIndex(9);

	}

	private void initButtonLabel() {
		// TODO Auto-generated method stub
		TextureRegion sys_up = new TextureRegion(
				(Texture) getMainGame().getAssetManager().get(Res.AtlasNames.Button_UP));
		float x = (getMainGame().getWorldWidth() - sys_up.getRegionWidth()) / 2;
		float y = (getMainGame().getWorldHeight() - sys_up.getRegionHeight()) / 2;
		
		label1 = new BaseLabel("开 始 游 戏", style, x, y, 0, 0);
		label2 = new BaseLabel("读 取 游 戏", style, x, y / 3 * 2, 0, 0);
		label3 = new BaseLabel("结 束 游 戏", style, x, y / 3 * 1, 0, 0);

		addActor(label1);
		addActor(label2);
		addActor(label3);
		
		labelShowAction();

	}

	private void labelShowAction() {
		// TODO Auto-generated method stub
		
		
		label1.getColor().a = 0.0F;
		label2.getColor().a = 0.0F;
		label3.getColor().a = 0.0F;

        // 获取一个 Alpha 动作, 5 秒内 alpha 变为 0（完全透明）
    	 SequenceAction sequence1 = Actions.sequence(
    			 Actions.alpha(0.0F, 3.0F),
                 Actions.alpha(1.0F, 0.0F)
         );
    	 SequenceAction sequence2 = Actions.sequence(
    			 Actions.alpha(0.0F, 3.0F),
                 Actions.alpha(1.0F, 0.0F)
         );
    	 SequenceAction sequence3 = Actions.sequence(
    			 Actions.alpha(0.0F, 3.0F),
                 Actions.alpha(1.0F, 0.0F)
         );
    	 RepeatAction repeatAction1 = Actions.repeat(1, sequence1);
    	 RepeatAction repeatAction2 = Actions.repeat(1, sequence2);
    	 RepeatAction repeatAction3 = Actions.repeat(1, sequence3);
       

        // 执行动作
    	 label1.addAction(repeatAction1);
    	 label2.addAction(repeatAction2);
    	 label3.addAction(repeatAction3);
		
	}

}
