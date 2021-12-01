package com.blackbirds.shakil.demoactivitytofragment.Common;

import com.blackbirds.shakil.demoactivitytofragment.Model.PhotosModel;
import com.blackbirds.shakil.demoactivitytofragment.Network.APIService;
import com.blackbirds.shakil.demoactivitytofragment.Network.RetrofitClient;

public class Common {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static PhotosModel categorySelected;

    public static APIService getMovies(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
