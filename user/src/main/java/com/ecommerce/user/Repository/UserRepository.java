package com.ecommerce.user.Repository;

import com.ecommerce.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
// Crud repository bhi use kr skte h

@Repository // Making it repository
public interface UserRepository extends MongoRepository<User, String> {
}
