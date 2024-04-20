package com.colutti.hazelcastmaptradeoff.hazelcast_map;

import com.colutti.hazelcastmaptradeoff.dto.RequestMapDto;

import java.util.List;

public interface AffectMap<Response> {

    Response getFullMap(String mapName);
    void updateMap(List<RequestMapDto> requestMapDtoList);
}
