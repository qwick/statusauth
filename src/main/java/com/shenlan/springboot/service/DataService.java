package com.shenlan.springboot.service;

import com.shenlan.springboot.entity.MyEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DataService {

    private final List<MyEntity> mockData;

    public DataService() {
        this.mockData = generateMockData(); // 生成模拟数据
    }

    // 模拟生成100万条数据
    private List<MyEntity> generateMockData() {
        List<MyEntity> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(new MyEntity("Column1_" + i, "Column2_" + i, "Column3_" + i,
                    "Column4_" + i, "Column5_" + i, "Column6_" + i, "Column7_" + i));
        }
        return data;
    }

    // 根据页码和每页记录数进行分页
    public List<MyEntity> fetchData(int pageNumber, int pageSize) {
        int fromIndex = pageNumber * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, mockData.size());

        if (fromIndex >= mockData.size()) {
            return Collections.emptyList(); // 如果超出数据范围，返回空列表
        }

        return mockData.subList(fromIndex, toIndex); // 返回分页数据
    }

    // 获取记录总数
    public int getTotalRecordCount() {
        return mockData.size();
    }
}

