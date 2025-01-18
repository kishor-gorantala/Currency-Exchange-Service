package com.kishor_gorantala.currency_exchange_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

//    @Query(value="Select * from CURRENCY_EXCHANGE where CURRENCY_FROM=:from AND CURRENCY_TO=:to",nativeQuery = true)
//    public CurrencyExchange retrieveValuesByFromAndTo(String from, String to);
//
    @Query(value="Select * from CURRENCY_EXCHANGE where CURRENCY_FROM=:from AND CURRENCY_TO=:to",nativeQuery = true)
    public CurrencyExchange FindByFromAndTo(String from, String to);
}
