package zone.shuhrat.app.ui.photofragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import zone.shuhrat.app.R;
import zone.shuhrat.app.model.SearchModel;
import zone.shuhrat.app.ui.baseviews.BaseFragment;
import zone.shuhrat.app.utils.AppConstants;
import zone.shuhrat.app.ui.ViewModelActivity;

public class PhotoFragment extends BaseFragment {

    private Adapter adapter;
    private ViewModelActivity modelActivity;

    private TextView currentPage, totalPage;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_photo, container, false);

        //set listener for pagers
        view.findViewById(R.id.photo_fragment_nextBtn).setOnClickListener(pagerListener);
        view.findViewById(R.id.photo_fragment_prevBtn).setOnClickListener(pagerListener);;

        currentPage = view.findViewById(R.id.photo_fragment_currentPage);
        totalPage = view.findViewById(R.id.photo_fragment_totalPage);


        RecyclerView recyclerView = view.findViewById(R.id.photo_fragment_rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter();

        recyclerView.setAdapter(adapter);


        //Check if Activity not null create ViewModel and listen the LiveData
        if (getActivity() != null) {
            modelActivity = ViewModelProviders.of(getActivity()).get(ViewModelActivity.class);
            modelActivity.getObject().observe(this, new Observer<SearchModel>() {
                @Override
                public void onChanged(SearchModel searchModel) {
                    adapter.setData(searchModel);
                    totalPage.setText(String.valueOf(searchModel.getTotalPages()));
                }
            });
        }

        // Inflate the layout for this fragment
        return view;
    }


    //Pager button clickListener
    private View.OnClickListener pagerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Check if string has any text then add it to to static varibale (Current opened fragment)
            if(!currentPage.getText().toString().equals("")){
                AppConstants.CURRENT_PAGE = Integer.valueOf(currentPage.getText().toString());
            }

            //check if current page -1 are more than zero let me to click back and if +1 let me to click next
            switch (v.getId()) {
                case R.id.photo_fragment_prevBtn:
                    if (AppConstants.CURRENT_PAGE - 1 > 0) {
                        modelActivity.getData(AppConstants.CURRENT_PAGE - 1, AppConstants.QUERY_REQUEST_TEXT);
                        currentPage.setText(String.valueOf(AppConstants.CURRENT_PAGE - 1));
                    }
                    break;
                case R.id.photo_fragment_nextBtn:
                    if (AppConstants.CURRENT_PAGE + 1 <= Integer.valueOf(totalPage.getText().toString())) {
                        modelActivity.getData(AppConstants.CURRENT_PAGE + 1, AppConstants.QUERY_REQUEST_TEXT);
                        currentPage.setText(String.valueOf(AppConstants.CURRENT_PAGE + 1));
                    }
                    break;
            }
        }
    };


}
