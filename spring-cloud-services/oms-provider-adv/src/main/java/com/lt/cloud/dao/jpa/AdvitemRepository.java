package com.lt.cloud.dao.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lt.cloud.pojo.Advitem;
public interface AdvitemRepository extends JpaRepository<Advitem, Long> {
	@Modifying
	@Transactional
	@Query("delete from Advitem a where a.AI_OrderID=?1")
	void deleteByOrderId(Long id);
}
