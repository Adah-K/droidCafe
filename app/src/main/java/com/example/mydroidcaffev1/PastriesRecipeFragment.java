package com.example.mydroidcaffev1;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastriesRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastriesRecipeFragment extends Fragment {
    private RecyclerView pastriesRecyclerView;
    private ArrayList<Pastries> pastriesData;
    private PastriesAdapter pastriesAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PastriesRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastriesRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastriesRecipeFragment newInstance(String param1, String param2) {
        PastriesRecipeFragment fragment = new PastriesRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View pastriesView = inflater.inflate(R.layout.fragment_pastries_recipe, container, false);
        pastriesRecyclerView = pastriesView.findViewById(R.id.pastries_recycler_view);
        pastriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pastriesData = new ArrayList<>();
        pastriesAdapter = new PastriesAdapter(pastriesData,getContext());
        pastriesRecyclerView.setAdapter(pastriesAdapter);
        initialization();
        return pastriesView;
    }

    private void initialization() {
        String[] pastriesTitles = getResources().getStringArray(R.array.pastries_recipe_title);
        String[] pastriesDescription = getResources().getStringArray(R.array.pastries_recipe_description);
        String[] pastriesPrepTime = getResources().getStringArray(R.array.pastries_prep_time);
        TypedArray pastriesImages = getResources().obtainTypedArray(R.array.pastries_images);
        pastriesData.clear();
        for(int i = 0; i < pastriesTitles.length; i++) {
            pastriesData.add(new Pastries(pastriesImages.getResourceId(i, 0),pastriesTitles[i],pastriesPrepTime[i], pastriesDescription[i]));
        }
            pastriesImages.recycle();
            pastriesAdapter.notifyDataSetChanged();

    }
}