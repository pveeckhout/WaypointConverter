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
package com.honeyedoak.waypointcoverter.controller.waypoint;

import com.honeyedoak.waypointcoverter.exceptions.WaypointDoesNotExistException;
import com.honeyedoak.waypointcoverter.model.Waypoint;
import com.honeyedoak.waypointcoverter.exceptions.WaypointAlreadyExistsException;

import java.util.Collection;
import org.apache.log4j.Logger;

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
    private Logger logger;

    public WaypointController() {
        this(new WaypointRepository());
    }
    
    public WaypointController(WaypointRepository waypointRepository) {
        logger = Logger.getLogger(WaypointController.class);
        this.waypointRepository = waypointRepository;
    }

    public WaypointRepository getWaypointRepository() {
        return waypointRepository;
    }

    public void setWaypointRepository(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }
        
    public void toggleWaypointExport(String waypointName) throws WaypointDoesNotExistException {
       waypointRepository.toggleWaypointExport(waypointName);
    }
    
    public void addWayPoint(Waypoint waypoint) throws WaypointAlreadyExistsException {
        waypointRepository.addWaypoint(waypoint);
    }
    
    public void addWaypoints(Collection<Waypoint> waypoints) throws WaypointAlreadyExistsException {
        for (Waypoint waypoint : waypoints) {
            this.addWayPoint(waypoint);
        }
    }
}
