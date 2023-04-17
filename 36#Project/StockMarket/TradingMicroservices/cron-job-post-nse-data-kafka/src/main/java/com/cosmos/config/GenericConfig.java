package com.cosmos.config;

import com.cosmos.service.CronService;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Configuration
public class GenericConfig {
    private String bootstrap_server_config_name = "localhost:9092";
    private String outputTopic = "flinkTestDataStreamsOutputTopic";

    @Bean
    public KafkaTemplate<String,Object> getKafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    private ProducerFactory<String,Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server_config_name);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        /*if (useSSL) {
            logBuilder.setComments("******************1").getDataInfoLog();
            configProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
            logBuilder.setComments("******************2").getDataInfoLog();
            configProps.put("sasl.mechanism", "GSSAPI");
            logBuilder.setComments("******************3").getDataInfoLog();
            configProps.put("sasl.kerberos.service.name", "kafka");
            logBuilder.setComments("******************4").getDataInfoLog();
            configProps.put("sasl.jaas.config", "com.sun.security.auth.module.Krb5LoginModule required doNotPrompt=true useTicketCache=false useKeyTab=true keyTab=\"" + keyTabLocation + "\" principal=\"" + kerberosPrincipal + "\" serviceName=\"kafka\";");
            logBuilder.setComments("******************5").getDataInfoLog();
            configProps.put("ssl.truststore.location",sslTruststoreLocation);
            logBuilder.setComments("******************6").getDataInfoLog();
            configProps.put("ssl.truststore.password",readFile(sslTruststorePassword));
            logBuilder.setComments("******************7").getDataInfoLog();
            configProps.put("ssl.keystore.location",sslKeystoreLocation);
            logBuilder.setComments("******************8").getDataInfoLog();
            configProps.put("ssl.keystore.password",readFile(sslKeystorePassword));
            logBuilder.setComments("******************9").getDataInfoLog();
            configProps.put("ssl.key.password",readFile(sslKeystorePassword));
        }*/
        return new DefaultKafkaProducerFactory<>(configProps);
    }
}
