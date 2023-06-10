/*
 * Decompiled with CFR 0.150.
 */
package com.xenoceal.cristalix.event.handlers;

import com.xenoceal.cristalix.event.EventHandler;
import com.xenoceal.cristalix.event.EventType;

public interface RenderPassHandler
extends EventHandler {
    @Override
    default public EventType type() {
        return EventType.RENDER_PASS;
    }
}

