package com.example.honza.templates;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.honza.templates.Fragments.ArticleFragment;
import com.example.honza.templates.Fragments.DatabaseFragment;
import com.example.honza.templates.Fragments.ErrorPageFragment;
import com.example.honza.templates.Fragments.FilesFragment;
import com.example.honza.templates.Fragments.LayoutFragment;
import com.example.honza.templates.Fragments.LoginFragment;
import com.example.honza.templates.Fragments.OtherFragment;
import com.example.honza.templates.Fragments.ShowErrorFragment;
import com.example.honza.templates.Fragments.TabsFragment;
import com.wefika.flowlayout.FlowLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int activeFragmentId;
    private Menu mmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.setDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        if (savedInstanceState != null)
        {
            activeFragmentId = savedInstanceState.getInt("activeFragmentId");
            Menu menu = null;
            if (navigationView != null) {
                menu = navigationView.getMenu();
            }
            MenuItem menuItem = null;
            if (menu != null) {
                menuItem = menu.findItem(activeFragmentId);
            }
            onNavigationItemSelected(menuItem);


        }
        else
        {
            if (navigationView != null) {
                onNavigationItemSelected(navigationView.getMenu().getItem(0));
            }
            if (navigationView != null) {
                navigationView.getMenu().getItem(0).setChecked(true);
            }
            activeFragmentId = R.id.nav_login;
        }


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        if(menu!=null) {
            if(menu.findItem(R.id.action_layout)!=null)
            menu.findItem(R.id.action_layout).setVisible(false);
            mmenu = menu;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_help)
        {
            Intent slideactivity = new Intent(this, HelpActivity.class);
            Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
            startActivity(slideactivity, bndlanimation);
        }
        else if(id == R.id.action_settings)
        {
            Intent slideactivity = new Intent(this, SettingsActivity.class);
            Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
            startActivity(slideactivity, bndlanimation);
        }
        else if(id == R.id.action_about_app)
        {
            Intent slideactivity = new Intent(this, AboutAppActivity.class);
            Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
            startActivity(slideactivity, bndlanimation);
        }
        else if(id == R.id.action_layout)
        {
            DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
            int Width;
            MenuItem menuItem = mmenu.findItem(R.id.action_layout);
            if(menuItem.getTitle().equals("layout1"))
            {
                Width = displayMetrics.widthPixels/3;
                menuItem.setIcon(R.drawable.ic_view_compact_white_24dp);
                menuItem.setTitle("layout2");
            }
            else
            {
                Width = displayMetrics.widthPixels/2;
                menuItem.setIcon(R.drawable.ic_view_comfy_white_24dp);
                menuItem.setTitle("layout1");
            }
            int Height = (Width/16)*9;

            FlowLayout ll = (FlowLayout)findViewById(R.id.layout_root);
            int childcount = ll.getChildCount();
            for (int i=0; i < childcount; i++){
                View view = ll.getChildAt(i);
                view.setLayoutParams(new FlowLayout.LayoutParams(Width, Height));

            }

        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==activeFragmentId)
        {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer != null) {
                drawer.closeDrawer(GravityCompat.START);
            }
            return true;
        }


        activeFragmentId = id;

        String title =  getString(R.string.app_name);

        Fragment fragment = null;

        if (id == R.id.nav_login)
        {
            fragment = new LoginFragment();
            title = getString(R.string.title_login);
        }
        else if (id == R.id.nav_tabs)
        {
            fragment = new TabsFragment();
            title = getString(R.string.title_tabs);
        }
        else if (id == R.id.nav_error)
        {
            fragment = new ErrorPageFragment();
            title = getString(R.string.title_error);
        }
        else if (id == R.id.nav_article)
        {
            fragment = new ArticleFragment();
            title = getString(R.string.title_article);
        }
        else if (id == R.id.nav_database)
        {
            fragment = new DatabaseFragment();
            title = getString(R.string.title_database);
        }
        else if (id == R.id.nav_files)
        {
            fragment = new FilesFragment();
            title = getString(R.string.title_files);
        }
        else if (id == R.id.nav_layout)
        {
            fragment = new LayoutFragment();
            title = getString(R.string.title_layout);
        }
        else if (id == R.id.nav_show_error)
        {
            fragment = new ShowErrorFragment();
            title = getString(R.string.title_show_error);
        }
        else if (id == R.id.nav_other)
        {
            fragment = new OtherFragment();
            title = getString(R.string.title_other);
        }

        if(fragment!=null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
            ft.replace(R.id.container, fragment);
            ft.commit();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer != null) {
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }


    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("activeFragmentId", activeFragmentId);
    }
}
