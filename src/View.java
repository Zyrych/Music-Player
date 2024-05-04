import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class View {
    private JFrame frame;
    private JPanel menuPanel;
    private JButton songsButton, playlistButton, queueButton, selectFolderButton;
    private JPanel contentPanel;
    private JLabel songsSubHeader;
    private boolean audioFilesFound = false;
    private List<File> foundAudioFiles;

    public View() {
        createFrame();
        createMenuPanel();
        createContentPanel(); 
        handleSongsButtonClick();
        frame.setVisible(true);

    }

    private void handleSongsButtonClick() {
        Component songsContent = createSongsContent();
        setContentPane(songsContent);
    }


    public void createFrame() {
        frame = new JFrame("Music Player");
        frame.setLayout(new BorderLayout());
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.blue);
        menuPanel.setPreferredSize(new Dimension(300, 550));
        menuPanel.setLayout(new FlowLayout());

        songsButton = new JButton("Songs");
        playlistButton = new JButton("Playlist Button");
        queueButton = new JButton("Queue Button");

        menuPanel.add(songsButton);
        menuPanel.add(playlistButton);
        menuPanel.add(queueButton);

        frame.add(menuPanel, BorderLayout.WEST);
    }

    public void createContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        frame.add(contentPanel, BorderLayout.CENTER);
    }

    public void setContentPane(Component component) {
        contentPanel.removeAll();
        contentPanel.add(component, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public JButton getSongsBtn() {
        return songsButton;
    }

    public JButton getPlaylistsBtn() {
        return playlistButton;
    }

    public JButton getQueueBtn() {
        return queueButton;
    }


    public JButton getSelectFolderBtn() {
        return selectFolderButton;
    }


    public Component createSongsContent() {
        JPanel panel = new JPanel();

        JLabel songsHeader = new JLabel("Songs");
        songsSubHeader = new JLabel("No Music In Selected Directory");
        selectFolderButton = new JButton("Select Folder"); 

        setupSelectFolderButtonListener();

        panel.add(songsHeader);
        panel.add(songsSubHeader);
        panel.add(selectFolderButton);
        panel.setBackground(Color.RED);
        return panel;
    }


    public Component createPlaylistContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.add(new JLabel("Playlist Content"));
        return panel;
    }


    public Component createQueueContent() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.add(new JLabel("Queue Content"));
        return panel;
    }


    private void setupSelectFolderButtonListener() {
        selectFolderButton.addActionListener(e -> {
            // Open a file chooser dialog to select a folder
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select Folder");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                // Get the selected folder
                File selectedFolder = fileChooser.getSelectedFile();

                // Scan the selected folder for audio files
                List<File> audioFiles = scanAudioFiles(selectedFolder);

                if (audioFiles.isEmpty()) {
                    // Display message if no audio files were found
                    JOptionPane.showMessageDialog(frame, "No music files found in the selected directory.", "No Music Found", JOptionPane.INFORMATION_MESSAGE);
                    // Set audioFilesFound flag to false
                    setAudioFilesFound(false);
                } else {
                    // Set audioFilesFound flag to true
                    setAudioFilesFound(true);
                    // Store the found audio files
                    foundAudioFiles = audioFiles;
                    // Display the list of audio files in the songs content
                    displayAudioFiles(audioFiles);
                }
            }
        });
    }


    private List<File> scanAudioFiles(File folder) {
        List<File> audioFiles = new ArrayList<>();

        if (folder.isDirectory()) {
            // List files in the folder
            File[] files = folder.listFiles();

            if (files != null) {
                // Filter audio files
                for (File file : files) {
                    if (file.isFile() && isAudioFile(file)) {
                        audioFiles.add(file);
                    }
                }
            }
        }

        return audioFiles;
    }


    private boolean isAudioFile(File file) {
        String name = file.getName();
        return name.endsWith(".mp3") || name.endsWith(".wav"); // Add more audio file extensions if needed
    }


    void displayAudioFiles(List<File> audioFiles) {
        // Clear existing content in songs content panel
        contentPanel.removeAll();

        // Create a panel to display audio files
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel songsHeader = new JLabel("Songs: ");
        panel.add(songsHeader);

        // Add audio files to the panel
        for (File file : audioFiles) {
            JButton button = new JButton(file.getName());
            panel.add(button);
        }

        // Set the panel as the content of the songs content panel
        setContentPane(panel);
    }


    public void setAudioFilesFound(boolean found) {
        this.audioFilesFound = found;
    }

    public boolean areAudioFilesFound() {
        return audioFilesFound;
    }


    public List<File> getFoundAudioFiles() {
        return foundAudioFiles;
    }


}
