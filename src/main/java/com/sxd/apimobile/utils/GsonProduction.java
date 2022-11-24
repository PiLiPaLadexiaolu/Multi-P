package com.sxd.apimobile.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonProduction {
    /**
     * Gson使用工具 解决Gson反序列化LocalDateTime Api Warning 问题
     * @return
     */
   public static Gson GsonBuild() {
       Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class
       , (JsonSerializer<LocalDateTime>) (o, type, jsonSerializationContext) -> new JsonPrimitive(o.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))).serializeNulls().create();
       return  gson;
   }
}
