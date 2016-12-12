package edu.bsuir.ss.api;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import edu.bsuir.ss.utils.DialogStateUtil;
import edu.bsuir.ss.utils.UserStateUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Antony on 04.12.2016.
 */
public class RestFactory {
    private static RestFactory instance;
    private static Context contextApp;

    private RestFactory() {
    }

    public synchronized static RestFactory getInstance() {
        if (instance == null) instance = new RestFactory();
        return instance;
    }

    public RestClient getClient() {
        OkHttpClient client = getOkHttpClient();
        Retrofit retrofit = getRetrofit(client);
        return retrofit.create(RestClient.class);
    }

    private OkHttpClient getOkHttpClientDefault() {
        OkHttpClient client = getOkHttpClient();
        return client;
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client = client.newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());

            }}).build();
        return client;
    }


    private Retrofit getRetrofit(OkHttpClient client) {

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkData.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    private Retrofit getRetrofit(OkHttpClient client, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


    private Retrofit getRetrofitWithoutBaseUrl(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(NetworkData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


    public static <T> void enqueue(final Call<T> call, final CallbackResponse<T> result, final Context context) {

        contextApp = context;

        if (!UserStateUtil.isOnline(context)) {
            DialogStateUtil.showOkDialog(context, "", "", false, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) dialogInterface.dismiss();
                    if (i == Dialog.BUTTON_NEGATIVE) {
                        dialogInterface.dismiss();
                        call.cancel();
                        result.result(null);
                        return;
                    }
                    enqueue(call, result, context);
                }
            });
            return;
        }

        result.showProgressDialogCallback();

        call.enqueue(new Callback<T>() {

            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                Log.i(RestFactory.class.getSimpleName(), response.raw().code() + " / " + response.raw().request().method() + " / " + response.raw().toString());
                result.result(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                t.printStackTrace();
                result.result(null);
            }
        });
    }


    public interface CallbackResponse<T> {
        void result(T data);

        void showProgressDialogCallback();
    }
}
