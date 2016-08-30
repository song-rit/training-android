package th.ac.sut.sharedpreferences.app;

import okhttp3.MediaType;

/**
 * Created by Developer on 29/8/2559.
 */
public class Constant {

    public static final String URL_LOGIN = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWRm8ySlNmR1ZXLWs&export=download";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public class SharePreference {

        public static final String LOG_IN = "login";
        public static final String NAME = "name";
        public static final String LAST_NAME = "lastName";
        public static final String MAJOR = "major";
        public static final String UNIVERSITY = "university";
    }

}


