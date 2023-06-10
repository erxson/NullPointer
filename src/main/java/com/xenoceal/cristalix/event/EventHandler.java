/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.xdark.clientapi.event.Event
 */
package com.xenoceal.cristalix.event;

import com.xenoceal.cristalix.event.EventType;
import com.xenoceal.cristalix.module.Module;
import dev.xdark.clientapi.event.Event;

public interface EventHandler {
    public EventType type();

    public void handle(Module var1, Event var2);
}

