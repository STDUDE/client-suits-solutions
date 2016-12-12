package edu.bsuir.ss.api;

import java.util.HashMap;

import edu.bsuir.ss.api.login.BaseResponse;
import edu.bsuir.ss.api.login.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Antony on 04.12.2016.
 */
public interface RestClient {
//    @POST(NetworkData.LOGIN)
//    Call<BaseResponse<LoginResponse>> login(@Query("user_name") String user_name, @Query("password") String password);
//
//    @POST(NetworkData.LOGOUT)
//    Call<BaseResponse<Object>> logout(@Query("user_id") int user, @Query("token") String token);

      @POST(NetworkData.LOGIN)
      Call<BaseResponse<LoginResponse>> login(@Body HashMap<String, Object> body);

//    @GET(NetworkData.GET_TRACKING_TIMES)
//    Call<LoginRequest.BaseResponse<List<TrackingModel>>> getTracks(@Query("user_id") int user,
//                                                      @Query("token") String token,
//                                                      @Query("date") String date);
//
//    @GET(NetworkData.TRACK_UPDATE)
//    Call<LoginRequest.BaseResponse<TrackingModel>> updateTrack(@Query("user_id") int user,
//                                                  @Query("token") String token,
//                                                  @Query("project_id") int project,
//                                                  @Query("date") String date,
//                                                  @Query("description") String description,
//                                                  @Query("time") int time,
//                                                  @Query("track_id") String track);
}
