package com.rkostiuk.uconsole.command;

import java.util.List;

public record CommandParam(CommandType type, List<Object> args) {
}
