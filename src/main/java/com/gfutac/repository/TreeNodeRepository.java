package com.gfutac.repository;

import com.gfutac.model.TreeNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeNodeRepository extends JpaRepository<TreeNode, Integer> {
}
