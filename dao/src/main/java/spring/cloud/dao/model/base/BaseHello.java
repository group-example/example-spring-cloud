package spring.cloud.dao.model.base;

import java.util.Date;

/**
 * WARNING : Do not modify manually !!! <br>
 * 
 * @maps to:  hello <br>
 * @created by:  mybatis generator <br>
 * @created at:  2017-03-08 19:28:39 <br>
 */
public class BaseHello {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Date dateCreate;

    /**
     * 
     */
    private Date dateModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }
}