package com.al7osam.mvvmlivedata.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.al7osam.mvvmlivedata.repository.listeners.SpeciesRepository;
import com.al7osam.mvvmlivedata.repository.listeners.SpeciesRepositoryImpl;
import com.al7osam.mvvmlivedata.model.Species;

import java.util.List;

/**
 * Created by eman.eraqi on 12/30/2018.
 */

public class SpeciesListViewModel extends ViewModel implements SpeciesRepository {

    MutableLiveData<List<Species>> listMutableLiveData = new MutableLiveData<>();

    SpeciesRepositoryImpl speciesRepository = new SpeciesRepositoryImpl(this);

    public SpeciesListViewModel() {
        getAllSpecies();
    }

    public MutableLiveData<List<Species>> getAllSpecies() {

        return listMutableLiveData = (MutableLiveData<List<Species>>) speciesRepository.getAllSpecies();
    }

    public MutableLiveData<List<Species>> getSpecies() {

        return listMutableLiveData;
    }

    @Override
    public void getSpecies(MutableLiveData<List<Species>> successHandler) {
        listMutableLiveData = successHandler;

    }

    public int getSpeciesSize() {
        return listMutableLiveData.getValue().size();
    }

    public Species getSpeciesAt(int position) {
        if (position < getSpeciesSize()) {
            return listMutableLiveData.getValue().get(position);
        } else
            return null;

    }


    @Override
    public void onError(Throwable t) {

    }
}
