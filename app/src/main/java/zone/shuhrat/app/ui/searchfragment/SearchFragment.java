package zone.shuhrat.app.ui.searchfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import zone.shuhrat.app.R;
import zone.shuhrat.app.ui.baseviews.BaseFragment;
import zone.shuhrat.app.ui.ViewModelActivity;
import static zone.shuhrat.app.utils.AppConstants.CURRENT_PAGE;
import static zone.shuhrat.app.utils.AppConstants.QUERY_REQUEST_TEXT;


public class SearchFragment extends BaseFragment {

    private ViewModelActivity modelActivity;
    private NavCantrollerCallBack navControllerCallBack;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        navControllerCallBack = (NavCantrollerCallBack) getActivity();
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        if (getActivity() != null) {
            modelActivity = ViewModelProviders.of(getActivity()).get(ViewModelActivity.class);
            //Get random image from api
            modelActivity.getRandomFragment();
            //if i get image success set it ti imageView
            modelActivity.liveDataForSearchFragmentTitleImage.observe(this, new Observer<String>() {
                @Override
                public void onChanged(String urls) {
                    Glide.with(SearchFragment.this).load(urls).centerCrop()
                            .into((ImageView) view.findViewById(R.id.search_fragment_random_photo));
                }
            });
        }

        Button btnFind = view.findViewById(R.id.search_fragment_searchBtn);
        final EditText searchEditText = view.findViewById(R.id.search_fragment_et);
        searchEditText.setText(QUERY_REQUEST_TEXT);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (modelActivity != null && getBaseActivityMethods().isNetworkConnected()) {
                    getBaseActivityMethods().hideKeyboard();
                    QUERY_REQUEST_TEXT = searchEditText.getText().toString();
                    modelActivity.getData(CURRENT_PAGE, QUERY_REQUEST_TEXT);

                    if (navControllerCallBack != null) {
                        navControllerCallBack.goToFragment(R.id.photoFragment);
                    }
                }else {
                    getBaseActivityMethods().onError(null);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
