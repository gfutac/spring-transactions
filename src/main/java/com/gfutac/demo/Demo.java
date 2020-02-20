package com.gfutac.demo;

import com.gfutac.model.TreeNode;
import com.gfutac.repository.TreeNodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class Demo {

    public static final Logger LOG = LoggerFactory.getLogger(Demo.class);

    @Autowired
    TreeNodeRepository repository;

    // only public methods can be annotaded
    @Transactional
    public void transaction_unchecked() {

        LOG.info("transaction_unchecked starting");

        TreeNode a = new TreeNode();
        a.setNodeName("Spring - Node A");
        a.setId(10);
        a.setParentID(1);

        LOG.info("Saving tree node - A");
        this.repository.save(a);

        LOG.info("Division by 0");
        int x = a.getId()/0;

        TreeNode b = new TreeNode();
        b.setNodeName("Spring - Node B");
        b.setId(11);
        b.setParentID(1);

        LOG.info("Saving tree node - B");
        this.repository.save(b);
    }

    @Transactional
    public void transaction_checked_without_rollback() throws FileNotFoundException {
        this.causeException();
    }

    @Transactional(rollbackFor = {FileNotFoundException.class})
    public void transaction_checked_with_rollback() throws FileNotFoundException {
        this.causeException();
    }

    private void causeException() throws FileNotFoundException {
        TreeNode a = new TreeNode();
        a.setNodeName("Spring - Node A");
        a.setId(10);
        a.setParentID(1);
        this.repository.save(a);

        FileReader reader = new FileReader("C:\\negaga.txt");

        TreeNode b = new TreeNode();
        b.setNodeName("Spring - Node B");
        b.setId(11);
        b.setParentID(1);
        this.repository.save(b);
    }
}
