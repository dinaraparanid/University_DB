package app.core.subject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016\u00a2\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJB\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006$"}, d2 = {"Lapp/core/subject/Subject;", "Lapp/core/polymorphism/StringContent;", "id", "", "title", "", "teachers", "", "Lapp/core/teacher/Teacher;", "departments", "Lapp/core/department/Department;", "(ILjava/lang/String;[Lapp/core/teacher/Teacher;[Lapp/core/department/Department;)V", "getDepartments", "()[Lapp/core/department/Department;", "[Lapp/core/department/Department;", "getId", "()I", "getTeachers", "()[Lapp/core/teacher/Teacher;", "[Lapp/core/teacher/Teacher;", "getTitle", "()Ljava/lang/String;", "asStringArray", "()[Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;[Lapp/core/teacher/Teacher;[Lapp/core/department/Department;)Lapp/core/subject/Subject;", "equals", "", "other", "", "hashCode", "toString", "Students"})
public final class Subject implements app.core.polymorphism.StringContent {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final app.core.teacher.Teacher[] teachers = null;
    @org.jetbrains.annotations.NotNull
    private final app.core.department.Department[] departments = null;
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String[] asStringArray() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.teacher.Teacher[] getTeachers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.department.Department[] getDepartments() {
        return null;
    }
    
    public Subject(int id, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    app.core.teacher.Teacher[] teachers, @org.jetbrains.annotations.NotNull
    app.core.department.Department[] departments) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.teacher.Teacher[] component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.department.Department[] component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.subject.Subject copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String title, @org.jetbrains.annotations.NotNull
    app.core.teacher.Teacher[] teachers, @org.jetbrains.annotations.NotNull
    app.core.department.Department[] departments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}