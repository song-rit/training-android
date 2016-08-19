package th.ac.sut.imageslideshow.model;

import java.util.ArrayList;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImageModel {

    private String status;
    private ArrayList<ProductModel> products;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }
}
