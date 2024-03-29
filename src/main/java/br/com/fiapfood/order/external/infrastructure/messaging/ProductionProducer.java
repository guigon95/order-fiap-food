package br.com.fiapfood.order.external.infrastructure.messaging;

import br.com.fiapfood.order.adapter.dto.messaging.OrderMessageDto;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductionProducer {

    @Value("${aws.productionQueueName}")
    private String queueName;

    private final AmazonSQS amazonSQSClient;
    
    private final ObjectMapper objectMapper;

    public void publishMessage(OrderMessageDto message) {

        try {
            String messageAsString = objectMapper.writeValueAsString(message);

            log.info("Publish message "+ messageAsString);

            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);
            var result = amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), messageAsString);
        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
        }

    }
}
