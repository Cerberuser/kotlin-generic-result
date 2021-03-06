/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.cerbe.result.test.java;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import ru.cerbe.result.Result;

public class App {
    public Result<String, ? extends Throwable> getGreeting(String name) {
        return Result.ofFallible(IllegalArgumentException.class, () -> tryGreeting(name));
    }

    public static void main(String[] args) {
        String name = Result.ofFallible(ArrayIndexOutOfBoundsException.class, () -> args[0]).unwrapOrNull();
        System.out.println(new App().getGreeting(name).expectErr("Greeting generated successfully"));
    }

    @NotNull
    @Contract("null -> fail")
    private String tryGreeting(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Name for the greeter must not be null");
        } else if (name.equals("")) {
            throw new IllegalArgumentException("Name for the greater must not be empty");
        } else if (name.equals("foo")) {
            throw new IllegalArgumentException("Come on, use a more creative name!");
        }
        return "Hello, " + name + "!";
    }
}
