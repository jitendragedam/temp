package com.jit.temp.code.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GroupByCollectionTest {
    private GroupByCollection sut = new GroupByCollection();

    @Test
    public void testGroupBy() {
        List<Employee> employees = new ArrayList<>();
        int count = 0;
        Employee e1 = new Employee("A", "C1", count++);
        Employee e2 = new Employee("B", "C1", count++);
        Employee e3 = new Employee("c", "C1", count++);
        Employee e4 = new Employee("D", "C2", count++);
        Employee e5 = new Employee("E", "C2", count++);
        Employee e6 = new Employee("F", "C3", count++);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        Map<String, List<Employee>> resultMap = sut.groupEmployeesByCity(employees);

        assertEquals(resultMap.size(), 3); // since we have 3 cities
        assertEquals(resultMap.get("C1").size(), 3); // since we have 3 employees from C1
        assertEquals(resultMap.get("C2").size(), 2); // since we have 2 employees from C2
        assertEquals(resultMap.get("C3").size(), 1); // since we have 1 employee from C3

        // Verify cities of employees
        assertTrue(resultMap.get("C1").containsAll(Arrays.asList(e1, e2,e3)));
        assertTrue(resultMap.get("C2").containsAll(Arrays.asList(e4, e5)));
        assertTrue(resultMap.get("C3").containsAll(Arrays.asList(e6)));

    }

}