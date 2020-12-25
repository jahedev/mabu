/*
 *  Minecraft Application Backup Utility (Mabu) - Backup utility for Minecraft
 *  Copyright (C) 2013 Jahed Hossain
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact Author: jahedev@gmail.com
 */

package mabu.preferences;

// if defaultMinecraftLocation is not valid, search and find it - defaultMinecraftLocation(), if it is not found, save preference as ""
//        prefs.put("defaultMinecraftLocation", validateMinecraftLocation() ? defaultMinecraftLocation : defaultMinecraftLocation());

import java.io.File;
import java.util.prefs.Preferences;

/**
 *
 * @author Jahed
 */
public class AppPreferences extends AppPreferenceHelper {
    
    private Preferences prefs;
    
    private String minecraftLocation;
    private String backupLocation;
    private String worldToBackup;
    private boolean defaultExtMBF;
    private boolean mbfAssociated;

    private String theme;

    public String getMinecraftLocation()
    {
        return minecraftLocation;
    }

    public void setMinecraftLocation(String minecraftLocation)
    {
        this.minecraftLocation = minecraftLocation;
    }

    public String getBackupLocation()
    {
        return backupLocation;
    }

    public void setBackupLocation(String backupLocation)
    {
        this.backupLocation = backupLocation;
    }

    public String getWorldToBackup()
    {
        return worldToBackup;
    }

    public void setWorldToBackup(String worldToBackup)
    {
        this.worldToBackup = worldToBackup;
    }
    
    public boolean isDefaultExtMBF()
    {
        return defaultExtMBF;
    }

    public void setDefaultExtMBF(boolean isDefaultExtMBF)
    {
        this.defaultExtMBF = isDefaultExtMBF;
    }
    
    public boolean isMbfAssociated()
    {
        return mbfAssociated;
    }

    public void setMbfAssociated(boolean mbfAssociated)
    {
        this.mbfAssociated = mbfAssociated;
    }
    
    public String getTheme()
    {
        return theme;
    }
    
    public void setTheme(String theme)
    {
        this.theme = theme;
    }
    
    public final void loadPreferences()
    {
        minecraftLocation = prefs.get("minecraftLocation", defaultMinecraftLocation());
        backupLocation = prefs.get("backupLocation", defaultBackupLocation());
        worldToBackup = prefs.get("worldToBackup", "");
        defaultExtMBF = prefs.getBoolean("isDefaultExtMBF", true);
        theme = prefs.get("theme", "Nimbus");
    }
    
    public void savePreferences()
    {
        prefs.put("minecraftLocation", minecraftLocation);
        prefs.put("backupLocation", backupLocation);
        prefs.put("worldToBackup", worldToBackup);
        prefs.putBoolean("isDefaultExtMBF", defaultExtMBF);
        prefs.put("theme", theme);
    }
    
    public AppPreferences()
    {
        prefs = Preferences.userRoot().node(this.getClass().getName());
        loadPreferences();
    }
    
    public boolean validateMinecraftLocation() // checks if actual Minecraft location is specified
    {
        File file = new File(minecraftLocation + "/saves");
        if (file.exists() && file.canRead() && file.canWrite()) // all it does if a folder called 'saves' exits under this location
            return true;
        else
            return false;
    }
    
    public boolean validateBackupLocation() // validates if directory exists and if write permission exists
    {
        File file = new File(backupLocation);
        if (file.exists() && file.canRead() && file.canWrite())
            return true;
        else
            return false;
    }
    
    public boolean validateWorldToBackup() // returns true if the world save still exists
    {
        File file = new File(backupLocation + "/saves/" + worldToBackup);
        if (file.exists() && file.canRead() && file.canWrite())
            return true;
        else
            return false;
    }
    
    public boolean validateEverything() // returns true if all 3 methods above returns true
    {
        return validateMinecraftLocation() && validateBackupLocation() && validateWorldToBackup();
    }
}
