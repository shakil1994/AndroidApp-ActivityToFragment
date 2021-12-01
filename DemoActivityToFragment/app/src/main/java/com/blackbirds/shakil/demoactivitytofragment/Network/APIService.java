package com.blackbirds.shakil.demoactivitytofragment.Network;

import com.blackbirds.shakil.demoactivitytofragment.Model.PhotosModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("photos")
    Observable<List<PhotosModel>> getAllPhotos();
}
