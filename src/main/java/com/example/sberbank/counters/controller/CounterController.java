package com.example.sberbank.counters.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1")
public class CounterController {
    private HashMap <String, Integer> counters = new HashMap<String, Integer>();

    @GetMapping("counters")
    public Set<Map.Entry<String, Integer>> getEntries() {
        Set<Map.Entry<String, Integer>> keySet = counters.entrySet();

        return keySet;
    }

    @GetMapping("counter/{name}")
    public int getCounter(@PathVariable("name") String name){
        Integer value = counters.get(name);
        if (value == null) {
            value = 0;

            counters.put(name, value);
        }


        return value;
    }

    @DeleteMapping("counter/{name}")
    public boolean delete(@PathVariable("name") String name) {
        counters.remove(name);

        return true;
    }

    @GetMapping("counters/sum")
    public int sumCounters() {
        Collection<Integer> values = counters.values();

        int sum = 0;

        Iterator<Integer> iter = values.iterator();
        while(iter.hasNext()){

            sum += iter.next().intValue();
        }

        return sum;
    }

    @PutMapping("counter/{name}")
    public int getCounters(@PathVariable("name") String name){
        Integer value = counters.get(name);
        if (value == null) {
            value = 0;
        }
        int n = value.intValue();
        n++;

        counters.put(name, new Integer(n));

        return n;
    }
}