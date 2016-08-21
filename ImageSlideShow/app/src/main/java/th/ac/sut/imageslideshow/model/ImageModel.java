package th.ac.sut.imageslideshow.model;

import java.util.ArrayList;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImageModel {

    private boolean status;
    private ArrayList<ProductModel> products;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }
}
