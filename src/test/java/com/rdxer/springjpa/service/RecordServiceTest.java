package com.rdxer.springjpa.service;

import com.rdxer.springjpa.model.Record;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordServiceTest {
    @Resource
    RecordService recordService;

    @Test
    public void testAdd(){
        Record show = new Record();
        show.setAge(18);
        show.setName("lixiaofeng");
        System.out.println(show);
        Record saved = recordService.save(show);
        System.out.println(show);
        assertNotNull(saved.getId());
    }

    @Test
    public void testShow(){
        Record show = recordService.show(1L);
        System.out.println(show);
        assertNotNull(show);
    }

    @Test
    public void testFindAll(){
        List<Record> show = recordService.getAll();
        System.out.println(show);
        assertNotNull(show);
    }


}