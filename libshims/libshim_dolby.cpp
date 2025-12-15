//
// SPDX-FileCopyrightText: The LineageOS Project
// SPDX-License-Identifier: Apache-2.0
//

#include <log/log.h>
#include <dlfcn.h>

extern "C" void _ZNK7android7RefBase9incStrongEPKv(void* thisptr, const void* id) {
    if (!thisptr) {
        ALOGE("DolbyShim: incStrong called on nullptr!");
        return;
    }
    typedef void (*RealFunc)(void*, const void*);
    static RealFunc real = (RealFunc)dlsym(RTLD_NEXT, "_ZNK7android7RefBase9incStrongEPKv");
    if (real) real(thisptr, id);
}

extern "C" void _ZNK7android7RefBase9decStrongEPKv(void* thisptr, const void* id) {
    if (!thisptr) {
        ALOGE("DolbyShim: decStrong called on nullptr!");
        return;
    }
    typedef void (*RealFunc)(void*, const void*);
    static RealFunc real = (RealFunc)dlsym(RTLD_NEXT, "_ZNK7android7RefBase9decStrongEPKv");
    if (real) real(thisptr, id);
}
