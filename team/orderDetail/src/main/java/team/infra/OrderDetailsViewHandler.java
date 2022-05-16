package team.infra;

import team.domain.*;
import team.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsViewHandler {


    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {

            if (!ordered.validate()) return;

            // view 객체 생성
            OrderDetails orderDetails = new OrderDetails();
            // view 객체에 이벤트의 Value 를 set 함
            orderDetails.setorderId(ordered.getcustomerId());
            orderDetails.setorderStatus(ordered.getorderStatus());
            orderDetails.settotalPrice(ordered.getorderTotalPrice());
            // view 레파지 토리에 save
            orderDetailsRepository.save(orderDetails);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_1(@Payload OrderCanceled orderCanceled) {
        try {
            if (!orderCanceled.validate()) return;
                // view 객체 조회

                    List<OrderDetails> orderDetailsList = orderDetailsRepository.findByorderId(orderCanceled.getorderId());
                    for(OrderDetails orderDetails : orderDetailsList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDetails.setorderStatus(orderCanceled.getorderStatus());
                // view 레파지 토리에 save
                orderDetailsRepository.save(orderDetails);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_2(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회

                    List<OrderDetails> orderDetailsList = orderDetailsRepository.findByorderId(paymentApproved.getOrderId());
                    for(OrderDetails orderDetails : orderDetailsList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDetails.setpayStatus(paymentApproved.getPaymentStatus());
                // view 레파지 토리에 save
                orderDetailsRepository.save(orderDetails);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_3(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (!paymentCanceled.validate()) return;
                // view 객체 조회

                    List<OrderDetails> orderDetailsList = orderDetailsRepository.findByorderId(paymentCanceled.getOrderId());
                    for(OrderDetails orderDetails : orderDetailsList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDetails.setpayStatus(paymentCanceled.getPaymentStatus());
                // view 레파지 토리에 save
                orderDetailsRepository.save(orderDetails);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_4(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                    List<OrderDetails> orderDetailsList = orderDetailsRepository.findByorderId(deliveryStarted.getorderId());
                    for(OrderDetails orderDetails : orderDetailsList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDetails.setorderStatus(deliveryStarted.getorderStatus());
                // view 레파지 토리에 save
                orderDetailsRepository.save(orderDetails);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_5(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (!deliveryCanceled.validate()) return;
                // view 객체 조회

                    List<OrderDetails> orderDetailsList = orderDetailsRepository.findByorderId(deliveryCanceled.getorderId());
                    for(OrderDetails orderDetails : orderDetailsList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderDetails.setorderStatus(deliveryCanceled.getorderStatus());
                // view 레파지 토리에 save
                orderDetailsRepository.save(orderDetails);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

