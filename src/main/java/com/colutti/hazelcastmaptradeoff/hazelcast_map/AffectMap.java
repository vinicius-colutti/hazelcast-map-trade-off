package com.colutti.hazelcastmaptradeoff.hazelcast_map;

import com.colutti.hazelcastmaptradeoff.dto.RequestMapDto;

public interface AffectMap<Response> {

    Response getFullMap(String mapName);
    void updateMap(RequestMapDto requestMapDto);
}
