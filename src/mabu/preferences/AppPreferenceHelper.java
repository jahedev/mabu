/*
 *  Minecraft Application Backup Utility: A multi-platform backup utility for Minecraft running on java
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

import java.io.File;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author Jahed
 */
public class AppPreferenceHelper
{

    public static final String home = System.getProperty("user.home");
    public static final String minecraftWindowsDir = home + "\\AppData\\Roaming\\.minecraft";
    public static final String minecraftLinuxDir = home + "/.minecraft";
    public static final String minecraftOSXDir = home + "/Library/Application Support/minecraft";

    public static String detectOS() // returns the supported os-family name, if not running a recognized os, returns 'unsupported'
    {
        if (SystemUtils.IS_OS_WINDOWS)
        {
            return "windows";
        } else if (SystemUtils.IS_OS_LINUX)
        {
            return "linux";
        } else if (SystemUtils.IS_OS_MAC_OSX)
        {
            return "osx";
        } else
        {
            return "unsupported"; // the reason other OSes have not been detected is that Minecraft most commonly runs on these specific OSes
        }
    }

    public static String defaultMinecraftLocation() // Searches, and returns the location of minecraft on the specific OS, if not found it returns ""
    {
        switch (detectOS())
        {
            case "windows":
                if (new File(minecraftWindowsDir).exists())
                {
                    return minecraftWindowsDir;
                }
                break;
            case "linux":
                if (new File(minecraftLinuxDir).exists())
                {
                    return minecraftLinuxDir;
                }
                break;
            case "osx":
                if (new File(minecraftOSXDir).exists())
                {
                    return minecraftOSXDir;
                }
        }
        return ""; // could not find minecraft
    }

    public static String defaultBackupLocation()
    {
        File file;
        try
        {
            if (detectOS().equals("windows"))
            {
                file = new File(home + "\\MinecraftBackup");
                file.mkdir();
                return file.getAbsolutePath();
            } else
            {
                file = new File(home + "/.MinecraftBackup");
                file.mkdir();
                return file.getAbsolutePath();
            }

        } catch (Exception ex)
        {
            System.out.println("Error: On creating a default backup location \n" + System.err + "\n");
        }
        return "";
    }
}
