package com.admin.crawler.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回数据
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private List<String> keys;

    private List<Object> values;


    public R() {
        put("code", 1000);
        put("msg", "success");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }


    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
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


    public R putKeys(String... keys) {
        List<String> ks = this.keys;
        if (ks == null) {
            ks = new ArrayList<>();
        }
        for (String k : keys) {
            ks.add(k);
        }
        this.keys = ks;
        return this;
    }

    public R putValues(Object... values) {
        for (int i = 0; i < this.keys.size(); i++) {
            super.put(this.keys.get(i), values[i]);
        }
        return this;
    }


    public R putData(String key, Object value) {
        Object data = this.get("data");
        Map<String, Object> map = new HashMap<>();
        if (data != null) {
            map = (Map<String, Object>) data;
        }
        map.put(key, value);
        super.put("data", map);
        return this;
    }

    public R putData(Object value) {
        super.put("data", value);
        return this;
    }


}
