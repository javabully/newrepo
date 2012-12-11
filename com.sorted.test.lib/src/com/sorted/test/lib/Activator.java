package com.sorted.test.lib;

import java.net.URL;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.sorted.runtime.Platform;


public class Activator  implements BundleActivator {

	public final static String NAMESPACE = "com.sorted.test.lib";
	
	//The shared instance.
	private static Activator plugin;
	
	public Activator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
	
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	
	public Bundle getBundle() {
		
		return Platform.getBundle(NAMESPACE);
		
	}
	
	public URL getResource(String name) {

		return getBundle().getEntry(name);
		
	}

}
