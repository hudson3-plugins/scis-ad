/*
 * The MIT License
 *
 * Copyright (c) 2004-2011, Oracle Corporation, Kohsuke Kawaguchi, Steven Christou
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hudson.plugins.scis_ad;

import org.jvnet.hudson.test.HudsonTestCase;

public class ScisSupportOfferTest extends HudsonTestCase {
    /**
     * Shouldn't be active by default.
     */
    public void testInitial() {
        assertFalse(new ScisSupportOffer().isActivated());
    }

    /**
     * Makes sure that dismiss works.
     */
    // this requires test harness bug fix in 1.320
    public void testDeactivate() throws Exception {
        ScisSupportOffer mon = (ScisSupportOffer) hudson.getAdministrativeMonitor(ScisSupportOffer.class.getName());
        mon.active = true;
        assertTrue(mon.isEnabled());
        submit(new WebClient().goTo("/manage").getFormByName(mon.id),"no");
        assertFalse(mon.isEnabled());
    }

    /**
     * Makes sure that remind-later works.
     */
    public void testRemindLater() throws Exception {
        ScisSupportOffer mon = (ScisSupportOffer) hudson.getAdministrativeMonitor(ScisSupportOffer.class.getName());
        mon.active = true;
        submit(new WebClient().goTo("/manage").getFormByName(mon.id),"later");
        assertTrue(mon.isEnabled());
        assertFalse(mon.active);

        // simulated reboot
        assertFalse(new ScisSupportOffer().active);
    }
}
