package kure.guraburu_kyuen_tool.domain.model.dbo.db.api;

import android.app.Activity;

/**
 * Created by yuuma on 2017/11/19.
 */

public class TwitterManager{
    private static TwitterManager instance = null;
    private TwitterManager() {

    }

    // シングルトン
    public static TwitterManager getInstance() {
        if (instance == null) {
            instance = new TwitterManager();
        }
        return instance;
    }


}

