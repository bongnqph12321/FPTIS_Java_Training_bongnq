package fis.java.core.lab02_2.dao;

import fis.java.core.lab02_2.dao.validation.IValidation;

public class InputComponent {
    private IValidation validation;
    private String data;

    public InputComponent() {
    }

    public InputComponent(IValidation validation, String data) {
        this.validation = validation;
        this.data = data;
    }

    public IValidation getValidation() {
        return validation;
    }

    public void setValidation(IValidation validation) {
        this.validation = validation;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
