package com.mycompany.app;
//import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

//import org.apache.kafka.clients.producer;

import java.util.Properties;

public class App 
{
    public static void main( String[] args )
    {

        Properties props = new Properties () ;
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.31.18.63:9092");
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String,String> producer = new KafkaProducer<>(props);
        for ( int i = 0; i < 100; i ++)
            producer.send(new ProducerRecord<String,String>("topic1", Integer.toString(i), Integer.toString(i)));
        producer.close() ;

    }
}
