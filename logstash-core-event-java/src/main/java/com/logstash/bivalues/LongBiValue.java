package com.logstash.bivalues;

import org.jruby.Ruby;
import org.jruby.RubyInteger;
import org.jruby.javasupport.JavaUtil;

import java.io.ObjectStreamException;

public class LongBiValue extends BiValueCommon<RubyInteger, Long> implements BiValue<RubyInteger, Long> {

    public LongBiValue(RubyInteger rubyValue) {
        this.rubyValue = rubyValue;
        javaValue = null;
    }

    public LongBiValue(long javaValue) {
        this.javaValue = javaValue;
        rubyValue = null;
    }

    private LongBiValue() {
    }

    protected void addRuby(Ruby runtime) {
        rubyValue = (RubyInteger) JavaUtil.convertJavaToUsableRubyObject(runtime, javaValue);
    }

    protected void addJava() {
        javaValue = rubyValue.getLongValue();
    }

    // Called when object is to be serialized on a stream to allow the object to substitute a proxy for itself.
    private Object writeReplace() throws ObjectStreamException {
        return newProxy(this);
    }
}
