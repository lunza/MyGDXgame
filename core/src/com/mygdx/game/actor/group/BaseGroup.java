package com.mygdx.game.actor.group;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.MyGdxGame;

public abstract class BaseGroup extends Group {

    private MyGdxGame mainGame;

    public BaseGroup(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }

    public MyGdxGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }
}
