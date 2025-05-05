package com.pack1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pack1.entity.Books;

public interface BookRepository extends JpaRepository<Books, String> 
{

}
