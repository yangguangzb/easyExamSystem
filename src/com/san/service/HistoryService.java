package com.san.service;

import com.san.model.UseRecord;

import java.util.List;

public interface HistoryService {

     List<UseRecord> listUseRecord(int userId);
}
