package com.al7osam.mvvmlivedata.view.ui;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.al7osam.mvvmlivedata.R;
import com.al7osam.mvvmlivedata.view.adapter.SpeciesListAdapter;
import com.al7osam.mvvmlivedata.viewmodel.SpeciesListViewModel;

public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner {
    private LifecycleRegistry registry = new LifecycleRegistry(this);

    private SpeciesListViewModel speciesListViewModel;
    SpeciesListAdapter speciesListAdapter;
    LinearLayoutManager manager;
    RecyclerView rvSpecies;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSpecies = findViewById(R.id.rvSpecies);
        progressBar = findViewById(R.id.progressBar);

        speciesListViewModel = ViewModelProviders.of(this).get(SpeciesListViewModel.class);

        attachObserver();

//        speciesListViewModel.getSpecies();
    }


    private void attachObserver() {
        speciesListViewModel.getSpecies().observe(this, observer -> {
            speciesListAdapter = new SpeciesListAdapter(this, speciesListViewModel);
            manager = new LinearLayoutManager(this);
            rvSpecies.setLayoutManager(manager);
            rvSpecies.setAdapter(speciesListAdapter);
            speciesListAdapter.notifyDataSetChanged();
        });

    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }
}
