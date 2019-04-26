package com.upgrad.ecommerce.domain.v1;

public class BrandV1 {
    private String name;
    private String description;
    private Image[] images;

    public BrandV1(String name) {
        this.name = name;
        this.images = new Image[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }

    public void addImage(Image image) {
        for (int i = 0; i < images.length; i++) {
            if (null == images[i]) {
                images[i] = image;
                return;
            }
        }
    }

    public Image getDefaultImage(){
        for (int i = 0; i < images.length; i++) {
            if ( images[1].isDefaultImg()) {
                return images[i];
            }
        }
        return null;
    }

}
