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

package mabu;

import mabu.panels.MainPanel;
import mabu.preferences.AppPreferences;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame
{
    private AppPreferences appPrefs;
    private static Debug debug;
    private AboutDialog aboutDialog;
    private SettingsDialog settingsDialog;
    
    // Look And Feel Settings
    private LookAndFeelInfo looks[] = UIManager.getInstalledLookAndFeels();
    private String[] lookNames = new String[looks.length];
    JMenuItem[] lafs; // Used as menu items of the names of themes
    protected String changedLookAndFeel; // Used by lafs[] action listeners

    // Constructor
    public Main()
    {
        appPrefs = new AppPreferences(); // create a SettingsFile, to set and use user-defined settings
        debug = new Debug(); // if the command line parameter "-debug" exists, it outputs info, useful for debugging

        aboutDialog = new AboutDialog();
        settingsDialog = new SettingsDialog();

        initUI(); // Installize user interface
    }

    private void initUI()
    {
        debug.printDebugInfo("Look and Feels Found: "); // debug.printDebugInfo(String s) only prints to CLI if app started with "-debug" parameter
        for (int i = 0; i < looks.length; i++)
        { // Gets all the names of look and feels and saves it into lookNames[]
            lookNames[i] = looks[i].getName();
            debug.printDebugInfo(lookNames[i]);
        }

        setLookAndFeel(appPrefs.getTheme()); // gets user-defined theme or by default its Nimbus

        final MainPanel panel = new MainPanel(this);

        //<editor-fold defaultstate="collapsed" desc="Installize MenuBar">
        JMenuBar menuBar = new JMenuBar(); // Menubar

        JMenu file = new JMenu("File");

        JMenuItem backupNow = new JMenuItem("Backup Now");
        backupNow.setMnemonic(KeyEvent.VK_B);
        backupNow.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    panel.forceButtonsActionPerformed("backupButton");
                }
                catch (Throwable ex)
                {
                    debug.printDebugInfo("Error: On executing 'Backup Now' menu command\n" + ex + "\n");
                }
            }
        });
        backupNow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));

        JMenuItem restoreSelected = new JMenuItem("Restore Selected");
        restoreSelected.setMnemonic(KeyEvent.VK_R);
        restoreSelected.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    panel.forceButtonsActionPerformed("restoreButton");
                }
                catch (Throwable ex)
                {
                    debug.printDebugInfo("Error: On executing 'Restore Selected' menu command\n" + ex + "\n");
                }
            }
        });
        restoreSelected.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

        // JMenuItem restoreLast = new JMenuItem("Restore Last"); // Restores very last backup
        
        JMenuItem refreshBackupFileList = new JMenuItem("Refresh Backup Files List");
        refreshBackupFileList.setMnemonic(KeyEvent.VK_L);
        refreshBackupFileList.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                panel.updatePreviousBackupListings();
            }
        });
        refreshBackupFileList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, ActionEvent.CTRL_MASK));

        JMenuItem exit = new JMenuItem("Exit");
        exit.setMnemonic(KeyEvent.VK_X);
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0); // Exits app the "0" is the errorlevel, if it exits with zero, nothing went wrong
            }
        });

        file.add(backupNow);
        file.add(restoreSelected);
        // file.add(restoreLast);
        file.addSeparator();
        file.add(refreshBackupFileList);
        file.addSeparator();
        file.add(exit);

        menuBar.add(file);

        JMenu edit = new JMenu("Edit");
        JMenu theme = new JMenu("Theme");
        lafs = new JMenuItem[lookNames.length]; // create a new JMenuItem array with the length of the number of available look and feels

        for (int i = 0; i < lookNames.length; i++)
        {
            lafs[i] = new JMenuItem(lookNames[i]);
            changedLookAndFeel = lookNames[i]; // So that ActionListener can get the name of the theme (it wouldn't be able to access 'i'
            lafs[i].addActionListener(new ActionListener()
            {
                String newLaf = changedLookAndFeel;

                @Override
                public void actionPerformed(ActionEvent event)
                {
                    appPrefs.setTheme(newLaf);
                    appPrefs.savePreferences(); // this saves the changed settings into a file called "settings"
                    JOptionPane.showMessageDialog(rootPane, "Theme set to " + newLaf + ". Restart for effect.", "Theme Changed", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            theme.add(lafs[i]);
        }

        JMenuItem allSettings = new JMenuItem("All Settings...");
        allSettings.setMnemonic(KeyEvent.VK_E);
        allSettings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (!settingsDialog.isVisible())
                {
                    settingsDialog.setVisible(true);
                }
            }
        });
        allSettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

        edit.add(theme);
        edit.add(allSettings);

        menuBar.add(edit);

        JMenu help = new JMenu("Help");

        JMenuItem about = new JMenuItem("About...");
        about.setMnemonic(KeyEvent.VK_A);
        about.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (!aboutDialog.isVisible())
                {
                    aboutDialog.setVisible(true);
                }
            }
        });

        help.add(about);
        menuBar.add(help);
        //</editor-fold>

        add(menuBar, BorderLayout.NORTH); // Add the menubar to the top of the JFrame, above the panel

        add(panel, BorderLayout.CENTER); // Add the panel to the center of the JFrame, below the menubar

        Dimension preferredSize = new Dimension(700, 450);

        setTitle("Minecraft Backup & Restore");
        setMinimumSize(preferredSize);
        setLocationRelativeTo(null); // Sets the location of the window the the center of the screen, otherwise it would be at the top-left corner
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setLookAndFeel(String lafString)
    { // Method used to change the look and feel of the application
        try
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if (lafString.equals(info.getName()))
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            debug.printDebugInfo("Error: On setting the theme:\n" + System.err + "\n");
        }
    }

    public static void main(String args[])
    {
        try
        {
            if (args.length != 0)
            {
                if (args[0].equalsIgnoreCase("-debug"))
                {
                    debug.setDebugEnabled(true);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error: On reading command-line arguments.\n" + System.err + "\n");
        }

        SwingUtilities.invokeLater(new Runnable()
        { // Causes run() to be executed asynchronously on the AWT event dispatching thread.
            @Override
            public void run()
            {
                Main main = new Main(); // Creates an object of itself in 'main' variable
                main.setVisible(true); // Shows the Window
            }
        });
    }
}