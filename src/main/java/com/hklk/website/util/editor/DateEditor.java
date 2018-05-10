package com.hklk.website.util.editor;

import com.hklk.website.util.DateUtil;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class DateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if (!StringUtils.hasText(text)) {
            setValue(null);
        } else {
            setValue(DateUtil.string2Date(text, "yyyy-MM-dd"));
        }
    }

    @Override
    public String getAsText() {

        return getValue().toString();
    }
}
