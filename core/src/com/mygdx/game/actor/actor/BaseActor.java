package com.mygdx.game.actor.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Pool.Poolable;
import com.badlogic.gdx.utils.Pools;
import com.mygdx.game.MyGdxGame;

/**
 * 自定义演员（绘制时处理 位置，尺寸，缩放比，旋转角度 和 color/alpha 等属性）
 */
public class BaseActor extends Actor implements Poolable{

    private TextureRegion region;
    
    private Texture bgTexture;

    
    private MyGdxGame mainGame;

    public BaseActor(TextureRegion region,MyGdxGame mainGame,float x,float y) {
        super();
        this.region = region;
        this.mainGame = mainGame;
        this.setPosition(x, y);
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    public TextureRegion getRegion() {
        return region;
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
        setSize(this.region.getRegionWidth(), this.region.getRegionHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
	public void draw(Batch batch, float parentAlpha) {
		Color color = getColor();
		batch.setColor(color.r, color.g, color.b, color.a);

		float x = getX();
		float y = getY();
		float scaleX = getScaleX();
		float scaleY = getScaleY();

		float width = getWidth();
		float height = getHeight();

		if (bgTexture != null) {
			batch.draw(bgTexture, x, y, getOriginX(), getOriginY(), getWidth(), getHeight(), scaleX, scaleY,
					getRotation(), 0, 0, (int) width, (int) height, false, false);
		}

		if (region != null) {
			if (region instanceof Sprite) {
				Sprite sprite = (Sprite) region;
				sprite.setColor(batch.getColor());
				sprite.setOrigin(getOriginX(), getOriginY());
				sprite.setPosition(x, y);
				sprite.setScale(scaleX, scaleY);
				sprite.setSize(width, height);
				sprite.setRotation(getRotation());
				sprite.draw(batch);
			} else {
				batch.draw(region, x, y, getOriginX(), getOriginY(), width, height, scaleX, scaleY,
						getRotation());
			}
		}
	}

	public void setBgTexture(Texture bgTexture) {
		this.bgTexture = bgTexture;
		if (bgTexture != null) {
			setSize(bgTexture.getWidth(), bgTexture.getHeight());
		}
		setOrigin(Align.center);
	}
    public MyGdxGame getMainGame() {
        return mainGame;
    }

    public void setMainGame(MyGdxGame mainGame) {
        this.mainGame = mainGame;
    }
    
    @Override
	public boolean remove() {
		boolean remove = super.remove();
		if (remove) {
			Pools.free(this);
		}
		return remove;
	}

    @Override
	public void reset() {
	        // 初始化
		this.bgTexture = null;
		this.region = null;
		setScale(1);
		setRotation(0);
		clear();
		setUserObject(null);
		this.setColor(new Color(1, 1, 1, 1));
		setStage(null);
		setParent(null);
		setVisible(true);
		setName(null);
		setOrigin(Align.center);
		setPosition(0, 0);
	}
}