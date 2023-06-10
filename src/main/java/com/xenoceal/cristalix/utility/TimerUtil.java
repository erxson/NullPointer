/*
 * Decompiled with CFR 0.150.
 */
package com.xenoceal.cristalix.utility;

public final class TimerUtil {
    private long pause = 0L;
    private long time = 0L;

    public boolean isTimeReached() {
        if (this.time <= System.currentTimeMillis()) {
            this.time = System.currentTimeMillis() + this.pause;
            return true;
        }
        return false;
    }

    public void setTimeout(long l) {
        this.pause = l;
    }

    public void setPause() {
        this.time = System.currentTimeMillis() + this.pause;
    }
}

