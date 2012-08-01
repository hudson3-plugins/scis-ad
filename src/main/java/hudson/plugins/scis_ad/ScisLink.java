/*******************************************************************************
*
* Copyright (c) 2012 Oracle Corporation.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Maintainer/Contributor: 
*
*    Kohsuke Kawaguchi, Steven Christou
*     
*
*******************************************************************************/

package hudson.plugins.scis_ad;

import hudson.model.ManagementLink;
import hudson.Extension;

@Extension
public class ScisLink extends ManagementLink {
    public String getIconFileName() {
        return "/plugin/scis-ad/shield48.gif";
    }

    public String getUrlName() {
        return "http://wiki.hudson-ci.org/display/HUDSON/Commercial+Support";
    }

    public String getDisplayName() {
        return "Get Support Subscription";
    }

    @Override
    public String getDescription() {
        return "Commercial support subscription available from Oracle.";
    }
}
