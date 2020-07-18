package com.seata.sys.common.dto;

import java.io.Serializable;

/**
 * 描述: ZTree节点
 *
 * @author Yangjinming
 * @create 2018-03-28 下午9:09
 */
public class ZTreeNode  implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -8423405906539074148L;

    /**
     * 节点ID
     */
    private String id;
    /**
     * 父节点的ID
     */
    private String pId;
    /**
     * 节点的名称
     */
    private String name;

    public ZTreeNode(String id, String pId, String name) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    /**
     *
     * 构建树节点实例
     * @param id  节点ID
     * @param pId
     * @param name 节点的名称
     * @return
     */
    public static ZTreeNode getInstance(String id, String pId, String name){
        return new ZTreeNode(id,pId,name);
    }

    public String getId() {
        return id;
    }

    public String getPId() {
        return pId;
    }

    public String getName() {
        return name;
    }
}
