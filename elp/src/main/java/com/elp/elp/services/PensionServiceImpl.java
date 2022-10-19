package com.elp.elp.services;

import com.elp.elp.dao.PensionDao;
import com.elp.elp.models.Pension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensionServiceImpl implements PensionService{

    @Autowired
    private PensionDao pensionDao;
    @Override
    public List<Pension> findAll() {
        return pensionDao.findAll();
    }
}
