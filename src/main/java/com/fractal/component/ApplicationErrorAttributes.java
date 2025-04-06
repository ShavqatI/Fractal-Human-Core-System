package com.fractal.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class ApplicationErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(
            WebRequest webRequest,
            ErrorAttributeOptions options) {

        // Remove stack trace explicitly
        options = options.excluding(Include.STACK_TRACE);

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

        // Optionally remove more fields like "exception"
        errorAttributes.remove("trace");
        errorAttributes.remove("exception");

        return errorAttributes;
    }
}
