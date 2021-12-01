package com.blackbirds.shakil.demoactivitytofragment.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blackbirds.shakil.demoactivitytofragment.Adapter.ImageListAdapter;
import com.blackbirds.shakil.demoactivitytofragment.R;
import com.blackbirds.shakil.demoactivitytofragment.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private RecyclerView recyclerImage;
    private ImageListAdapter adapter;
    private LinearLayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerImage = root.findViewById(R.id.recyclerImage);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerImage.setLayoutManager(layoutManager);

        homeViewModel.getMovieListMutable().observe(getViewLifecycleOwner(), photosModels -> {

            adapter = new ImageListAdapter(getContext(), photosModels);
            recyclerImage.setAdapter(adapter);
            recyclerImage.setHasFixedSize(true);
            Log.e("Data", "Response: " + photosModels.size());
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}