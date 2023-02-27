package com.example.fuckmylife;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.fuckmylife.http.Service;
import com.example.fuckmylife.http.retrofitUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void testSimple() throws IOException {
        Service service = retrofitUtil.get();
        Call<String> call = service.listRepos("jorisdeguet");
        Response<String> response = call.execute();
        String result = response.body();
        Log.i("RETROFIT",result);
    }
}