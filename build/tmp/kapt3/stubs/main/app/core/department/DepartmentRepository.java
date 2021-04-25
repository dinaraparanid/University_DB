package app.core.department;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0019B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006JA\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2.\u0010\n\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f0\u000b\"\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u000eJ=\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\b2*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b\"\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\u0010\u000fJ=\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2*\u0010\n\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b\"\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lapp/core/department/DepartmentRepository;", "Lapp/core/polymorphism/Repository;", "Lapp/core/department/Department;", "Lapp/core/polymorphism/GetById;", "connection", "Ljava/sql/Connection;", "(Ljava/sql/Connection;)V", "add", "Larrow/core/Option;", "", "args", "", "Larrow/core/Either;", "", "", "([Larrow/core/Either;)Larrow/core/Option;", "all", "()[Lapp/core/department/Department;", "getById", "id", "mod", "(II)[Lapp/core/department/Department;", "nextId", "remove", "update", "SQLCommands", "Students"})
public final class DepartmentRepository extends app.core.polymorphism.Repository<app.core.department.Department> implements app.core.polymorphism.GetById<app.core.department.Department> {
    private final java.sql.Connection connection = null;
    private static final java.lang.String all = "SELECT * FROM Department";
    private static final java.lang.String filtered = "SELECT * FROM Department WHERE id = ?";
    private static final java.lang.String maxId = "SELECT MAX(id) as max_id FROM Department";
    private static final java.lang.String add = "INSERT INTO Department (id, title, faculty_id) VALUES (?, ?, ?)";
    private static final java.lang.String update = "UPDATE Department SET title = ?, faculty_id = ? WHERE id = ?";
    private static final java.lang.String remove = "DELETE FROM Department WHERE title = ?";
    private static final java.lang.String paramFac = "SELECT id FROM Department WHERE faculty_id = ?";
    private static final java.lang.String paramSubj = "SELECT department_id FROM Subj_Dep WHERE subject_id = ?";
    @org.jetbrains.annotations.NotNull
    public static final app.core.department.DepartmentRepository.SQLCommands SQLCommands = null;
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public app.core.department.Department[] getById(int id, int mod) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public app.core.department.Department[] all() {
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
    
    public DepartmentRepository(@org.jetbrains.annotations.NotNull
    java.sql.Connection connection) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lapp/core/department/DepartmentRepository$SQLCommands;", "", "()V", "add", "", "all", "filtered", "maxId", "paramFac", "paramSubj", "remove", "update", "Students"})
    public static final class SQLCommands {
        
        private SQLCommands() {
            super();
        }
    }
}