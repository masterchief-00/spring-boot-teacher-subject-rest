package com.kwizera.spring_boot_teacher_subject.mappers;

public interface Mappers<A, B> {
    B mapTo(A a);

    A mapFrom(B b);
}
