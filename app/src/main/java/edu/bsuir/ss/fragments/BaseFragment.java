package edu.bsuir.ss.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.View;

import edu.bsuir.ss.screens.SlidingMenuActivity;

/**
 * Created by Antony on 01.12.2016.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        //getSlidingMenuActivity().getToolbarTextView().setText(getTitle());
    }

    protected String getTitle() {
        return "";
    }

    protected SlidingMenuActivity getSlidingMenuActivity() {
        return (SlidingMenuActivity) getActivity();
    }

    /**
     * @ Back to main thread
     **/
    protected void runOnUIThread(Runnable runnable) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(runnable);
    }


    protected void runPostDelay(Runnable runnable , int delay){
        Handler handler = new Handler();
        handler.postDelayed(runnable, delay);
    }

    protected void backPressed() {
        getSlidingMenuActivity().onBackPressed();
    }


    protected void showProgressDialog() {
        SlidingMenuActivity mainActivity = getSlidingMenuActivity();
        if (mainActivity != null) {
            mainActivity.showProgressDialog();
        }
    }

    protected void showToastMessage(String message) {
        getSlidingMenuActivity().showToastMessage(message);
    }

    protected void showToastMessage(int stringMessage) {
        getSlidingMenuActivity().showToastMessage(stringMessage);
    }

    protected void cancelProgressDialog() {
        SlidingMenuActivity mainActivity = getSlidingMenuActivity();
        if (mainActivity != null) {
            mainActivity.cancelProgressDialog();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    protected abstract void initViews(View view);


    protected void showErrorDialog(String title, String message, DialogInterface.OnClickListener listener){
        getSlidingMenuActivity().showErrorDialog(title, message, listener);
    }

    protected void simpleReplaceFragment(Fragment fragment , boolean addToBackStack){
        getSlidingMenuActivity().simpleReplaceFragment(fragment, addToBackStack);
    }

    protected void replaceFragment(Fragment fragment , boolean addToBackStack){
        getSlidingMenuActivity().replaceFragment(fragment , addToBackStack);
    }

    /*public RestClient getClient(){
        return RestFactory.getInstance().getClient();
    }*/

   /* protected <T> void enqueue(final Call<T> call, final RestFactory.CallbackResponse<T> result){
        RestFactory.enqueue(call, result, getContext());
    }*/
}
