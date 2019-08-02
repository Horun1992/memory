package zone.shuhrat.app.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.internal.LinkedTreeMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import zone.shuhrat.app.App;
import zone.shuhrat.app.model.SearchModel;
import zone.shuhrat.app.model.repository.network.NetworkService;
import zone.shuhrat.app.utils.AppConstants;

public class ViewModelActivity extends AndroidViewModel {

    private App app;

    //If we will call more than one dispasable we must add them in Composite and dispose all when we need it
    private final CompositeDisposable disposables = new CompositeDisposable();

    //Live data for PhotoFragment
    private MutableLiveData<SearchModel> searchObject = new MutableLiveData<>();

    //LiveData for progressBar if true progressBar will show
    public MutableLiveData<Boolean> progressBar = new MutableLiveData<>();

    public MutableLiveData<String> liveDataForSearchFragmentTitleImage = new MutableLiveData<>();

    //Getter for SearchModel pojo
    public LiveData<SearchModel> getObject() {
        return searchObject;
    }

    //Constructor where we take App
    public ViewModelActivity(@NonNull Application application) {
        super(application);
        this.app = (App) application;
    }


    //get random Image for SearchFragment
    public void getRandomFragment() {
        Retrofit retrofit = app.getApplicationComponent().getRetrofit();
        if (retrofit != null) {
            disposables.add(retrofit.create(NetworkService.class).getRandomPhoto(AppConstants.API_KEY)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Object>() {
                        @Override
                        public void accept(Object urls) throws Exception {

                            LinkedTreeMap url = (LinkedTreeMap) ((LinkedTreeMap) urls).get("urls");
                            String photoLink = (String) url.get("regular");
                            liveDataForSearchFragmentTitleImage.postValue(photoLink);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                        }
                    }));
        }
    }


    //We call this method from Search Fragment, when we get Data the live data in PhotoFragment will refresh
    public void getData(int page, String query) {
        progressBar.setValue(true);//turn on progress bar when we work
        Retrofit retrofit = app.getApplicationComponent().getRetrofit();
        if (retrofit != null) {
            disposables.add(retrofit.create(NetworkService.class).getPhotosByUrl(AppConstants.API_KEY, query, AppConstants.PER_PAGE, page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<SearchModel>() {
                        @Override
                        public void accept(SearchModel searchModel) throws Exception {
                            progressBar.postValue(false);
                            searchObject.postValue(searchModel);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            progressBar.postValue(false);
                        }
                    }));
        }
    }


    //When Activity will die the ViewModel will kill all dispasables
    @Override
    protected void onCleared() {
        disposables.clear();
        disposables.dispose();
        super.onCleared();
    }
}
