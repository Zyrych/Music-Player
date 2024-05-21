import java.io.File;
import java.io.FilenameFilter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.event.*;


public class Listeners {
    private GUI gui;
    private boolean isPlaying = false;


    public Listeners(GUI gui) {
        this.gui = gui;

        playPauseButtonListener();
        selectDirectoryButtonListener();
    }


    private void playPauseButtonListener() {
        gui.getPlayPauseButton().addActionListener(e -> {
            System.out.println("Play Button Clicked");
        });
    }


    private void selectDirectoryButtonListener() {
        gui.getSelectDirectoryButton().addActionListener(e -> {

            JFileChooser directorySelector = new JFileChooser();

            directorySelector.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            directorySelector.setAcceptAllFileFilterUsed(false); 
            directorySelector.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    // Accept directories and .mp3 files
                    return file.isDirectory() || file.getName().toLowerCase().endsWith(".mp3");
                }
    
                @Override
                public String getDescription() {
                    // Description for the file filter
                    return "Directories and MP3 Files";
                }
            });

            int returnVal = directorySelector.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File selectedDir = directorySelector.getSelectedFile();
                 if (selectedDir.isDirectory()) {
                    String selectedDirName = selectedDir.getName();
                    System.out.println("Selected the folder " + selectedDirName);

                    File[] musicFiles = selectedDir.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(".mp3");
                        }
                    });

                    if (musicFiles != null && musicFiles.length > 0) {
                        for (File musicFile : musicFiles) {
                            System.out.println(musicFile.getName());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No Music Files Found in the Selected Folder", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                 } else {
                    JOptionPane.showMessageDialog(null, "Please Select a Folder", "Error", JOptionPane.ERROR_MESSAGE);
                 }
                
            } else {
                JOptionPane.showMessageDialog(null, "No Folder Selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    
}