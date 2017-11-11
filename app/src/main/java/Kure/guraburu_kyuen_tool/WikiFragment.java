package Kure.guraburu_kyuen_tool;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Wikiページ
 *
 * Created by yuuma on 2017/11/11.
 */

public class WikiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wiki, container, false);
    }
}