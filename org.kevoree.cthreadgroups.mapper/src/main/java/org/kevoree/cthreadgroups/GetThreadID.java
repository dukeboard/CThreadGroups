package org.kevoree.cthreadgroups;

/**
 * Created by duke on 07/01/2014.
 */
public class GetThreadID {
    public static native int getTid();

    static {
        System.load("/Users/duke/Documents/dev/dukeboard/CThreadGroups/org.kevoree.cthreadgroups.mapper/target/classes/libGetThreadID.so");
    }
}