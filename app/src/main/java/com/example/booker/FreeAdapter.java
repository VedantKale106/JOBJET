package com.example.booker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booker.Freelancer;
import com.example.booker.R;

import java.util.ArrayList;

public class FreeAdapter extends RecyclerView.Adapter<FreeAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<Freelancer> freelancers;
    private Context context;

    // constructor
    public FreeAdapter(ArrayList<Freelancer> freeArrayList, Context context) {
        this.freelancers = freeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.freelancerv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        Freelancer modal = freelancers.get(position);
        holder.courseNameTV.setText(modal.getName());
        holder.courseDescTV.setText(modal.getSkills());
        holder.courseDurationTV.setText(modal.getLocation());
        holder.courseTracksTV.setText(modal.getRate());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return freelancers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.NAME);
            courseDescTV = itemView.findViewById(R.id.SKILL);
            courseDurationTV = itemView.findViewById(R.id.LOCATION);
            courseTracksTV = itemView.findViewById(R.id.RATE);
        }
    }
}
