#!/usr/bin/make -f
#
# Makefile for C code
#

# C sources to compile

TARGET_DIR := ../../../target/classes
TARGET := $(TARGET_DIR)/libGetThreadID.so

WORKING_DIR := $(TARGET_DIR)/../jni

JAVA_BUILD_DIR := $(TARGET_DIR)


CC=gcc
OS=$(shell uname -s | tr '[A-Z]' '[a-z]')

ifeq ("$(OS)", "darwin")
JAVA_HOME?=$(shell /usr/libexec/java_home)
JAVA_HEADERS?=/System/Library/Frameworks/JavaVM.framework/Versions/A/Headers
PLATFORM_LDFLAGS=-mimpure-text
endif

ifeq ("$(OS)", "linux")
JAVA_HOME?=/usr/lib/jvm/java-8-oracle
JAVA_HEADERS=$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux
endif

CFLAGS=-Ijava_crw_demo -fno-strict-aliasing                                  \
        -fPIC -fno-omit-frame-pointer -W -Wall  -Wno-unused -Wno-parentheses \
        -I$(JAVA_HEADERS) -Iinclude
LDFLAGS=-fno-strict-aliasing -fPIC -fno-omit-frame-pointer \
        -shared $(PLATFORM_LDFLAGS)

JAVA_LIB := $(JAVA_HOME)/jre/lib
JVM_SHARED_LIBS := -L$(JAVA_LIB)/amd64/server -L$(JAVA_LIB)/i386/server  -L$(JAVA_LIB)/amd64/jrockit/ -L$(JAVA_LIB)/i386/jrockit/

INCLUDES := -I $(JAVA_HOME)/include -I $(JAVA_HOME)/include/linux -I $(WORKING_DIR)

# classpath for javah
ifdef CLASSPATH
JAVAH_CLASSPATH = $(JAVA_BUILD_DIR):$(CLASSPATH)
else
JAVAH_CLASSPATH = $(JAVA_BUILD_DIR)
endif

all: $(TARGET)

$(TARGET): GetThreadID.c $(WORKING_DIR)/org_kevoree_cthreadgroups_GetThreadID.h
	$(CC) $(CFLAGS) $(LDFLAGS) $(INCLUDES)/org_kevoree_cthreadgroups_GetThreadID.h GetThreadID.c -o $(TARGET) -lc

$(WORKING_DIR)/org_kevoree_cthreadgroups_GetThreadID.h: $(TARGET_DIR)/org/kevoree/cthreadgroups/GetThreadID.class
	mkdir -p $(TARGET_DIR)/jni
	javah -force -classpath $(JAVAH_CLASSPATH) -d $(WORKING_DIR) org.kevoree.cthreadgroups.GetThreadID