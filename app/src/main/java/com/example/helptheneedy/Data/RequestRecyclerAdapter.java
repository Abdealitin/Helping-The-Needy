package com.example.helptheneedy.Data;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helptheneedy.Model.Request;
import com.example.helptheneedy.R;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

public class RequestRecyclerAdapter extends RecyclerView.Adapter<RequestRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Request> requestList;

    public RequestRecyclerAdapter(Context context, List<Request> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Request request= requestList.get(position);
        String imageUrl = null;

        holder.title.setText(request.getTitle());
        holder.desc.setText(request.getDesc());
        holder.timestamp.setText(request.getTimestamp());

        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(request.getTimestamp())).getTime());

        holder.timestamp.setText(formattedDate);
        imageUrl = request.getImage();
        Picasso.with(context).load(imageUrl).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public TextView timestamp;
        public ImageView image;
        String userid;

        public ViewHolder(@NonNull View view, Context ctx) {
            super(view);

            context = ctx;

            title = (TextView) view.findViewById(R.id.requestTitle);
            desc = (TextView) view.findViewById(R.id.requestText);
            image = (ImageView) view.findViewById(R.id.requestImage);
            timestamp = (TextView) view.findViewById(R.id.timeStamp);

            userid = null;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Next Activity Content
                }
            });
        }
    }
}
