package com.example.json.importnew;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

/**
 * Created by zong on 2017/3/23.
 */
public class SinceUntilSample {
    @Since(4)
    public String since;
    @Until(5)
    public String until;
}
