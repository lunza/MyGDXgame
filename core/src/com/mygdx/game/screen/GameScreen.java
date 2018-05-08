package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.group.welcome.SystemButtonGroup;
import com.mygdx.game.res.Res;
import com.mygdx.game.stage.PlayerCreateStage;
import com.mygdx.game.stage.WelcomeStage;

/**
 * 
 * @Type
 * @Description: 主游戏界面
 * @author 孙菁
 * @version 最后修改时间：2018年5月7日 下午3:45:24
 */
public class GameScreen extends ScreenAdapter {

	private MyGdxGame mainGame;

	/** 1. 主游戏舞台 */
	private static WelcomeStage gameStage;

	/** 2.其他舞台 */
	private static PlayerCreateStage playerCreateStage;

	public GameScreen(MyGdxGame mainGame) {
		this.mainGame = mainGame;
		init();
	}

	private void init() {
		// 1. 创建主游戏舞台
		gameStage = new WelcomeStage(mainGame,
				new StretchViewport(mainGame.getWorldWidth(), mainGame.getWorldHeight()));
		playerCreateStage = new PlayerCreateStage(mainGame,
				new StretchViewport(mainGame.getWorldWidth(), mainGame.getWorldHeight()));

		playerCreateStage.setVisible(false); // 除主游戏舞台外, 其他舞台先设置为不可见

		// 把输入处理设置到主游戏舞台（必须设置, 否则无法接收用户输入）
		Gdx.input.setInputProcessor(gameStage);
	}

	/**
	 * 重新开始游戏
	 */
	// public void restartGame() {
	// gameStage.restartGame();
	// }

	/**
	 * 帮助舞台 是否显示
	 */
	public static void setShowPlayerCreateStage(boolean showPlayerCreateStage) {
		playerCreateStage.setVisible(showPlayerCreateStage);
		if (playerCreateStage.isVisible()) {
			// 如果显示帮助舞台, 则把输入处理设置到帮助舞台
			Gdx.input.setInputProcessor(playerCreateStage);
		} else {
			// 不显示帮助舞台, 把输入处理设置回主游戏舞台
			Gdx.input.setInputProcessor(gameStage);
		}
	}

	@Override
	public void render(float delta) {
		// 使用背景颜色清屏
		Gdx.gl.glClearColor(Res.BG_RGBA.r, Res.BG_RGBA.g, Res.BG_RGBA.b, Res.BG_RGBA.a);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/*
		 * 更新舞台逻辑, 绘制舞台
		 */

		// 1. 主游戏舞台始终都需要绘制, 并且最先绘制
		gameStage.act();

		gameStage.draw();

		changeArrow();
	}

	@Override
	public void dispose() {
		// 场景销毁时, 同时销毁所有舞台
		if (gameStage != null) {
			gameStage.dispose();
		}

	}

	public WelcomeStage getGameStage() {
		return gameStage;
	}

	private void changeArrow() {
		Button button1 = SystemButtonGroup.button1;
		Button button2 = SystemButtonGroup.button2;
		Button button3 = SystemButtonGroup.button3;

		Actor arrow1 = SystemButtonGroup.arrow1;
		Actor arrow2 = SystemButtonGroup.arrow2;
		Actor arrow3 = SystemButtonGroup.arrow3;

		if (button1.isOver()) {
			arrow1.setVisible(true);
			arrow2.setVisible(false);
			arrow3.setVisible(false);

		} else if (button2.isOver()) {
			arrow1.setVisible(false);
			arrow2.setVisible(true);
			arrow3.setVisible(false);

		} else if (button3.isOver()) {
			arrow1.setVisible(false);
			arrow2.setVisible(false);
			arrow3.setVisible(true);

		}
	}

}
