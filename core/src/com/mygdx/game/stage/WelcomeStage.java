package com.mygdx.game.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.group.welcome.BottomGroup;
import com.mygdx.game.actor.group.welcome.LogoGroup;
import com.mygdx.game.actor.group.welcome.SystemButtonGroup;
import com.mygdx.game.actor.group.welcome.SystemButtonLabelGroup;

public class WelcomeStage extends BaseStage {

	public static LogoGroup logoGroup;

	public static SystemButtonGroup buttonGroup;

	public static SystemButtonLabelGroup buttonLabelGroup;

	/** 底部演员组（包括 游戏帮助 和 退出游戏 按钮） */
	public static BottomGroup bottomGroup;

	public WelcomeStage(MyGdxGame mainGame, Viewport viewport) {
		super(mainGame, viewport);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		logoGroup = new LogoGroup(getMainGame());
		logoGroup.setX((getWidth() - logoGroup.getWidth()) / 2); // 水平居中
		logoGroup.setY(0); // 顶部竖直居中

		addActor(logoGroup);

		bottomGroup = new BottomGroup(getMainGame());
		bottomGroup.setX((getWidth() - bottomGroup.getWidth()) / 2); // 水平居中
		bottomGroup.setY(0); // 顶部竖直居中
		addActor(bottomGroup);
		bottomGroup.setZIndex(2);
		bottomGroup.setVisible(true);

		buttonGroup = new SystemButtonGroup(getMainGame());
		buttonGroup.setX((getWidth() - logoGroup.getWidth()) / 2); // 水平居中
		buttonGroup.setY(0); // 顶部竖直居中
		addActor(buttonGroup);
		buttonGroup.setZIndex(3);
		buttonGroup.setVisible(false);

		buttonLabelGroup = new SystemButtonLabelGroup(getMainGame());
		buttonLabelGroup.setX((getWidth() - logoGroup.getWidth()) / 2 + 10);
		buttonLabelGroup.setY(30);
		addActor(buttonLabelGroup);
		buttonLabelGroup.setZIndex(4);
		buttonLabelGroup.setVisible(false);

		this.addListener(new WelcomeInputListener());

	}

	@Override
	public void dispose() {
		super.dispose();
		// 舞台销毁时保存最佳分数
		// Preferences prefs = Gdx.app.getPreferences(Res.Prefs.FILE_NAME);

		// prefs.flush();
	}

	/**
	 * 
	 * @Type WelcomeStage
	 * @Description: 欢迎页面监听
	 * @author 孙菁
	 * @version 最后修改时间：2018年5月7日 下午5:15:29
	 */
	private class WelcomeInputListener extends InputListener {
		/**
		 * 当有键盘按键被按下时调用, 参数 keycode 是被按下的按键的键值, 所有键盘按键的键值常量定义在
		 * com.badlogic.gdx.Input.Keys 类中
		 */
		@Override
		public boolean keyDown(InputEvent event, int keycode) {
			switch (keycode) {
			case Input.Keys.UP: {
				Gdx.app.log("", "被按下的按键: 方向上键");
				break;
			}
			case Input.Keys.DOWN: {
				Gdx.app.log("", "被按下的按键: 方向下键 ");
				break;
			}
			case Input.Keys.ENTER: {
				Gdx.app.log("", "被按下的按键: 回车键");
				bottomGroup.setVisible(false);
				buttonGroup.setVisible(true);
				buttonLabelGroup.setVisible(true);

				break;
			}
			default: {
				Gdx.app.log("", "其他按键, KeyCode: " + keycode);
				break;
			}
			}
			return false;
		}

	}
}
