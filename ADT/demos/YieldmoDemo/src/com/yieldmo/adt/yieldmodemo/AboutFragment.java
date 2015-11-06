package com.yieldmo.adt.yieldmodemo;


import com.yieldmo.sdk.YMSdk;
import com.yieldmo.adt.yieldmodemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutFragment extends Fragment {

    private View myFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get Version Label
        myFragmentView = inflater.inflate(R.layout.fragment_about, container, false);
        TextView lbl = (TextView) myFragmentView.findViewById(R.id.versionLabel);
        lbl.setText("Yieldmo SDK v" + YMSdk.getVersion());

        return myFragmentView;
    }


}
