package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueLinkType;

public interface IssueLinkTypeRepository extends JpaRepository<IssueLinkType, Long> {

}
