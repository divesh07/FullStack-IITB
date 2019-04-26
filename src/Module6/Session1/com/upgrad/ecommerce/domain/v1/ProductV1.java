package com.upgrad.ecommerce.domain.v1;

public class ProductV1 {
    private String name;
    private BrandV1 brand;
    private String description;
    private Image[] images;

    public ProductV1(String name, BrandV1 brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandV1 getBrand() {
        return brand;
    }

    public void setBrand(BrandV1 brand) {
        this.brand = brand;
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
