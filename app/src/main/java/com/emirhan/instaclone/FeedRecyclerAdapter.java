package com.emirhan.instaclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder> {
    private ArrayList<String> emailFromDb;
    private ArrayList<String> commentFromDb;
    private ArrayList<String> urlFromDb;

    public FeedRecyclerAdapter(ArrayList<String> emailFromDb, ArrayList<String> commentFromDb, ArrayList<String> urlFromDb) {
        this.emailFromDb = emailFromDb;
        this.commentFromDb = commentFromDb;
        this.urlFromDb = urlFromDb;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_row, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

            holder.email.setText(emailFromDb.get(position));
            holder.comment.setText(commentFromDb.get(position));
        Picasso.get().load(urlFromDb.get(position)).into(holder.imageView);


    }

    @Override
    public int getItemCount() {

        return emailFromDb.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView email;
        TextView comment;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewR);
            email = itemView.findViewById(R.id.userNameR);
            comment = itemView.findViewById(R.id.commentR);
        }
    }
}
