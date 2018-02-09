package com.sun.demo.common;


import com.sun.demo.utils.IdWorker;


/**
 * Created by me on 2018/1/15.
 */
public class BaseEntity {
    private Long id;

    private int status;//0 正常 1 删除

    public Long getId() {
        return id;
    }

    protected BaseEntity(){
        setId(id);
    }
    public void setId(Long id) {
        IdWorker idWorker = new IdWorker(2);
        if (null == id){
            id = idWorker.nextId();
        }
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
