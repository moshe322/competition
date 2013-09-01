package org.marathon.code.competition.repository;

import org.marathon.code.competition.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {


}
