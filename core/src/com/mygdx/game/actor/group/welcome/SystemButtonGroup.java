package com.mygdx.game.actor.group.welcome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.actor.BaseActor;
import com.mygdx.game.actor.group.BaseGroup;
import com.mygdx.game.res.Res;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.ui.button.BaseButton;

public class SystemButtonGroup extends BaseGroup {

	private MyGdxGame mainGame;

	public static BaseButton button1;
	public static BaseButton button2;
	public static BaseButton button3;

	public static BaseActor arrow1;
	public static BaseActor arrow2;
	public static BaseActor arrow3;

	public SystemButtonGroup(MyGdxGame mainGame) {
		super(mainGame);
		// TODO Auto-generated constructor stub
		initArrow();
		arrow1.setZIndex(10);
		arrow2.setZIndex(10);
		arrow3.setZIndex(10);
		arrow1.setVisible(true);
		initButton();
		button1.setZIndex(10);
		button2.setZIndex(10);
		button3.setZIndex(10);
	}

	private void initArrow() {
		// TODO Auto-generated method stub
		TextureRegion sys_up = new TextureRegion(
				(Texture) getMainGame().getAssetManager().get(Res.AtlasNames.Button_UP));
		TextureRegion arrow = new TextureRegion(
				(Texture) getMainGame().getAssetManager().get(Res.AtlasNames.ARROW_RIGHT));

		float x = (getMainGame().getWorldWidth() - sys_up.getRegionWidth()) / 2 - 100;
		float y = (getMainGame().getWorldHeight() - sys_up.getRegionHeight()) / 2;

		arrow1 = new BaseActor(arrow, mainGame, x, y);
		arrow2 = new BaseActor(arrow, mainGame, x, y / 3 * 2);
		arrow3 = new BaseActor(arrow, mainGame, x, y / 3 * 1);

		addActor(arrow1);
		addActor(arrow2);
		addActor(arrow3);

		arrow1.setVisible(false);
		arrow2.setVisible(false);
		arrow3.setVisible(false);

		//arrowShowAction();

	}

	private void arrowShowAction() {
		// TODO Auto-generated method stub

		arrow1.getColor().a = 0.0F;
		arrow2.getColor().a = 0.0F;
		arrow3.getColor().a = 0.0F;

		// 获取一个 Alpha 动作, 5 秒内 alpha 变为 0（完全透明）
		SequenceAction sequence1 = Actions.sequence(Actions.alpha(0.0F, 3.0F), Actions.alpha(1.0F, 0.0F));
		SequenceAction sequence2 = Actions.sequence(Actions.alpha(0.0F, 3.0F), Actions.alpha(1.0F, 0.0F));
		SequenceAction sequence3 = Actions.sequence(Actions.alpha(0.0F, 3.0F), Actions.alpha(1.0F, 0.0F));
		RepeatAction repeatAction1 = Actions.repeat(1, sequence1);
		RepeatAction repeatAction2 = Actions.repeat(1, sequence2);
		RepeatAction repeatAction3 = Actions.repeat(1, sequence3);

		// 执行动作
		arrow1.addAction(repeatAction1);
		arrow2.addAction(repeatAction2);
		arrow3.addAction(repeatAction3);

	}

	private void initButton() {
		TextureRegion sys_up = new TextureRegion(
				(Texture) getMainGame().getAssetManager().get(Res.AtlasNames.Button_UP));
		TextureRegion sys_down = new TextureRegion(
				(Texture) getMainGame().getAssetManager().get(Res.AtlasNames.Button_DOWN));

		float x = (getMainGame().getWorldWidth() - sys_up.getRegionWidth()) / 2;
		float y = (getMainGame().getWorldHeight() - sys_up.getRegionHeight()) / 2;

		// TODO Auto-generated method stub
		button1 = new BaseButton(sys_up, sys_down, x, y, "开 始 游 戏", mainGame);
		button2 = new BaseButton(sys_up, sys_down, x, y / 3 * 2, "读 取 存 档", mainGame);
		button3 = new BaseButton(sys_up, sys_down, x, y / 3 * 1, "离 开 游 戏", mainGame);

		button1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				GameScreen.setShowPlayerCreateStage(true);
			}
		});

		addActor(button1);
		addActor(button2);
		addActor(button3);

		//buttonShowAction();

	}

	private void buttonShowAction() {
		// TODO Auto-generated method stub

		button1.getColor().a = 0.0F;
		button2.getColor().a = 0.0F;
		button3.getColor().a = 0.0F;

		// 获取一个 Alpha 动作, 5 秒内 alpha 变为 0（完全透明）
		SequenceAction sequence1 = Actions.sequence(Actions.alpha(0.0F, 3.0F), Actions.alpha(1.0F, 0.0F));
		SequenceAction sequence2 = Actions.sequence(Actions.alpha(0.0F, 3.0F), Actions.alpha(1.0F, 0.0F));
		SequenceAction sequence3 = Actions.sequence(Actions.alpha(0.0F, 3.0F), Actions.alpha(1.0F, 0.0F));
		RepeatAction repeatAction1 = Actions.repeat(1, sequence1);
		RepeatAction repeatAction2 = Actions.repeat(1, sequence2);
		RepeatAction repeatAction3 = Actions.repeat(1, sequence3);

		// 执行动作
		button1.addAction(repeatAction1);
		button2.addAction(repeatAction2);
		button3.addAction(repeatAction3);

	}

}
