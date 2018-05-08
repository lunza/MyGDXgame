package com.mygdx.game.actor.group.playerCreate;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.group.BaseGroup;
import com.mygdx.game.actor.player.Carol;
import com.mygdx.game.actor.player.Zeta;
import com.mygdx.game.res.Res;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.ui.button.BaseButton;

public class PlayerButtonGroup extends BaseGroup{
	
	private MyGdxGame mainGame;
	
	public static BaseButton carol;
	public static BaseButton zeta;

	public PlayerButtonGroup(MyGdxGame mainGame) {
		super(mainGame);
		// TODO Auto-generated constructor stub
		initButton();
	}

	private void initButton() {
		
		TextureRegion c_unselect = new TextureRegion((Texture) getMainGame().getAssetManager().get(Res.AtlasNames.CAROl_UNSELECT));
		TextureRegion c_selected= new TextureRegion((Texture) getMainGame().getAssetManager().get(Res.AtlasNames.CAROl_SELECTED));
		
		TextureRegion z_unselect = new TextureRegion((Texture) getMainGame().getAssetManager().get(Res.AtlasNames.ZETA_UNSELECT));
		TextureRegion z_selected= new TextureRegion((Texture) getMainGame().getAssetManager().get(Res.AtlasNames.ZETA_SELECTED));
		
		
		// TODO Auto-generated method stub
		carol =new Carol(c_selected, c_unselect, 0, 0, "Carol", mainGame);
		zeta = new Zeta(z_selected, z_unselect, 400, 0, "Zeta", mainGame);
		
		carol.setSize(300, 450);
		zeta.setSize(300, 450);

		carol.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("xxx");
			}
		});

		addActor(carol);
		addActor(zeta);
		

		//buttonShowAction();

		
	}

}
