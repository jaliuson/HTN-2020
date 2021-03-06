package com.example.versa_app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.versa_app.DrinkActivity;
import com.example.versa_app.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final TextView textView = root.findViewById(R.id.text_home);
        //final ListView suggestions = root.findViewById(R.id.suggested_list);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
    /*
    public void onSuggestedClick(View v){
        Intent i = new Intent(getActivity(), DrinkActivity.class);
        i.putExtra("info" , "Robert Mondavi Cabernet 2018*3,Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sollicitudin arcu at quam aliquam");
        getActivity().startActivity(i);
    }*/

    public void onRecoPick (View v){

    }
}
