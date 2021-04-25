package app.core.group;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016\u00a2\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ<\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006!"}, d2 = {"Lapp/core/group/Group;", "Lapp/core/polymorphism/StringContent;", "id", "", "title", "", "specialityId", "students", "", "Lapp/core/student/Student;", "(ILjava/lang/String;I[Lapp/core/student/Student;)V", "getId", "()I", "getSpecialityId", "getStudents", "()[Lapp/core/student/Student;", "[Lapp/core/student/Student;", "getTitle", "()Ljava/lang/String;", "asStringArray", "()[Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;I[Lapp/core/student/Student;)Lapp/core/group/Group;", "equals", "", "other", "", "hashCode", "toString", "Students"})
public final class Group implements app.core.polymorphism.StringContent {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    private final int specialityId = 0;
    @org.jetbrains.annotations.NotNull
    private final app.core.student.Student[] students = null;
    
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
    
    public final int getSpecialityId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.student.Student[] getStudents() {
        return null;
    }
    
    public Group(int id, @org.jetbrains.annotations.NotNull
    java.lang.String title, int specialityId, @org.jetbrains.annotations.NotNull
    app.core.student.Student[] students) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.student.Student[] component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.group.Group copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String title, int specialityId, @org.jetbrains.annotations.NotNull
    app.core.student.Student[] students) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}