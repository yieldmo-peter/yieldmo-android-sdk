package com.yieldmo.yieldmodemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yieldmo.sdk.YMException;
import com.yieldmo.sdk.YMPlacementView;
import com.yieldmo.sdk.YMViewDelegate;
import com.yieldmo.yieldmodemo.adapter.LayoutDemoAdapter;

public class LayoutDemoFragment extends Fragment {

    private String TAG = "Layout Fragment";
    private ListView listView;
    private View myFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_layout, container, false);

        // Insert ad in 5th row
        YMPlacementView adView = new YMPlacementView.Builder(getActivity())
                .placementId("1017319088019847539")
                .delegate(new YMViewDelegate() {
                    @Override
                    public void adDisplayFailed(YMPlacementView ymView, YMException e) {
                        Log.e(TAG, "Yieldmo Ad Failed");
                    }

                    @Override
                    public void adDisplayed(YMPlacementView ymView) {
                        Log.v(TAG, "Yieldmo Ad Displayed");
                    }
                }).build();

        // Setup List
        listView = (ListView) myFragmentView.findViewById(R.id.list);
        LayoutDemoAdapter adapter = new LayoutDemoAdapter(getActivity(), adView);
        listView.setAdapter(adapter);

        return myFragmentView;
    }
}
