package com.polixis.task.repository;

import com.polixis.task.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Message, Long> {
}
