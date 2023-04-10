package com.anouarDev.facebookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Notification extends JpaRepository<Notification, Long> {
}
