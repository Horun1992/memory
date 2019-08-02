package zone.shuhrat.app.ui.singlephotoaactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import zone.shuhrat.app.R;
import zone.shuhrat.app.ui.baseviews.BaseActivity;

public class SinglePhotoActivity extends BaseActivity {

    private String photoLink = null, name, updatedTime, description, photoAvatar;
    private ImageView mainPhoto, userPhoto;
    private TextView userName, photoDescription, photoTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_photo);
        showLoading();
        Intent intent = getIntent();

        photoLink = intent.getStringExtra("photoLink");
        photoAvatar = intent.getStringExtra("photoAvatar");
        name = intent.getStringExtra("name");
        updatedTime = intent.getStringExtra("updatedTime");
        description = intent.getStringExtra("description");

        mainPhoto = findViewById(R.id.single_photo_activity_imageView);
        userPhoto = findViewById(R.id.single_photo_activity_userPhoto);
        userName = findViewById(R.id.single_photo_activity_userName);
        photoDescription = findViewById(R.id.single_photo_activity_description);
        photoTime = findViewById(R.id.single_photo_activity_updatedTime);

        fillUserInfo();
    }

    //Save  links after rotate screen etc.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (photoLink != null) {
            outState.putString("photoLink", photoLink);
            outState.putString("photoAvatar", photoAvatar);
            outState.putString("name", name);
            outState.putString("updatedTime", updatedTime);
            outState.putString("description", description);
        }
        super.onSaveInstanceState(outState);
    }


    //Restore  links after rotate screen etc.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            photoLink = savedInstanceState.getString("photoLink");
            photoAvatar = savedInstanceState.getString("photoAvatar");
            name = savedInstanceState.getString("name");
            updatedTime = savedInstanceState.getString("updatedTime");
            description = savedInstanceState.getString("description");
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    void fillUserInfo() {
        if (photoLink != null) {
            Glide.with(this).load(photoLink).centerCrop().into(mainPhoto);
            Glide.with(this).load(photoAvatar).centerCrop().into(userPhoto);
            userName.setText(name);
            photoDescription.setText(description);
            if (updatedTime != null) {
                photoTime.setText(updatedTime.substring(0, updatedTime.indexOf("T")));
            }
            hideLoading();
        }
    }
}
