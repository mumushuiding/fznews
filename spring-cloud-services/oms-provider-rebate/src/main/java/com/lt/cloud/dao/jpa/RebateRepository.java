package com.lt.cloud.dao.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;

import reactor.util.annotation.Nullable;
@Repository
public interface RebateRepository extends JpaRepository<Rebate, Long>{



	@Query(value = "select * from rebate where if(?1 !='',R_Customer like %?1%,1=1) and if(?2 !='',R_Date>=?2,1=1)" +
            "and if(?3 !='',R_Date<=?3,1=1)  ",
            countQuery="select count(SYS_DOCUMENTID) from rebate where if(?1 !='',R_Customer like '%?1%',1=1) and if(?2 !='',R_Date>=?2,1=1)" +
                    "and if(?3 !='',R_Date<=?3,1=1)  ",
            nativeQuery = true)

	Page<Rebate> findAllRebate(String customer,Date start,Date end,Pageable pageable);
	
	
	Page<Rebate> findByCustomerContainingAndRDateBetween(String customer,@Nullable Date start,@Nullable Date end,Pageable pageable);
	
	Page<Rebate> findByCustomerLikeAndRDateBetween(String customer,@Nullable Date start,@Nullable Date end,Pageable pageable);
	 
	Page<Rebate> findAll(Specification<RebateReceive> spec,Pageable pageable);
	
	List<Rebate> findAll(Specification<RebateReceive> spec);

	
}
