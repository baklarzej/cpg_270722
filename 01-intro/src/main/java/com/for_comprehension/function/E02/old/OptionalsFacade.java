package com.for_comprehension.function.E02.old;

import java.util.Optional;

public class OptionalsFacade {

    private final OptionalsRefactor original;

    public OptionalsFacade(OptionalsRefactor optionalsRefactor) {
        this.original = optionalsRefactor;
    }

    Optional<OptionalsRefactor.Person> findPerson(int id) {
        return Optional.ofNullable(original.findPerson(id));
    }

    Optional<String> findAddress(OptionalsRefactor.Person person) {
        return Optional.ofNullable(original.findAddress(person));

    }

    Optional<String> findAddressById(int id) {
        return Optional.ofNullable(original.findAddressById(id));
    }

}
