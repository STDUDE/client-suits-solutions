package edu.bsuir.ss.utils;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Antony on 04.12.2016.
 */
public class DialogStateUtil {
    private static BroadcastReceiver receiver;
    private static DialogInterface.OnClickListener listener;
    public static final String SHOW_DIALOG = "showNoInternetDialog";
    public static final String RETRY = "retry";

    public static void unregisterReceiver(Context context) {
        try {
            if (receiver != null) {
                context.unregisterReceiver(receiver);
                receiver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            receiver = null;
        }
    }

    private static AlertDialog mAlertDialog;

    public static AlertDialog showDialog(Context activityContext, String title, String message, boolean cancelable,
                                         DialogInterface.OnClickListener listenerPositiveButton, DialogInterface.OnClickListener listenerNegativeButton) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(activityContext);
        if (title != null) mBuilder.setTitle(title);
        if (message != null) mBuilder.setMessage(message);
        mBuilder.setCancelable(cancelable);
        if (listenerPositiveButton != null)
            mBuilder.setPositiveButton("Retry", listenerPositiveButton);
        if (listenerNegativeButton != null)
            mBuilder.setNegativeButton("Cancel", listenerNegativeButton);
        mAlertDialog = mBuilder.create();

        try {
            mAlertDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mAlertDialog;
    }

    public static AlertDialog showOkDialog(Context activityContext, String title, String message, boolean cancelable) {
        mAlertDialog = showDialog(activityContext, title, message, cancelable, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAlertDialog.dismiss();
            }
        }, null);
        mAlertDialog.show();
        return mAlertDialog;
    }

    public static AlertDialog showOkDialog(Context activityContext, String title, String message, boolean cancelable, DialogInterface.OnClickListener listener) {
        mAlertDialog = showDialog(activityContext, title, message, cancelable, listener, listener);
        mAlertDialog.show();
        return mAlertDialog;
    }}
