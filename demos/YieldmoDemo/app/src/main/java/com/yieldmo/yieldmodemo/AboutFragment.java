package com.yieldmo.yieldmodemo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yieldmo.sdk.Yieldmo;

public class AboutFragment extends Fragment {

    private View myFragmentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get Version Label
        myFragmentView = inflater.inflate(R.layout.fragment_about, container, false);
        TextView lbl = (TextView) myFragmentView.findViewById(R.id.versionLabel);
        lbl.setText("Yieldmo SDK v" + Yieldmo.getVersion());

        TextView appVersionText = (TextView) myFragmentView.findViewById(R.id.appversionLabel);
        try {
            PackageInfo info = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            appVersionText.setText("v" + info.versionName + " (" + info.versionCode + ")");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            appVersionText.setText("");
        }

        return myFragmentView;
    }


}
