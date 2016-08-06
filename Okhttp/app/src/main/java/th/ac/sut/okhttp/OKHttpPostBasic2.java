package th.ac.sut.okhttp;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Developer on 6/8/2559.
 */
public class OKHttpPostBasic2 {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

    @TargetApi(Build.VERSION_CODES.KITKAT)
    String post(String url, String json) throws IOException {
        RequestBody  body = RequestBody.create(JSON ,json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try(Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }

}
