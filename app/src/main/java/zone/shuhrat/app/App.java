package zone.shuhrat.app;

import android.app.Application;
import zone.shuhrat.app.di.component.AppCompanent;
import zone.shuhrat.app.di.component.DaggerAppCompanent;

public class App extends Application {


    private AppCompanent appCompanent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (appCompanent == null) {
            appCompanent = DaggerAppCompanent.create();
        }

    }

    public AppCompanent getApplicationComponent() {
        return appCompanent;
    }
}
