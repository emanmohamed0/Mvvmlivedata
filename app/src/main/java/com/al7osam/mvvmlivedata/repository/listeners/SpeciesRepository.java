package com.al7osam.mvvmlivedata.repository.listeners;

import android.arch.lifecycle.MutableLiveData;

import com.al7osam.mvvmlivedata.model.Species;

import java.util.List;



/**
 * Created by eman.eraqi on 12/30/2018.
 */

public interface SpeciesRepository {

     void getSpecies(MutableLiveData<List<Species>> successHandler);
     void onError(Throwable t);
}
