package com.example.android.miwok;

//import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

//import org.junit.runner.RunWith;
import org.testng.annotations.Test;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.android.miwok", appContext.getPackageName());
    }
}