package com.example.myapplication

import com.example.myapplication.http.Service
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    @Test
    public fun testSimple(){
        Service service = RetrofitUtil.get();
    }
}