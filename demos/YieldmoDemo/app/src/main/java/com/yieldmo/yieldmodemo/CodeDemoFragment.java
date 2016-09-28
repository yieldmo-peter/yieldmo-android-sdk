package com.yieldmo.yieldmodemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yieldmo.sdk.YMConstants;
import com.yieldmo.sdk.YMException;
import com.yieldmo.sdk.YMPlacementListener;
import com.yieldmo.sdk.YMPlacementView;
import com.yieldmo.yieldmodemo.adapter.CodeDemoAdapter;

public class CodeDemoFragment extends Fragment {

    private String TAG = "Code Fragment";
    private ListView listView;
    private View myFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_code, container, false);

        // Insert YM ad in 5th row
        YMPlacementView adView = new YMPlacementView.Builder(getActivity())
            .placementId(YMConstants.carouselPlacementId)
            .listener(new YMPlacementListener() {
                  @Override
                  public void adDisplayFailed(YMException e) {
                      Log.e(TAG, "Yieldmo Ad Failed");
                  }

                  @Override
                  public void adDisplayed() {
                      Log.v(TAG, "Yieldmo Ad Displayed");
                  }

                  @Override
                  public void adLeavesApplication() {
                    Log.v(TAG, "Yieldmo Ad Leaves Application");
                  }

                  @Override
                  public void adClicked() {
                    Log.v(TAG, "Yieldmo Ad Clicked");
                  }
            }).build();

        // Setup List
        listView = (ListView) myFragmentView.findViewById(R.id.list);
        CodeDemoAdapter adapter = new CodeDemoAdapter(getActivity(), adView);
        listView.setAdapter(adapter);

        return myFragmentView;
    }
}
