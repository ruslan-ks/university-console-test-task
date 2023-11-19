package com.rkostiuk.uconsole.command.parser.chain;

import com.rkostiuk.uconsole.command.CommandParam;
import com.rkostiuk.uconsole.command.CommandType;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class RegexBasedCommandParserChain extends CommandParserChain {

    /**
     * @return Pattern to be used for command matching
     */
    protected abstract Pattern getCommandPattern();

    /**
     * @return Groups to be used for arguments extracting via Matcher#group(int)
     */
    protected abstract List<Integer> getArgumentGroups();

    /**
     * @return Type of this command
     */
    protected abstract CommandType getCommandType();

    @Override
    public CommandParam parse(String command) {
        Matcher matcher = getCommandPattern().matcher(command);
        if (matcher.matches()) {
            return new CommandParam(getCommandType(), extractArgs(matcher));
        }
        return callFallbackIfPresentOrElseThrow(command);
    }

    private List<Object> extractArgs(Matcher matcher) {
        return getArgumentGroups().stream()
                .map(matcher::group)
                .map(s -> (Object) s)
                .toList();
    }
}
