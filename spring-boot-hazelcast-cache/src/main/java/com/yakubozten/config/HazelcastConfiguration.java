package com.yakubozten.config;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.EvictionConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.client.HazelcastClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {
    @Bean
    public HazelcastInstance hazelcastInstance() {
        ClientConfig clientConfig = new ClientConfig();

        // Set group config (assuming recent versions)
        clientConfig.setClusterName("dev");

        // Set network config
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.addAddress("127.0.0.1:5701");

        // Configure eviction
        EvictionConfig evictionConfig = new EvictionConfig()
                .setSize(10000)
                .setMaxSizePolicy(MaxSizePolicy.ENTRY_COUNT)
                .setEvictionPolicy(EvictionPolicy.LRU);

        // Configure map
        MapConfig mapConfig = new MapConfig("custom.cache.region.name");
        mapConfig.setEvictionConfig(evictionConfig);
        mapConfig.setStatisticsEnabled(true);

        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}