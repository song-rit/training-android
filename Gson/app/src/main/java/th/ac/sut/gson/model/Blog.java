package th.ac.sut.gson.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by developer on 14/5/2559.
 */
public class Blog {

    private String status;

    private int count;

    @SerializedName("count_total")
    private int countTotal;

    private int page;

    private List<Post> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
