package zone.shuhrat.app.ui.baseviews;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {


    private BaseActivity baseActivity;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        baseActivity = (BaseActivity) getActivity();
        super.onActivityCreated(savedInstanceState);
    }

    public BaseActivity getBaseActivityMethods(){
        if(baseActivity!=null) return baseActivity; else return (BaseActivity) getActivity();
    }
}
