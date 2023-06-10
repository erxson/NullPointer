/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.xdark.clientapi.event.Event
 */
package com.xenoceal.cristalix.module;

import com.xenoceal.cristalix.NullPointer;
import com.xenoceal.cristalix.event.EventHandler;
import dev.xdark.clientapi.event.Event;
import java.util.Arrays;
import java.util.List;

public final class Module {
    private final String name;
    private boolean enabled;
    private int key;
    private final List<EventHandler> handlers;
    private Module(Builder builder) {
        this.name = Builder.access$000(builder);
        this.enabled = Builder.access$100(builder);
        this.key = Builder.access$200(builder);
        this.handlers = Builder.access$300(builder);
    }

    public String getName() {
        return this.name;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public void toggle() {
        this.setEnabled(!this.isEnabled());
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int n) {
        this.key = n;
    }

    public List<EventHandler> getHandlers() {
        return this.handlers;
    }

    public void invoke(Event event, EventHandler eventHandler) {
        eventHandler.handle(this, event);
    }

    Module(Builder builder, String name) {
        this(builder);
    }

    public static final class Builder {
        private String name;
        private boolean enabled;
        private int key;
        private List<NullPointer.MyEventHandler> handlers;

        public Builder name(String string) {
            this.name = string;
            return this;
        }

        public Builder enabled(boolean bl) {
            this.enabled = bl;
            return this;
        }

        public Builder key(int n) {
            this.key = n;
            return this;
        }

        public Builder handles(final NullPointer.MyEventHandler... array) {
            this.handlers = Arrays.asList(array);
            return this;
        }


        public void build(NullPointer nullPointer) {
            nullPointer.addModule(new Module(this, null));
        }

        public static Builder builder() {
            return new Builder();
        }

        static String access$000(Builder builder) {
            return builder.name;
        }

        static boolean access$100(Builder builder) {
            return builder.enabled;
        }

        static int access$200(Builder builder) {
            return builder.key;
        }

        static List access$300(Builder builder) {
            return builder.handlers;
        }
    }
}

