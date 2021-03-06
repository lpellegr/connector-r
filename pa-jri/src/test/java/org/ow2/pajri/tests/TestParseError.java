/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ow2.pajri.tests;

import com.google.common.io.CharStreams;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ow2.pajri.PAJRIEngine;
import org.ow2.pajri.PAJRIFactory;

import javax.script.ScriptContext;
import java.io.Writer;

/**
 * Tests that an invalid script throws an exception
 *
 * @author Activeeon Team
 */
public class TestParseError extends testabstract.TestParseError {

    Writer disabledErrorWriter;

    @Before
    public void disableErrorWriter() {
        ScriptContext sc = ((PAJRIEngine) (new PAJRIFactory()).getScriptEngine()).getContext();
        disabledErrorWriter = sc.getErrorWriter();
        sc.setErrorWriter(CharStreams.nullWriter());
    }

    @Test
    public void test() throws Exception {
        super.test(PAJRIFactory.ENGINE_NAME);
    }

    @After
    public void renableErrorWriter() {
        ScriptContext sc = ((PAJRIEngine) (new PAJRIFactory()).getScriptEngine()).getContext();
        sc.setErrorWriter(disabledErrorWriter);
    }

}
