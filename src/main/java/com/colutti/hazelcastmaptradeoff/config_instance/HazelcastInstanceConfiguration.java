package com.colutti.hazelcastmaptradeoff.config_instance;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastInstanceConfiguration {

    @Bean
    public HazelcastInstance createInstance(){
        Config config = new Config();
        config.setClusterName("dev");
        // Configuração do TCP-IP
        config.getNetworkConfig().getJoin().getTcpIpConfig()
                .setEnabled(true)
                .addMember("127.0.0.1");
        return Hazelcast.newHazelcastInstance(config);
    }
}
