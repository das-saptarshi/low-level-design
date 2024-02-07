package com.saptarshi.das.lowleveldesigns.collections.hashmaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTests {

    @Test
    void testCustomHashMap_ForValidScenario() {
        final HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        final CustomHashMap<Integer, String> customMap = new CustomHashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            customMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Assertions.assertEquals(entry.getValue(), customMap.get(entry.getKey()));
        }
    }
}
