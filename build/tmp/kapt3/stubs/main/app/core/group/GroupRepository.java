package app.core.group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\u00020\u0004:\u0001\u001cB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J=\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f\"\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016\u00a2\u0006\u0002\u0010\u0012J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000fJA\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\t2.\u0010\u000b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r0\f\"\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\r\u00a2\u0006\u0002\u0010\u0010J=\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\t2*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f\"\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lapp/core/group/GroupRepository;", "Lapp/core/polymorphism/Repository;", "Lapp/core/group/Group;", "Lapp/core/polymorphism/GetById;", "Lapp/core/polymorphism/GetIdByTitle;", "connection", "Ljava/sql/Connection;", "(Ljava/sql/Connection;)V", "add", "Larrow/core/Option;", "", "args", "", "Larrow/core/Either;", "", "", "([Larrow/core/Either;)Larrow/core/Option;", "all", "()[Lapp/core/group/Group;", "getById", "id", "mod", "(II)[Lapp/core/group/Group;", "getIdByTitle", "title", "nextId", "remove", "update", "SQLCommands", "Students"})
public final class GroupRepository extends app.core.polymorphism.Repository<app.core.group.Group> implements app.core.polymorphism.GetById<app.core.group.Group>, app.core.polymorphism.GetIdByTitle {
    private final java.sql.Connection connection = null;
    private static final java.lang.String all = "SELECT * FROM Groups";
    private static final java.lang.String maxId = "SELECT MAX(id) as max_id FROM Groups";
    private static final java.lang.String filteredTitle = "SELECT id FROM Speciality WHERE title = ?";
    private static final java.lang.String add = "INSERT INTO Groups (id, title, speciality_id) VALUES (?, ?, ?)";
    private static final java.lang.String update = "UPDATE Groups SET title = ?, speciality_id = ? WHERE id = ?";
    private static final java.lang.String remove = "DELETE FROM Groups WHERE title = ? AND speciality_id = ?";
    private static final java.lang.String param = "SELECT * FROM Groups WHERE speciality_id = ?";
    @org.jetbrains.annotations.NotNull
    public static final app.core.group.GroupRepository.SQLCommands SQLCommands = null;
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public app.core.group.Group[] getById(int id, int mod) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final arrow.core.Option<java.lang.Integer> getIdByTitle(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public app.core.group.Group[] all() {
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
    
    public GroupRepository(@org.jetbrains.annotations.NotNull
    java.sql.Connection connection) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lapp/core/group/GroupRepository$SQLCommands;", "", "()V", "add", "", "all", "filteredTitle", "maxId", "param", "remove", "update", "Students"})
    public static final class SQLCommands {
        
        private SQLCommands() {
            super();
        }
    }
}