package com.lti.fms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "usertable")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId(){
        return id;
    }

    public void setId(final Integer id){
        this.id=id;
    }

    private String name;

    public String getName(){
        return name;
    }

    public void setName(final String name){
        this.name=name;
    }

    public User(Integer id, String name){
        this.id=id;
        this.name=name;
    }

    public User(){

    }

    @Override
    public boolean equals(Object obj) {
      if(obj==this){
          return true;
      }
      if(obj==null || !(obj instanceof User)){
          return false;
      }
      User u=(User)obj;
      return u.id.equals(this.id);
    }


    @Override
    public int hashCode() {
        if(id==null){
            return 0;
        }
        return id.hashCode();
    }
}
