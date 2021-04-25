package app.core.faculty;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005JA\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072.\u0010\t\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b0\n\"\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\rJ=\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00072*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n\"\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\u0002\u0010\u000eJ=\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072*\u0010\t\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n\"\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lapp/core/faculty/FacultyRepository;", "Lapp/core/polymorphism/Repository;", "Lapp/core/faculty/Faculty;", "connection", "Ljava/sql/Connection;", "(Ljava/sql/Connection;)V", "add", "Larrow/core/Option;", "", "args", "", "Larrow/core/Either;", "", "", "([Larrow/core/Either;)Larrow/core/Option;", "all", "()[Lapp/core/faculty/Faculty;", "nextId", "remove", "update", "SQLCommands", "Students"})
public final class FacultyRepository extends app.core.polymorphism.Repository<app.core.faculty.Faculty> {
    private final java.sql.Connection connection = null;
    private static final java.lang.String all = "SELECT * FROM Faculty";
    private static final java.lang.String maxId = "SELECT MAX(id) as max_id FROM Faculty";
    private static final java.lang.String add = "INSERT INTO Faculty (id, title) VALUES (?, ?)";
    private static final java.lang.String update = "UPDATE Faculty SET title = ? WHERE id = ?";
    private static final java.lang.String remove = "DELETE FROM Faculty WHERE title = ?";
    @org.jetbrains.annotations.NotNull
    public static final app.core.faculty.FacultyRepository.SQLCommands SQLCommands = null;
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public app.core.faculty.Faculty[] all() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final arrow.core.Option<kotlin.Unit> add(@org.jetbrains.annotations.NotNull
    arrow.core.Either<java.lang.String, java.lang.Integer>... args) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final arrow.core.Option<kotlin.Unit> remove(@org.jetbrains.annotations.NotNull
    arrow.core.Either<java.lang.String, java.lang.Integer>... args) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final arrow.core.Option<kotlin.Unit> update(@org.jetbrains.annotations.NotNull
    arrow.core.Either<java.lang.String, java.lang.Integer>... args) {
        return null;
    }
    
    public final int nextId() {
        return 0;
    }
    
    public FacultyRepository(@org.jetbrains.annotations.NotNull
    java.sql.Connection connection) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lapp/core/faculty/FacultyRepository$SQLCommands;", "", "()V", "add", "", "all", "maxId", "remove", "update", "Students"})
    public static final class SQLCommands {
        
        private SQLCommands() {
            super();
        }
    }
}