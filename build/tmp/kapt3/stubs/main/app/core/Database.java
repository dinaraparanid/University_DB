package app.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lapp/core/Database;", "", "()V", "connection", "Ljava/sql/Connection;", "departmentRepository", "Lapp/core/department/DepartmentRepository;", "getDepartmentRepository", "()Lapp/core/department/DepartmentRepository;", "facultyRepository", "Lapp/core/faculty/FacultyRepository;", "getFacultyRepository", "()Lapp/core/faculty/FacultyRepository;", "groupRepository", "Lapp/core/group/GroupRepository;", "getGroupRepository", "()Lapp/core/group/GroupRepository;", "specialityRepository", "Lapp/core/speciality/SpecialityRepository;", "getSpecialityRepository", "()Lapp/core/speciality/SpecialityRepository;", "studentRepository", "Lapp/core/student/StudentRepository;", "getStudentRepository", "()Lapp/core/student/StudentRepository;", "subjectRepository", "Lapp/core/subject/SubjectRepository;", "getSubjectRepository", "()Lapp/core/subject/SubjectRepository;", "teacherRepository", "Lapp/core/teacher/TeacherRepository;", "getTeacherRepository", "()Lapp/core/teacher/TeacherRepository;", "Students"})
public final class Database {
    private static final java.sql.Connection connection = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.student.StudentRepository studentRepository = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.group.GroupRepository groupRepository = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.speciality.SpecialityRepository specialityRepository = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.teacher.TeacherRepository teacherRepository = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.subject.SubjectRepository subjectRepository = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.department.DepartmentRepository departmentRepository = null;
    @org.jetbrains.annotations.NotNull
    private static final app.core.faculty.FacultyRepository facultyRepository = null;
    @org.jetbrains.annotations.NotNull
    public static final app.core.Database INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull
    public final app.core.student.StudentRepository getStudentRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.group.GroupRepository getGroupRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.speciality.SpecialityRepository getSpecialityRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.teacher.TeacherRepository getTeacherRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.subject.SubjectRepository getSubjectRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.department.DepartmentRepository getDepartmentRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final app.core.faculty.FacultyRepository getFacultyRepository() {
        return null;
    }
    
    private Database() {
        super();
    }
}