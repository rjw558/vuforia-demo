/*===============================================================================
Copyright (c) 2016-2017 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2014 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/

package com.hermesinnovationlab.hermesplay.vuforia;

import com.hermesinnovationlab.hermesplay.vuforia.exceptions.VuforiaSessionException;
import com.vuforia.State;


//  Interface to be implemented by the activity which uses VuforiaSession
public interface VuforiaSessionControl
{
    
    // To be called to initialize the trackers
    boolean doInitTrackers();
    
    
    // To be called to load the trackers' data
    boolean doLoadTrackersData();
    
    
    // To be called to start tracking with the initialized trackers and their
    // loaded data
    boolean doStartTrackers();
    
    
    // To be called to stop the trackers
    boolean doStopTrackers();
    
    
    // To be called to destroy the trackers' data
    boolean doUnloadTrackersData();
    
    
    // To be called to deinitialize the trackers
    boolean doDeinitTrackers();
    
    
    // This callback is called after the Vuforia initialization is complete,
    // the trackers are initialized, their data loaded and
    // tracking is ready to start
    void onInitARDone(VuforiaSessionException e);
    
    
    // This callback is called every cycle
    void onVuforiaUpdate(State state);


    // This callback is called on Vuforia resume
    void onVuforiaResumed();


    // This callback is called once Vuforia has been started
    void onVuforiaStarted();

}
