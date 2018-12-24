package com.lt.cloud.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.BalanceReceiver;

import java.lang.Long;
import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, Long>{
	Page<Balance> findAll(Specification<Balance> specification,Pageable pageable);
	@Query(value="select * from balance b where b.B_PayID=?1",nativeQuery=true)
	List<Balance> findByPayId(Long B_PayID);
	@Query(value="select new Balance(b.B_OrderID,b.B_AdItemID,sum(b.B_Amount)) from Balance b where b.B_PayID=?1 group by b.B_AdItemID,b.B_OrderID having sum(b.B_Amount)>0")
	List<Balance> findByPayIdWithAdv(Long B_PayID);
	
//	@Query(value="select new Balance(b.B_OrderID,b.B_AdItemID,sum(b.B_Amount)) from Balance b "
//			+ "where b.B_PayID=#{#receiver.B_PayID}"
//			+ "group by b.B_AdItemID,b.B_OrderID having sum(b.B_Amount)>0")
//	List<Balance> findAllReversable(BalanceReceiver receiver);
	
}
