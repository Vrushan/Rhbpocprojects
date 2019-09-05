package com.example.Rhb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Rhb.model.MerchantCategeorys;

@Repository
public interface MerchentRepository extends JpaRepository<MerchantCategeorys, Long>{

}
