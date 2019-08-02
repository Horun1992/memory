package zone.shuhrat.app.di.component;


import dagger.Component;
import retrofit2.Retrofit;
import zone.shuhrat.app.di.AppComponentScope;
import zone.shuhrat.app.di.module.RetrofitModule;


@AppComponentScope
@Component(modules = {RetrofitModule.class})
public interface AppCompanent {

    Retrofit getRetrofit();
}
