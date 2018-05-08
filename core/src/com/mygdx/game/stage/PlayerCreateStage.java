package com.mygdx.game.stage;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.group.playerCreate.PlayerButtonGroup;
import com.mygdx.game.actor.group.welcome.SystemButtonGroup;

public class PlayerCreateStage extends BaseStage {
	
	public static PlayerButtonGroup playerGroup;
	
	public PlayerCreateStage(MyGdxGame mainGame, Viewport viewport) {
		super(mainGame, viewport);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		playerGroup = new PlayerButtonGroup(getMainGame());
		playerGroup.setX(0); // 水平居中
		playerGroup.setY(0); // 顶部竖直居中
		addActor(playerGroup);
		playerGroup.setZIndex(3);
		playerGroup.setVisible(true);
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		// 舞台销毁时保存最佳分数
		// Preferences prefs = Gdx.app.getPreferences(Res.Prefs.FILE_NAME);

		// prefs.flush();
	}


}
