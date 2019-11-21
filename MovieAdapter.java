package com.dicoding.picodiploma.submission_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Movie movie = (Movie) getItem(i);
        ImageView Photo = itemView.findViewById(R.id.gambarMovie);
        viewHolder.bind(movie);
        Glide.with(itemView)
                .load(movie.getPhoto())
                .into(Photo);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtJudul, txtDescription, txtTglMovie, txtCrewMovie,txtCrewDetail;
        private ImageView imgPhoto;

        ViewHolder (View view){
            txtJudul = view.findViewById(R.id.txt_judul);
            txtDescription = view.findViewById(R.id.txt_description);
            txtTglMovie = view.findViewById(R.id.txt_tgl);
            txtCrewMovie = view.findViewById(R.id.crew_detail);
            txtCrewDetail = view.findViewById(R.id.position_detail);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        public void bind(Movie movie){
            txtJudul.setText(movie.getJudul());
            txtDescription.setText(movie.getDescription());
            txtTglMovie.setText(movie.getTglMovie());
            txtCrewMovie.setText(movie.getDescMovie());
            txtCrewDetail.setText(movie.getCrewDetailMovie());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
