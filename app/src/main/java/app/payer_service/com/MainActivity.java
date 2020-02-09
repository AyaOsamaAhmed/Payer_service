package app.payer_service.com;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import im.delight.android.webview.AdvancedWebView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar ;
    DrawerLayout drawer ;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    AdvancedWebView     advancedwebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_connect_admin1);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar_one);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        advancedwebview = (AdvancedWebView) findViewById(R.id.webView);

        advancedwebview.loadUrl("http://payerservice.com");
        advancedwebview.getSettings().setLoadWithOverviewMode(true);
        advancedwebview.zoomOut();
        advancedwebview.getSettings().setUseWideViewPort(true);
    }

    @Override
    public void onBackPressed() {

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            alartExit();
        }
        alartExit();
    }
    public void alartExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.this.finish();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                this.advancedwebview.loadUrl("http://payerservice.com");
                break;
            case R.id.about:
                this.advancedwebview.loadUrl("http://payerservice.com/about.aspx");
                break;
            case R.id.proclean:
                this.advancedwebview.loadUrl("http://payerservice.com/clean.aspx");
                break;
            case R.id.proservice:
                this.advancedwebview.loadUrl("http://payerservice.com/program.aspx");
                break;
            case R.id.service:
                this.advancedwebview.loadUrl("http://payerservice.com/services.aspx");
                break;
            case R.id.gua:
                this.advancedwebview.loadUrl("http://payerservice.com/Security.aspx");
                break;
            case R.id.ads:
                this.advancedwebview.loadUrl("http://payerservice.com/deal.aspx");
                break;
            case R.id.library:
                this.advancedwebview.loadUrl("http://payerservice.com/libarary.aspx");
                break;
            case R.id.contact:
                this.advancedwebview.loadUrl("http://payerservice.com/contact_us.aspx");
                break;


            default:
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
