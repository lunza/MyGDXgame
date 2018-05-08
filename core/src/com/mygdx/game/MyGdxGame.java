package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.res.Res;
import com.mygdx.game.screen.GameScreen;

/**
 * 
 * @Type
 * @Description: 主游戏
 * @author 孙菁
 * @version 最后修改时间：2018年5月7日 下午3:39:10
 */
public class MyGdxGame extends Game {

	/** 游戏名称 */
	public static final String TAG = "MyGame";

	/** 世界宽度 */
	private float worldWidth;
	/** 世界高度 */
	private float worldHeight;

	/** 资源管理器 */
	private AssetManager assetManager;

	/** 纹理图集 */
	private TextureAtlas atlas;

	/** 位图字体 */
	private BitmapFont bitmapFont;

	/** 主游戏场景 */
	private GameScreen gameScreen;

	@Override
	public void create() {

		Gdx.app.setLogLevel(Application.LOG_DEBUG);

		// 为了不压扁或拉长图片, 按实际屏幕比例计算世界宽高
		worldWidth = Res.FIX_WORLD_WIDTH;
		worldHeight = Gdx.graphics.getHeight() * worldWidth / Gdx.graphics.getWidth();

		//Gdx.app.log(TAG, "World Size: " + worldWidth + " * " + worldHeight);

		// 创建资源管理器
		assetManager = new AssetManager();

		// 加载图片资源
		assetManager.load(Res.AtlasNames.WELCOME_BACK_GROUND, Texture.class);
		assetManager.load(Res.AtlasNames.Button_DOWN, Texture.class);
		assetManager.load(Res.AtlasNames.Button_UP, Texture.class);
		assetManager.load(Res.AtlasNames.LOGO, Texture.class);
		assetManager.load(Res.AtlasNames.ARROW_RIGHT, Texture.class);
		
		assetManager.load(Res.AtlasNames.CAROl_SELECTED, Texture.class);
		assetManager.load(Res.AtlasNames.CAROl_UNSELECT, Texture.class);
		assetManager.load(Res.AtlasNames.ZETA_SELECTED, Texture.class);
		assetManager.load(Res.AtlasNames.ZETA_UNSELECT, Texture.class);
		//加载字体
		assetManager.load(Res.BITMAP_FONT_PATH, BitmapFont.class);
		//加载音效（暂无）
		assetManager.load(Res.Audios.BACKGROUND_MUSIC, Sound.class);
		// assetManager.load(Res.Audios.MERGE, Sound.class);

		// 等待资源加载完毕
		assetManager.finishLoading();

		// 获取资源
		// atlas = assetManager.get(Res.AtlasNames.WELCOME_BACK_GROUND, Texture.class);
		bitmapFont = assetManager.get(Res.BITMAP_FONT_PATH, BitmapFont.class);

		// 创建主游戏场景
		gameScreen = new GameScreen(this);

		// 设置当前场景
		setScreen(gameScreen);

		// 捕获返回键, 手动处理应用的退出（防止“弹出”帮助界面或对话框时按返回键退出应用）
		Gdx.input.setCatchBackKey(true);

	}

	@Override
	public void dispose() {
		super.dispose();
		// 应用退出时, 需要手动销毁场景
		if (gameScreen != null) {
			gameScreen.dispose();
		}
		// 应用退出时释放资源
		if (assetManager != null) {
			assetManager.dispose();
		}
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public float getWorldWidth() {
		return worldWidth;
	}

	public float getWorldHeight() {
		return worldHeight;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	public TextureAtlas getAtlas() {
		return atlas;
	}

	public BitmapFont getBitmapFont() {
		return bitmapFont;
	}
}
