package nl.projectofinal.personaltaskmanagerstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nl.projectofinal.personaltaskmanagerstudents.entity.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //define custom query methods when needed
    Optional<Category> findByName(String name);
}
