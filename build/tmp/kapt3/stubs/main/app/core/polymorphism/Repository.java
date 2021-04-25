package app.core.polymorphism;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005JI\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2.\u0010\u000b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\f\"\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lapp/core/polymorphism/Repository;", "T", "", "connection", "Ljava/sql/Connection;", "(Ljava/sql/Connection;)V", "action", "Larrow/core/Option;", "", "statement", "", "setters", "", "Larrow/core/Either;", "", "(Ljava/lang/String;[Larrow/core/Either;)Larrow/core/Option;", "all", "()[Ljava/lang/Object;", "nextId", "maxId", "Students"})
public abstract class Repository<T extends java.lang.Object> {
    private final java.sql.Connection connection = null;
    
    @org.jetbrains.annotations.NotNull
    public abstract T[] all();
    
    public final int nextId(@org.jetbrains.annotations.NotNull
    java.lang.String maxId) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final arrow.core.Option<kotlin.Unit> action(@org.jetbrains.annotations.NotNull
    java.lang.String statement, @org.jetbrains.annotations.NotNull
    arrow.core.Either<java.lang.String, java.lang.Integer>... setters) {
        return null;
    }
    
    public Repository(@org.jetbrains.annotations.NotNull
    java.sql.Connection connection) {
        super();
    }
}