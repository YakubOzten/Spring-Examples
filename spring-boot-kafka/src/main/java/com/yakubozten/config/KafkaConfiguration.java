package com.yakubozten.config;

import com.yakubozten.dto.Kmessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration  {


    @Value("${yakubozten.kafka.address}")
    private  String kafkaAddress;

    @Value("${yakubozten.kafka.group.id}")
    private String groupId;
    @Bean
    public KafkaTemplate<String, Kmessage>kafkaTemplate(){
        return  new KafkaTemplate<>(producerFactory());
    }


    @Bean             //Veri Sağlayan
    public ProducerFactory producerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaAddress);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Kmessage>kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Kmessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return  factory;
    }

    @Bean  //Veri Tüketen
    public ConsumerFactory<String,Kmessage> consumerFactory(){
        Map<String,Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE,Kmessage.class);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }




}
