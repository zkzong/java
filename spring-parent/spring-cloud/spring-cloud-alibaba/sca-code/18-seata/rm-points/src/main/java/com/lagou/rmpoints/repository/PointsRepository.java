package com.lagou.rmpoints.repository;

import com.lagou.rmpoints.entity.Points;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointsRepository extends JpaRepository<Points,Integer> {

}
