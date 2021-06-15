package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class DictionaryImpl implements IDictionaryService {
    @Override
    public String dictionary(String result) {
        return result;
    }
}
