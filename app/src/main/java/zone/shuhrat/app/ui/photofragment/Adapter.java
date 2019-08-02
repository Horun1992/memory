package zone.shuhrat.app.ui.photofragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import zone.shuhrat.app.R;
import zone.shuhrat.app.model.SearchModel;
import zone.shuhrat.app.ui.singlephotoaactivity.SinglePhotoActivity;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //POGO object
    private SearchModel searchModel = new SearchModel();

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_view_single_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final SearchModel.Result item = searchModel.getResults().get(position);

        //set main photo
        Glide.with(context).load(item.getUrls().getThumb())
                .centerCrop()
                .into(holder.mainPhoto);

        //set user Avatar
        Glide.with(context).load(item.getUser().getProfileImage().getSmall())
                .centerCrop()
                .into(holder.userPhoto);

        //set photo Title
        holder.photoTitle.setText(item.getDescription());

        //set User Name
        holder.userName.setText(item.getUser().getName());

        //Open sunActivity with some data
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, SinglePhotoActivity.class)
                        .putExtra("photoLink", item.getUrls().getRegular())
                        .putExtra("name", item.getUser().getName())
                        .putExtra("photoAvatar", item.getUser().getProfileImage().getSmall())
                        .putExtra("description", item.getDescription())
                        .putExtra("updatedTime", item.getUpdatedAt())
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        try {
            return searchModel.getResults().size();
        } catch (Exception ignored) {
            return 0;
        }
    }

    void setData(SearchModel searchModel) {
        this.searchModel = searchModel;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mainPhoto;
        CircleImageView userPhoto;
        TextView userName, photoTitle;
        CardView item;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainPhoto = itemView.findViewById(R.id.recycle_view_single_item_photo);
            userPhoto = itemView.findViewById(R.id.recycle_view_single_item_userPhoto);
            userName = itemView.findViewById(R.id.recycle_view_single_item_userName);
            photoTitle = itemView.findViewById(R.id.recycle_view_single_item_photoTitle);
            item = itemView.findViewById(R.id.recycle_view_single_item_cardView);
        }
    }
}
