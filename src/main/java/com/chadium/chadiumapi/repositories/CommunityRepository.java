package com.chadium.chadiumapi.repositories;

import com.chadium.chadiumapi.enteties.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {
}
