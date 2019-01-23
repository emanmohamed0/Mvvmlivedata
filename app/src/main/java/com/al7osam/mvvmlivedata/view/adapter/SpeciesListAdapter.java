package com.al7osam.mvvmlivedata.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.al7osam.mvvmlivedata.R;
import com.al7osam.mvvmlivedata.model.Species;
import com.al7osam.mvvmlivedata.viewmodel.SpeciesListViewModel;



/**
 * Created by eman.eraqi on 12/30/2018.
 */

public class SpeciesListAdapter extends RecyclerView.Adapter<SpeciesListAdapter.MyViewHolder> {
    SpeciesListViewModel listViewModel;
    Context context;

    public SpeciesListAdapter(Context context, SpeciesListViewModel listViewModel) {
        this.context = context;
        this.listViewModel = listViewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Species obj = listViewModel.getSpeciesAt(i);
        myViewHolder.name.setText(obj.getName());
        myViewHolder.language.setText(obj.getLanguage());
        myViewHolder.classification.setText(obj.getClassification());
        myViewHolder.lifeSpan.setText(obj.getLifeSpan());
    }

    @Override
    public int getItemCount() {
        return listViewModel.getSpeciesSize();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, language, classification, lifeSpan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            language = itemView.findViewById(R.id.language);
            classification = itemView.findViewById(R.id.classification);
            lifeSpan = itemView.findViewById(R.id.lifeSpan);
        }
    }
}
