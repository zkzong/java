package org.example;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmployeeBinding {
    String EMP_CHANNEL = "empChannel";

    @Input(EMP_CHANNEL)
    SubscribableChannel empMsg();
}
