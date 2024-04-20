package com.colutti.hazelcastmaptradeoff.controller;

import com.colutti.hazelcastmaptradeoff.dto.RequestMapDto;
import com.colutti.hazelcastmaptradeoff.hazelcast_map.impl.SimpleMap;
import com.hazelcast.map.IMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final SimpleMap simpleMap;

    private int getCount = 0;

    @Value("${server.port}")
    private Integer serverPort;

    public MapController(SimpleMap simpleMap) {
        this.simpleMap = simpleMap;
    }

    @GetMapping("/{mapName}")
    public ResponseEntity<?> getMapResponse(@PathVariable("mapName") String mapName){
        IMap<String, String> mapResult = simpleMap.getFullMap(mapName);
        getCount++;
        System.out.printf("Got to %s times the map of the name %s, map size: %s, server port of the task %s%n",
                getCount, mapName, mapResult.size(), serverPort);
        return ResponseEntity.ok(simpleMap.getFullMap(mapName));
    }

    @PostMapping
    public String populateMap(@RequestBody List<RequestMapDto> requestMapDtoList){
        simpleMap.updateMap(requestMapDtoList);
        return "done!";
    }
}
