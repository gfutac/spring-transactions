package com.gfutac.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TreeNode")
public @Data
class TreeNode {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ParentID")
    private Integer parentID;

    @Column(name = "NodeName")
    private String nodeName;

}
