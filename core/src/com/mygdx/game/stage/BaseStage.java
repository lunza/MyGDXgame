package com.mygdx.game.stage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;



public class BaseStage extends Stage{
	
	
	private MyGdxGame mainGame;

    /** 舞台是否可见（是否更新和绘制） */
    private boolean visible = true;

    public BaseStage(MyGdxGame mainGame, Viewport viewport) {
        super(viewport);
        this.mainGame = mainGame;
    }

    public MyGdxGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
