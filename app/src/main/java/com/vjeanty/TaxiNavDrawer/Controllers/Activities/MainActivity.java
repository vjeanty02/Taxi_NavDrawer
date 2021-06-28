package com.vjeanty.TaxiNavDrawer.Controllers.Activities;

import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;

import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentHelp;
import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentHome;
import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentLogout;
import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentNotifications;
import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentPayment;
import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentHistory;
import com.vjeanty.TaxiNavDrawer.Controllers.Fragments.FragmentSettings;
import com.vjeanty.TaxiNavDrawer.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //FOR DESIGN
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    //FOR FRAGMENTS
    private Fragment fragmentHome;
    private Fragment fragmentHistory;
    private Fragment fragmentNotifications;
    private Fragment fragmentPayment;
    private Fragment fragmentSettings;
    private Fragment fragmentHelp;
    private Fragment fragmentLogout;

    //FOR DATA
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_PAYMENT = 1;
    private static final int FRAGMENT_HISTORY = 2;
    private static final int FRAGMENT_NOTIFICATIONS = 3;
    private static final int FRAGMENT_SETTINGS = 4;
    private static final int FRAGMENT_HELP = 5;
    private static final int FRAGMENT_LOGOUT = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configure all views
        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();

        // Show First Fragment
        this.showFirstFragment();
    }

    @Override
    public void onBackPressed() {
        // Handle back click to close menu
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        // Show fragment after user clicked on a menu item
        switch (id){

            case R.id.activity_main_drawer_notifications:
                this.showFragment(FRAGMENT_NOTIFICATIONS);
                break;
            case R.id.activity_main_drawer_settings:
                this.showFragment(FRAGMENT_SETTINGS);
                break;
            case R.id.activity_main_drawer_logout:
                this.showFragment(FRAGMENT_LOGOUT);
                break;
            case R.id.activity_main_drawer_home:
                this.showFragment(FRAGMENT_HOME);
                break;
            case R.id.activity_main_drawer_history:
                this.showFragment(FRAGMENT_HISTORY);
                break;
            case R.id.activity_main_drawer_payment:
                this.showFragment(FRAGMENT_PAYMENT);
                break;
            case R.id.activity_main_drawer_help:
                this.showFragment(FRAGMENT_HELP);
                break;
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    // ---------------------
    // CONFIGURATION
    // ---------------------

    // Configure Toolbar
    private void configureToolBar(){
        this.toolbar = findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
    }

    // Configure Drawer Layout
    private void configureDrawerLayout(){
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    // Configure NavigationView
    private void configureNavigationView(){
        this.navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // ---------------------
    // FRAGMENTS
    // ---------------------

    // Show first fragment when activity is created
    private void showFirstFragment(){
        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);
        if (visibleFragment == null){
            // Show News Fragment
            this.showFragment(FRAGMENT_HOME);
            // Mark as selected the menu item corresponding to FragmentHelp
            this.navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    // Show fragment according an Identifier

    private void showFragment(int fragmentIdentifier){
        switch (fragmentIdentifier){
            case FRAGMENT_HOME :
                this.showHomeFragment();
                break;
            case FRAGMENT_PAYMENT:
                this.showPaymentFragment();
                break;

            case FRAGMENT_HISTORY:
                this.showHistoryFragment();
                break;
            case FRAGMENT_NOTIFICATIONS:
                this.showNotificationsFragment();
                break;
            case FRAGMENT_SETTINGS:
                this.showSettingsFragment();
                break;
            case FRAGMENT_HELP:
                this.showHelpFragment();
                break;
            case FRAGMENT_LOGOUT:
                this.showLogoutFragment();
                break;
            default:
                break;
        }
    }

    // ---

    // Create each fragment page and show it

    private void showHomeFragment(){
        if (this.fragmentHome == null) this.fragmentHome = FragmentHome.newInstance();
        this.startTransactionFragment(this.fragmentHome);
    }

    private void showPaymentFragment(){
        if (this.fragmentPayment == null) this.fragmentPayment = FragmentPayment.newInstance();
        this.startTransactionFragment(this.fragmentPayment);
    }

    private void showHistoryFragment(){
        if (this.fragmentHistory == null) this.fragmentHistory = FragmentHistory.newInstance();
        this.startTransactionFragment(this.fragmentHistory);
    }
    private void showNotificationsFragment(){
        if (this.fragmentNotifications == null) this.fragmentNotifications = FragmentNotifications.newInstance();
        this.startTransactionFragment(this.fragmentNotifications);
    }

    private void showSettingsFragment(){
        if (this.fragmentSettings == null) this.fragmentSettings = FragmentSettings.newInstance();
        this.startTransactionFragment(this.fragmentSettings);
    }

    private void showHelpFragment(){
        if (this.fragmentHelp == null) this.fragmentHelp = FragmentHelp.newInstance();
        this.startTransactionFragment(this.fragmentHelp);
    }
    private void showLogoutFragment(){
        if (this.fragmentLogout == null) this.fragmentLogout = FragmentLogout.newInstance();
        this.startTransactionFragment(this.fragmentLogout);
    }

    // ---

    // Generic method that will replace and show a fragment inside the MainActivity Frame Layout
    private void startTransactionFragment(Fragment fragment){
        if (!fragment.isVisible()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_frame_layout, fragment).commit();
        }
    }
}