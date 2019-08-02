package zone.shuhrat.app.model.repository.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zone.shuhrat.app.model.SearchModel;

public interface NetworkService {
    @GET("search/photos")
    Single<SearchModel> getPhotosByUrl(@Query("client_id") String client_id,
                                       @Query("query") String query,
                                       @Query("per_page") String per_page,
                                       @Query("page") int page);

    @GET("photos/random")
    Single<Object> getRandomPhoto(@Query("client_id") String client_id);

}
