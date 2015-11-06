package com.yieldmo.adt.yieldmodemo;

import java.util.ArrayList;
import java.util.List;

import com.yieldmo.adt.yieldmodemo.adapter.CodeDemoAdapter;
import com.yieldmo.sdk.YMException;
import com.yieldmo.sdk.YMPlacementView;
import com.yieldmo.sdk.YMViewDelegate;
import com.yieldmo.sdk.view.YMConfigurationView;
import com.yieldmo.adt.yieldmodemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CodeDemoFragment extends Fragment {
	private String TAG = "Code Fragment";
    private ListView listView ;
    private View myFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_code, container, false);

        // Yielmo Init
        ViewGroup rootView = (ViewGroup) myFragmentView.findViewById(R.id.rootView);
        List<String> placementIds = new ArrayList<>();
        placementIds.add("1017404126652644124");
        YMConfigurationView infoView = new YMConfigurationView(getActivity(), placementIds);
        rootView.addView(infoView);

        // Insert ad in 5th row
		YMPlacementView adView = new YMPlacementView.Builder(getActivity()).placementId("1017404126652644124")
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
        CodeDemoAdapter adapter = new CodeDemoAdapter(getActivity(), adView);
        listView.setAdapter(adapter);

        return myFragmentView;
    }

}
