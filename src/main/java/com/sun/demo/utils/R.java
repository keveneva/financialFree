package com.sun.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("hasError", false);
    }

    public static R error() {
        return error("发生错误");
    }

    public static R error(String msg) {
        R r = new R();
        r.put("hasError", true);
        r.put("msg", msg);
        return r;
    }

    public static R error(Map<String,String> param) {
        R r = new R();
        r.put("hasError", true);
        r.put("msg", param);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Object resultData) {
        R r = new R();
        r.put("result", resultData);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}