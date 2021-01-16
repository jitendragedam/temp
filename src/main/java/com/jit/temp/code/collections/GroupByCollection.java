package com.jit.temp.code.collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByCollection {

    public Map<String, List<Employee>> groupEmployeesByCity(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getCity));
    }

}
