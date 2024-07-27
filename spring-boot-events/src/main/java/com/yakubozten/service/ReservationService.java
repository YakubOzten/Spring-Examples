package com.yakubozten.service;


import com.yakubozten.api.BookingApi;
import com.yakubozten.api.HotelBookRequest;
import com.yakubozten.event.ReservationCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationEvent(HotelBookRequest hotelBookRequest){
      applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }
}
