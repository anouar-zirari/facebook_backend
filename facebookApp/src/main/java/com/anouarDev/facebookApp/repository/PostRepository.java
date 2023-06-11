package com.anouarDev.facebookApp.repository;

import com.anouarDev.facebookApp.model.Post;
import com.anouarDev.facebookApp.model.Users;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostByUser(Users user);
}
