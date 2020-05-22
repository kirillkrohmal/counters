package com.example.sberbank.counters.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("api/v1/counter")
public class CounterController {
    private HashMap <String, Integer> counters = new HashMap<String, Integer>();

    @GetMapping("keys")
    public Set<String> getKeys() {
        Set<String> keySet = counters.keySet();

        return keySet;
    }

    @GetMapping("get/{name}")
    public int getCounter(@PathVariable("name") String name){
        Integer value = counters.get(name);
        if (value == null) {
            value = 0;

            counters.put(name, value);
        }

        int n = value;
        n++;

        counters.put(name, n);

        return n;
    }

    @DeleteMapping("delete/{name}")
    public int delete(@PathVariable("name") String name) {

        Integer value = counters.get(name);
        if (value == null) {
            value = 0;

            counters.remove(name, value);
        }

        int n = value;
        n--;

        return n;
    }

    @PostMapping("sumCounters/{name}")
    public int sumCounters(@PathVariable("name") String name) {

        Integer value = counters.get(name);
        if (value == null) {

        }

        return 1;
    }
}