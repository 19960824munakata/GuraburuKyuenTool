package kure.guraburu_kyuen_tool;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kure.guraburu_kyuen_tool.service.TestService;

import static android.content.ContentValues.TAG;

/**
 * 救援ページ
 *
 * Created by yuuma on 2017/11/11.
 */

public class ReliefFragment extends Fragment implements View.OnClickListener {
    private String TAG = "ReliefFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_relief, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Button btn = (Button)getActivity().findViewById(R.id.start);
        btn.setOnClickListener(this);
        btn = (Button)getActivity().findViewById(R.id.stop);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.start:
                Log.d(TAG, "startService");
                intent = new Intent(getActivity().getApplication(), TestService.class);
                getActivity().startService(intent);
                break;
            case R.id.stop:
                Log.d(TAG, "stopService");
                intent = new Intent(getActivity().getApplication(), TestService.class);
                getActivity().stopService(intent);
                break;
            default:
        }
    }
}
