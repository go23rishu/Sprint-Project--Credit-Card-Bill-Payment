package com.cg.creditcardbillpaymen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpaymen.entities.Statement;

public interface StatementRepository extends JpaRepository<Statement,Long>{

}
