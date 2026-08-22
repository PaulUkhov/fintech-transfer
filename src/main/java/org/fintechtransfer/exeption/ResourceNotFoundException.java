package org.fintechtransfer.exeption;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entityName, Long entityId) {
        super(entityName + " not found with id: " + entityId);
    }
}
