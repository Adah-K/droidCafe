package com.example.mydroidcaffev1;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;// Allows us to manage the fragments
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    //Number of pages to be shown
    int num_pages;
    //Behaviour is the number of screen slides/pages
    public PagerAdapter(@NonNull FragmentManager fm, int behaviour) {
        super(fm,behaviour);
        this.num_pages=behaviour;
    }

    @NonNull
    @Override
    //getItem() is used to supply instances of ScreenSlidePageFragment as new pages
    //this enables you to also choose the intended fragment using a switch case. When one case is selected, the
    //fragment is loaded
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new DessertRecipeFragment();
            case 1: return new PastriesRecipeFragment();
            case 2: return new StoresFragment();
            default: return null;
        }

    }

    @Override
    //getCount() returns the amount of pages the adapter will create.
    //returns the number of pages that the PageAdapter will supply to the ViewAdapter
    public int getCount() {
        return num_pages;
    }
}

