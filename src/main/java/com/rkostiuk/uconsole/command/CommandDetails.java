package com.rkostiuk.uconsole.command;

import java.util.List;

public record CommandDetails(CommandType type, List<Object> args) {
}
