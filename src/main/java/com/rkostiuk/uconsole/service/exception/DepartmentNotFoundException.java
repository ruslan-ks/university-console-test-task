package com.rkostiuk.uconsole.service.exception;

public class DepartmentNotFoundException extends EntityNotFoundException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
