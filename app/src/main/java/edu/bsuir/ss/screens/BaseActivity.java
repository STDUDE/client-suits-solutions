package edu.bsuir.ss.screens;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import edu.bsuir.ss.R;
import edu.bsuir.ss.api.RestClient;
import edu.bsuir.ss.api.RestFactory;
import retrofit2.Call;


public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private View background;
    private boolean backgroundApplyed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpConfig();
    }



    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    private void setUpConfig() {
        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = (float) 1; //0.85 small size, 1 normal size, 1,15 big etc

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        metrics.scaledDensity = configuration.fontScale * metrics.density;
        getBaseContext().getResources().updateConfiguration(configuration, metrics);
    }

    public void showProgressDialog() {

        if (progressDialog == null)
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (!BaseActivity.this.isFinishing()) {
                            progressDialog = ProgressDialog.show(BaseActivity.this, "", "Loading...", true, false);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public void cancelProgressDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (progressDialog != null) {
                        progressDialog.cancel();
                        progressDialog = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void simpleReplaceFragment(Fragment fragment, boolean addToBackStack) {

        String backStateName = fragment.getClass().getSimpleName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(android.R.id.tabcontent, fragment, backStateName);
        if (addToBackStack)
            ft.addToBackStack(backStateName);
        ft.commitAllowingStateLoss();

    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        String backStateName = fragment.getClass().getSimpleName();

        FragmentManager manager = getSupportFragmentManager();

        boolean fragmentPopped = false;
        try {
            fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_content, fragment, backStateName);
            if(addToBackStack)
                ft.addToBackStack(backStateName);
            ft.commitAllowingStateLoss();
        }
    }

    public void showErrorDialog(String title, String message, DialogInterface.OnClickListener listener){
        AlertDialog dialog = new  AlertDialog.Builder(this)
                .setMessage(message)
                .setTitle(title)
                .setCancelable(true)
                .setNeutralButton("ok", listener)
                .create();

        dialog.show();
    }

    public void showToastMessage(String message) {
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
    }

    public void showToastMessage(int message) {
        Toast.makeText(this, message , Toast.LENGTH_SHORT).show();
    }

    protected abstract void initViews();

    public RestClient getClient(){
        return RestFactory.getInstance().getClient();
    }

    protected <T> void enqueue(final Call<T> call, final RestFactory.CallbackResponse<T> result){
        RestFactory.enqueue(call, result, this);
    }

}
