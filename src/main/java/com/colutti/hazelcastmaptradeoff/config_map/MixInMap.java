package com.colutti.hazelcastmaptradeoff.config_map;

import com.colutti.hazelcastmaptradeoff.hazelcast_map.impl.SimpleMap;
import com.google.gson.Gson;
import com.hazelcast.map.IMap;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import static com.colutti.hazelcastmaptradeoff.constant.MapName.SIMPLE_MAP_NAME;

@Component
public class MixInMap implements ApplicationListener<ContextRefreshedEvent> {

    private final SimpleMap simpleMap;
    private Gson gson;

    public MixInMap(SimpleMap simpleMap) {
        this.simpleMap = simpleMap;
        this.gson = new Gson();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        IMap<String, String> simpleMapResponse = this.simpleMap.getFullMap(SIMPLE_MAP_NAME);
        System.out.println("Map size: "+ simpleMapResponse.size());
        System.out.println(this.gson.toJson(simpleMapResponse));
    }
}
