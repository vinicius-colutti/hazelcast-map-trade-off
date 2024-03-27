package com.colutti.hazelcastmaptradeoff.controller;

import com.colutti.hazelcastmaptradeoff.dto.RequestMapDto;
import com.colutti.hazelcastmaptradeoff.hazelcast_map.impl.SimpleMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final SimpleMap simpleMap;

    public MapController(SimpleMap simpleMap) {
        this.simpleMap = simpleMap;
    }

    @GetMapping("/{mapName}")
    public ResponseEntity<?> getMapResponse(@PathVariable("mapName") String mapName){
        return ResponseEntity.ok(simpleMap.getFullMap(mapName));
    }

    @PostMapping
    public String populateMap(@RequestBody RequestMapDto requestMapDto){
        simpleMap.updateMap(requestMapDto);
        return "done!";
    }
}
