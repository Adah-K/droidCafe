package com.example.mydroidcaffev1;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DessertRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DessertRecipeFragment extends Fragment {
    private RecyclerView dessertRecyclerView;
    private ArrayList<Recipe> dessertRecipeData;
    private RecipeAdapter dessertAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DessertRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DessertRecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DessertRecipeFragment newInstance(String param1, String param2) {
        DessertRecipeFragment fragment = new DessertRecipeFragment();
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
      View rootView =  inflater.inflate(R.layout.fragment_dessert_recipe, container, false);
      dessertRecyclerView = rootView.findViewById(R.id.recycler_view);
      dessertRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      dessertRecipeData = new ArrayList<>();
      dessertAdapter = new RecipeAdapter(dessertRecipeData,getContext());
      dessertRecyclerView.setAdapter(dessertAdapter);
      initializeData();
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();

                Collections.swap(dessertRecipeData,from,to);
                dessertAdapter.notifyItemMoved(from,to);

                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                dessertRecipeData.remove(viewHolder.getAdapterPosition());
                dessertAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(dessertRecyclerView);

      return rootView;
    }

    private void initializeData()
    {
        String[] dessertTitles = getResources().getStringArray(R.array.dessert_recipe_title);
        String[] dessertDescription = getResources().getStringArray(R.array.dessert_recipe_description);
        TypedArray dessertImages = getResources().obtainTypedArray(R.array.dessert_images);
        dessertRecipeData.clear();
        for(int i = 0; i < dessertTitles.length; i++) {
            dessertRecipeData.add(new Recipe(dessertImages.getResourceId(i, 0), dessertTitles[i], dessertDescription[i]));
        }
            dessertImages.recycle();
            dessertAdapter.notifyDataSetChanged();

    }
}