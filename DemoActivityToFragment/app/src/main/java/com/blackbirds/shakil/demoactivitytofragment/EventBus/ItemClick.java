package com.blackbirds.shakil.demoactivitytofragment.EventBus;

import com.blackbirds.shakil.demoactivitytofragment.Model.PhotosModel;

public class ItemClick {
    private boolean success;
    private PhotosModel photosModel;

    public ItemClick() {
    }

    public ItemClick(boolean success, PhotosModel photosModel) {
        this.success = success;
        this.photosModel = photosModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public PhotosModel getPhotosModel() {
        return photosModel;
    }

    public void setPhotosModel(PhotosModel photosModel) {
        this.photosModel = photosModel;
    }
}
