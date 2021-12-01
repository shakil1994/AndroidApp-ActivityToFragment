package com.blackbirds.shakil.demoactivitytofragment.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.blackbirds.shakil.demoactivitytofragment.Common.Common;
import com.blackbirds.shakil.demoactivitytofragment.Model.PhotosModel;
import com.blackbirds.shakil.demoactivitytofragment.Network.APIService;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {

    APIService apiService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomeViewModel() {
        this.apiService = Common.getMovies();
    }

    public MutableLiveData<List<PhotosModel>> getMovieListMutable() {
        MutableLiveData<List<PhotosModel>> data = new MutableLiveData<>();
        compositeDisposable.add(apiService.getAllPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photosModels -> {
                    if (photosModels != null){
                        data.setValue(photosModels);
                    }
                }));
        return data;
    }
}