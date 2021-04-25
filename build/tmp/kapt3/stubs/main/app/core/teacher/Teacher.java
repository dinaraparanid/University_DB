package app.core.teacher;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\u0002\u0010\u000eJ\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016\u00a2\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ`\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0001\u00a2\u0006\u0002\u0010&J\u0013\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001a\u00020\u0003H\u0016J\t\u0010,\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006-"}, d2 = {"Lapp/core/teacher/Teacher;", "Lapp/core/polymorphism/StringContent;", "id", "", "firstName", "", "secondName", "middleName", "info", "specialities", "", "Lapp/core/speciality/Speciality;", "subjects", "Lapp/core/subject/Subject;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lapp/core/speciality/Speciality;[Lapp/core/subject/Subject;)V", "getFirstName", "()Ljava/lang/String;", "getId", "()I", "getInfo", "getMiddleName", "getSecondName", "getSpecialities", "()[Lapp/core/speciality/Speciality;", "[Lapp/core/speciality/Speciality;", "getSubjects", "()[Lapp/core/subject/Subject;", "[Lapp/core/subject/Subject;", "asStringArray", "()[Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lapp/core/speciality/Speciality;[Lapp/core/subject/Subject;)Lapp/core/teacher/Teacher;", "equals", "", "other", "", "hashCode", "toString", "Students"})
public final class Teacher implements app.core.polymorphism.StringContent {
    private final int id = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String firstName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String secondName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String middleName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String info = null;
    @org.jetbrains.annotations.NotNull
    private final app.core.speciality.Speciality[] specialities = null;
    @org.jetbrains.annotations.NotNull
    private final app.core.subject.Subject[] subjects = null;
    
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
    public final java.lang.String getFirstName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSecondName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMiddleName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.speciality.Speciality[] getSpecialities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.subject.Subject[] getSubjects() {
        return null;
    }
    
    public Teacher(int id, @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @org.jetbrains.annotations.NotNull
    java.lang.String secondName, @org.jetbrains.annotations.NotNull
    java.lang.String middleName, @org.jetbrains.annotations.NotNull
    java.lang.String info, @org.jetbrains.annotations.NotNull
    app.core.speciality.Speciality[] specialities, @org.jetbrains.annotations.NotNull
    app.core.subject.Subject[] subjects) {
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
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.speciality.Speciality[] component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.subject.Subject[] component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.teacher.Teacher copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String firstName, @org.jetbrains.annotations.NotNull
    java.lang.String secondName, @org.jetbrains.annotations.NotNull
    java.lang.String middleName, @org.jetbrains.annotations.NotNull
    java.lang.String info, @org.jetbrains.annotations.NotNull
    app.core.speciality.Speciality[] specialities, @org.jetbrains.annotations.NotNull
    app.core.subject.Subject[] subjects) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
}