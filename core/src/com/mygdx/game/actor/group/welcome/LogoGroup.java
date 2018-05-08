package com.mygdx.game.actor.group.welcome;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.actor.actor.BaseActor;
import com.mygdx.game.actor.group.BaseGroup;
import com.mygdx.game.res.Res;

public class LogoGroup extends BaseGroup{
	
    private BaseActor logoActor1;
    private BaseActor logoActor2;
    private BaseActor backGroundActor;
    

	public LogoGroup(MyGdxGame mainGame) {
		super(mainGame);
		// TODO Auto-generated constructor stub
		initLogo();
		
		initBackGround();
		logoActor1.setZIndex(new Integer(Integer.MAX_VALUE));
	}
	
	private void initLogo() {

		TextureRegion t_logo = new TextureRegion((Texture) getMainGame().getAssetManager().get(Res.AtlasNames.LOGO));
    	logoActor1 = new BaseActor(t_logo,getMainGame(),0,0);
    	logoActor2 = new BaseActor(t_logo,getMainGame(),0,0);
        addActor(logoActor1);
        addActor(logoActor2);
        // 1. 移动动作
        logoMoveToCenterAction();
        // 设置组的宽高（以世界的宽度, LOGO 的高度 作为组的宽高）
        setSize(getMainGame().getWorldWidth(), logoActor1.getHeight());
        
    }
	private void initBackGround() {
		TextureRegion t_background = new TextureRegion((Texture) getMainGame().getAssetManager().get(Res.AtlasNames.WELCOME_BACK_GROUND));
		backGroundActor = new BaseActor(t_background,getMainGame(),0,0);
		addActor(backGroundActor);
		setSize(getMainGame().getWorldWidth(), getMainGame().getWorldHeight());
		backgroundShowAction();
	}

    private void logoMoveToCenterAction() {
    	
    	float middleY = (getMainGame().getWorldHeight()-logoActor1.getHeight())/2;
    	float middleX = (getMainGame().getWorldWidth()-logoActor1.getWidth())/2;
    	
    	 // 设置演员初始化位置
    	logoActor1.setPosition(0-logoActor1.getWidth(), middleY/2*3);
    	logoActor2.setPosition(getMainGame().getWorldWidth(),middleY/2*3);

        // 获取一个 MoveTo 动作, 3 秒内移动到 (150, 300) 的位置
        MoveToAction action1 = Actions.moveTo(middleX, middleY/2*3, 1.0F);
        MoveToAction action2 = Actions.moveTo(middleX, middleY/2*3, 1.0F);

        // 将动作附加在演员身上, 执行动作
        logoActor1.addAction(action1);
        logoActor2.addAction(action2);
        
      
		
	}

    private void backgroundShowAction() {
    	backGroundActor.setPosition(0,0);
    	 // 设置演员初始 alpha 值为 1（完全不透明, 默认就是为 1）
    	backGroundActor.getColor().a = 0.0F;

        // 获取一个 Alpha 动作, 5 秒内 alpha 变为 0（完全透明）
    	 SequenceAction sequence = Actions.sequence(
    			 Actions.alpha(0.0F, 0.5F),
                 Actions.alpha(1.0F, 3.0F)
         );
    	 RepeatAction repeatAction = Actions.repeat(1, sequence);
       

        // 执行动作
        backGroundActor.addAction(repeatAction);
        
    	
    }
}


