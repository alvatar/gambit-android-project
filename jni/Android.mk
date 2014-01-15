# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
# The Gambit runtime
LOCAL_MODULE    := gambit
LOCAL_SRC_FILES := ./depends/libgambc.a
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE    := fusion-sphere
LOCAL_SRC_FILES := test-jni.c fib.c fib_.c
LOCAL_CFLAGS := -I./depends -fno-short-enums -I/usr/local/Gambit-C/include
LOCAL_STATIC_LIBRARIES := gambit
LOCAL_LDLIBS := -ldl -lc

include $(BUILD_SHARED_LIBRARY)
