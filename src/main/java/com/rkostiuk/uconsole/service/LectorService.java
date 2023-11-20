package com.rkostiuk.uconsole.service;

import java.util.List;

public interface LectorService {
    List<String> findNamesContainingIgnoreCase(String string);
}
