package com.colutti.hazelcastmaptradeoff.config_instance;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastInstanceConfiguration {

    @Bean
    public HazelcastInstance createInstance(){
        return Hazelcast.newHazelcastInstance();
    }
}
