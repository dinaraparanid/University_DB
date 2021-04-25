package app.core.polymorphism;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, xi = 2, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lapp/core/polymorphism/GetById;", "T", "", "getById", "", "id", "", "mod", "(II)[Ljava/lang/Object;", "Students"})
public abstract interface GetById<T extends java.lang.Object> {
    
    @org.jetbrains.annotations.NotNull
    public abstract T[] getById(int id, int mod);
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 3, xi = 2)
    public final class DefaultImpls {
    }
}