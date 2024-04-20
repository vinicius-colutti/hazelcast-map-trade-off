package com.colutti.hazelcastmaptradeoff.hazelcast_map.impl;

import com.colutti.hazelcastmaptradeoff.dto.RequestMapDto;
import com.colutti.hazelcastmaptradeoff.hazelcast_map.AffectMap;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleMap implements AffectMap<IMap<String, String>> {

    private final HazelcastInstance hazelcastInstance;

    public SimpleMap(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public IMap<String, String> getFullMap(String mapName) {
        return hazelcastInstance.getMap(mapName);
    }

    @Override
    public void updateMap(List<RequestMapDto> requestMapDtoList) {
        requestMapDtoList.forEach(requestMapDto -> {
            IMap<String, String> actualMap = hazelcastInstance.getMap(requestMapDto.getMapName());
            actualMap.put(requestMapDto.getKey(), requestMapDto.getValue());
        });
    }
}
