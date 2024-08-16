package com.man4fun.game.rpc.core.client;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ClientReadNtfHandler {
    private static Map<String, Consumer<Object>> ntfHandler = new HashMap<>();


    public static void register(String ntfName, Consumer<Object> consumer){
        ntfHandler.put(ntfName, consumer);
    }

    public static void onClientReadNtf(String ntfName, Object response){
        Consumer<Object> consumer = ntfHandler.get(ntfName);
        if(consumer == null)
            return;

        consumer.accept(response);
    }
}
