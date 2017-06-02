package com.Reg.Reg;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by kenhike on 29/5/17.
 */
public interface RegRopos extends CrudRepository<RegPojo,Long>
{
    List<RegPojo> findByName(String name);

}
