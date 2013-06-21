/*
 * The MIT License
 *
 * Copyright 2013 Pieter Van Eeckhout.
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
package com.pietervaneeckhout.waypointcoverter.controller.waypoint;

import com.pietervaneeckhout.waypointcoverter.controller.file.FileController;
import com.pietervaneeckhout.waypointcoverter.model.Waypoint;
import java.util.Collection;

/**
 * GPSCoordinateControler.java (UTF-8)
 *
 * <p>Controller for manipulating GPS coordinates.</p>
 *
 * 2013/06/08
 *
 * @author Pieter Van Eeckhout <vaneeckhout.pieter@gmail.com>
 * @since 1.0.0
 * @version 1.0.2
 */
public class WaypointController {
    
    private WaypointRepository waypointRepository;

    public WaypointController() {
        this(new WaypointRepository());
    }
    
    public WaypointController(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    public WaypointRepository getWaypointRepository() {
        return waypointRepository;
    }

    public void setWaypointRepository(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }
        
    public void toggleWaypointExport(String waypointName){
        Waypoint waypoint = waypointRepository.getWaypoint(waypointName);
        waypoint.toggleExport();
        waypointRepository.notifyObservers();
    }
    
    public void addWayPoint(Waypoint waypoint) {
        waypointRepository.addWaypoint(waypoint);
    }
    
    public void addWaypoints(Collection<Waypoint> waypoints) {
        for (Waypoint waypoint : waypoints) {
            this.addWayPoint(waypoint);
        }
    }
}