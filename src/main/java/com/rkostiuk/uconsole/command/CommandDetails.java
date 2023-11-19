package com.rkostiuk.uconsole.command;

import java.util.Arrays;
import java.util.Objects;

public record CommandDetails(CommandType type, Object[] args) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandDetails that = (CommandDetails) o;
        return type == that.type && Arrays.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(type);
        result = 31 * result + Arrays.hashCode(args);
        return result;
    }

    @Override
    public String toString() {
        return "CommandDetails{" +
                "type=" + type +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
