package com.rkostiuk.uconsole.command;

import java.util.List;

public record CommandResult (String template, List<Object> templateArgs) {
    public String toFormattedString() {
        return String.format(template, templateArgs.toArray());
    }
}
