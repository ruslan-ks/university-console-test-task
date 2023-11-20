package com.rkostiuk.uconsole;

import com.rkostiuk.uconsole.command.Command;
import com.rkostiuk.uconsole.command.CommandDetails;
import com.rkostiuk.uconsole.command.CommandResult;
import com.rkostiuk.uconsole.command.exception.UnknownCommandException;
import com.rkostiuk.uconsole.command.factory.CommandFactory;
import com.rkostiuk.uconsole.command.parser.CommandParser;
import com.rkostiuk.uconsole.service.exception.DepartmentNotFoundException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

@Component
public class UniversityCommandRunner implements CommandLineRunner {
    private static final InputStream in = System.in;
    private static final PrintStream out = System.out;

    private final CommandParser commandParser;
    private final CommandFactory commandFactory;

    public UniversityCommandRunner(CommandParser commandParser, CommandFactory commandFactory) {
        this.commandParser = commandParser;
        this.commandFactory = commandFactory;
    }

    @Override
    public void run(String... args) {
        printSupportedCommands();
        readAndExecuteCommands();
    }

    private void printSupportedCommands() {
        out.println("Supported commands:");
        out.println("Who is head of department {department_name}");
        out.println("Show {department_name} statistics");
        out.println("Show the average salary for the department {department_name}");
        out.println("Show count of employee for {department_name}");
        out.println("Global search by {template}");
        out.println("exit");
        out.println();
        out.println("Enter commands:");
    }

    private void readAndExecuteCommands() {
        var scanner = new Scanner(in);
        Stream.generate(scanner::nextLine)
                .takeWhile(this::notEqualExit)
                .forEachOrdered(this::executeCommand);
    }

    private boolean notEqualExit(String string) {
        return !string.equals("exit");
    }

    private void executeCommand(String line) {
        try {
            CommandDetails details = commandParser.parse(line);
            Command command = commandFactory.getCommand(details.type());
            CommandResult result = command.execute(details.args());

            printResult(result);
        } catch (UnknownCommandException | DepartmentNotFoundException e) {
            out.println(e.getMessage());
        }
    }

    private void printResult(CommandResult result) {
        out.println(result.toFormattedString());
        out.println();
    }
}
