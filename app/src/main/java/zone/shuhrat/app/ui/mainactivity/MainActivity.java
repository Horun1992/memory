package zone.shuhrat.app.ui.mainactivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import zone.shuhrat.app.R;
import zone.shuhrat.app.ui.baseviews.BaseActivity;
import zone.shuhrat.app.ui.searchfragment.NavCantrollerCallBack;
import zone.shuhrat.app.ui.ViewModelActivity;

public class MainActivity extends BaseActivity implements NavCantrollerCallBack {

    NavController navController;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up Nav Bar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        setupBottomNavMenu(navController);

        ViewModelActivity modelActivity = ViewModelProviders.of(this).get(ViewModelActivity.class);

        modelActivity.progressBar.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    private void setupBottomNavMenu(NavController navController) {
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavigationUI.onNavDestinationSelected(item, navController);
        navController.navigate(item.getItemId());
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        switch (navController.getCurrentDestination().getId()) {
            case R.id.searchFragment:
                if (backPressedTime + 2000 > System.currentTimeMillis()) {
                    super.onBackPressed();
                    return;
                } else {
                    showMessage(this.getString(R.string.type_twice_to_exit));
                }
                backPressedTime = System.currentTimeMillis();
                break;
            case R.id.photoFragment:
                goToFragment(R.id.searchFragment);
                break;
        }


    }

    @Override
    public void goToFragment(int fragmentId) {
        navController.navigate(fragmentId);
    }
}
