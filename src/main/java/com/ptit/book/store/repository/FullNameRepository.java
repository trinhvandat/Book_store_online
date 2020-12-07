package com.ptit.book.store.repository;

import com.ptit.book.store.model.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface FullNameRepository extends JpaRepository<FullName, Integer> {
}
